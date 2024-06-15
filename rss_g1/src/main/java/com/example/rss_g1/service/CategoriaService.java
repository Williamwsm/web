package com.example.rss_g1.service;


import com.example.rss_g1.model.Categoria;
import com.example.rss_g1.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<String> listarCategoria(){
        return categoriaRepository.findAllNomes();
    }
    public void listar(){
        for (Categoria c: categoriaRepository.findAll()){
            System.out.println(c);
        }
    }

    public  void salvarCategoria(Categoria novaCategoria){
        Categoria categoria = categoriaRepository.findByNome(novaCategoria.getNome());
        if (categoria == null){
            categoriaRepository.save(novaCategoria);
        }
    }
}
