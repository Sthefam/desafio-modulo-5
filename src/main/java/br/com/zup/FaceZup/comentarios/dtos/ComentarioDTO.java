package br.com.zup.FaceZup.comentarios.dtos;

import br.com.zup.FaceZup.usuario.Usuario;

public class ComentarioDTO {
    private int id;
    private Usuario autor;
    private String texto;

    public ComentarioDTO() {
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
}
