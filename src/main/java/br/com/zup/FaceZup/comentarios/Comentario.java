package br.com.zup.FaceZup.comentarios;

import br.com.zup.FaceZup.posts.Post;
import br.com.zup.FaceZup.usuario.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario_autor", nullable = false)
    private Usuario autor;
    @Column(nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false)
    private Post post;

    public Comentario() {
    }

    public Comentario(Usuario autor, String texto, Post post) {
        this.autor = autor;
        this.texto = texto;
        this.post = post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
