package com.example.rss_g1.controller;

import com.example.rss_g1.model.Categoria;
import com.example.rss_g1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/tipos")
    public List<String> categoriasNomes() throws Exception {
        try {
            return  categoriaService.listarCategoria();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Categoria categoria){
        try {
            categoriaService.salvarCategoria(categoria);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
