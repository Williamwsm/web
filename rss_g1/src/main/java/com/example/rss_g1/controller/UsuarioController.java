package com.example.rss_g1.controller;

import com.example.rss_g1.model.Usuario;
import com.example.rss_g1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/cadastro")
    public  void cadastrar( @RequestBody Usuario usuario) throws Exception {
        try {
            usuarioService.cadastrar(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @GetMapping("/buscar-todos")
    public void listar() throws Exception {
        try {
            usuarioService.listar();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @GetMapping("/buscar-usuario")
    public Usuario buscarUsuario(String email) throws Exception {
        try {
            return usuarioService.buscarUsuario(email);
        }catch (Exception e){
            throw new  Exception ("usuario nao encontrado");
        }
    }


}
