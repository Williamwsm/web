package com.example.rss_g1.service;

import com.example.rss_g1.model.Usuario;
import com.example.rss_g1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario cadastrar(Usuario novoUsuario) {
        Usuario usuario = usuarioRepository.findByEmail(novoUsuario.getEmail());
        if (usuario == null) {
            usuario = salvar(novoUsuario);
        }
        return usuario;
    }
}

