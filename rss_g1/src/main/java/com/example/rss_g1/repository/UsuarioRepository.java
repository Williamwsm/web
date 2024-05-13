package com.example.rss_g1.repository;

import com.example.rss_g1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findOrCreate(String emailDoUsuario);
}
