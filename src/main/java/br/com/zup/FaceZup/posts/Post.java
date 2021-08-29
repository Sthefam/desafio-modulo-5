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
    private Usuario usuarioAutor;
    @Column(nullable = false)
    private String texto;

    @OneToMany(mappedBy = "usuarioAutor")
    private List<Comentario> comentarios;

    public Post() {
    }

    public Post(Usuario usuarioAutor, String texto) {
        this.usuarioAutor = usuarioAutor;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
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
