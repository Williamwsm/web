package com.example.rss_g1.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_usuario",nullable = false, length = 100)
    private String nome;

    @Column(length = 20)
    private String telefone;

    @Column(nullable = false, unique = true, length = 150)
    private String login;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_usuario", nullable = false)
    private StatusUsuario status;
    @ManyToMany
    @JoinTable(
            name = "usuario_categoria",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categoriasPreferidas;

    // hashCode e equals
    @Override
    public int hashCode() {
        return Objects.hash(id, login, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(login, usuario.login) &&
                Objects.equals(email, usuario.email);
    }

    // toString
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tefone='" + telefone + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", status=" + status +
                '}';
    }
}
