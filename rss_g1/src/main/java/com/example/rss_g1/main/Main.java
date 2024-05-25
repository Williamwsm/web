package com.example.rss_g1.main;

import com.example.rss_g1.model.StatusUsuario;
import com.example.rss_g1.model.Usuario;
import com.example.rss_g1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.rss_g1.service.UsuarioService.conversaoData;


@Component
public class Main implements CommandLineRunner {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();

        usuarioService.cadastrar(usuario.builder().nome("luana")
                .email("padariaAssuncao@hotmail.com")
                .login("1236688541")
                .telefone("(79)441343445")
                .status(StatusUsuario.ATIVO)
                .dataNascimento(conversaoData("15111992")).build());

        usuarioService.listar();
    }
}


