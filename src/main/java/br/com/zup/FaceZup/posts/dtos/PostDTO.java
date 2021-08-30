package br.com.zup.FaceZup.posts.dtos;

import br.com.zup.FaceZup.comentarios.Comentario;
import br.com.zup.FaceZup.comentarios.dtos.ComentarioDTO;
import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.dtos.UsuarioDTO;

import java.util.List;

public class PostDTO {
    private int id;
    private UsuarioDTO autor;
    private String texto;
    private List<ComentarioDTO> comentarios;

    public PostDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioDTO getAutor() {
        return autor;
    }

    public void setAutor(UsuarioDTO autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}
