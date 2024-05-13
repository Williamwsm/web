package com.example.rss_g1.repository;

import com.example.rss_g1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Categoria findByNome(String nome);
}
