package com.example.rss_g1.service;
import com.example.rss_g1.model.Noticia;
import com.example.rss_g1.repository.NoticiaRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class RssConsumidorService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    @Scheduled(fixedRate = 3600000)
    public void consumirFeedRss() {
        try {
            URL feedUrl = new URL("https://g1.globo.com/dynamo/rss2.xml");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            List<SyndEntry> entradas = feed.getEntries();
            for (SyndEntry entrada : entradas) {
                String titulo = entrada.getTitle();
                String link = entrada.getLink();
                String descricao = entrada.getDescription().getValue();
                String endImg = extrairUrlImagem(descricao);
                LocalDateTime dataPublicacaoLocalDateTime = entrada.getPublishedDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                Date dataPublicacao = Date.from(dataPublicacaoLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());


                // Verifica se a notícia já existe no banco de dados
                if (!noticiaRepository.existsByTitulo(titulo)){
                Noticia noticia = new Noticia();
                noticia.setTitulo(titulo);
                noticia.setLink(link);
                noticia.setDescricao(descricao); // Você pode querer limpar a descrição
                noticia.setEndImg(endImg);
                noticia.setDataPublicacao(dataPublicacao);
                noticiaRepository.save(noticia);
                }
            }
        } catch (FeedException | IOException e) {
            e.printStackTrace();
        }
    }
    private String extrairUrlImagem(String descricao) {
        // Usando regex para extrair a URL da imagem dentro da tag CDATA
        Pattern pattern = Pattern.compile("<img src=\"(.*?)\"");
        Matcher matcher = pattern.matcher(descricao);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null; // Retorna null se não encontrar a URL da imagem
    }
}
