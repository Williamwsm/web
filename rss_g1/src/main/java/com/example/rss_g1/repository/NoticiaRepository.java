package com.example.rss_g1.repository;

import com.example.rss_g1.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia,Integer> {
    boolean existsByTituloAndDataPublicacao(String titulo, Date dataPublicacao);
    @Query("SELECT COUNT(n) > 0 FROM Noticia n WHERE n.titulo = :titulo")
    boolean existsByTitulo(String titulo);
}
