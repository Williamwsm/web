package com.example.rss_g1.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "noticias")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private Integer id;

    @Column( name = "titulo_noticia",nullable = false, length = 250)
    private String titulo;

    @Column(name = "endereco_img", length = 500)
    private String endImg;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(name = "data_publicacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPublicacao;

    @Column(name = "link_noticia", length = 250)
    private String link;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Noticia)) return false;
        Noticia noticia = (Noticia) o;
        return Objects.equals(getId(), noticia.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
