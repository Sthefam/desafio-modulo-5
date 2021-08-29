package br.com.zup.FaceZup.posts;

import br.com.zup.FaceZup.comentarios.Comentario;
import br.com.zup.FaceZup.usuario.Usuario;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario_autor",nullable = false)
    private Usuario autor;
    @Column(nullable = false)
    private String texto;

    @OneToMany(mappedBy = "autor")
    private List<Comentario> comentarios;

    public Post() {
    }

    public Post(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
