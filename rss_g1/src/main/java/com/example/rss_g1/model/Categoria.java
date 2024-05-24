package com.example.rss_g1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;
    @Column(name = "nome_categoria")
    private String nome;

    // Relacionamento com Noticia
    @OneToMany(mappedBy = "categoria")
    private List<Noticia> noticias;

    }
