package br.com.zup.FaceZup.posts.dtos;

import br.com.zup.FaceZup.usuario.Usuario;

public class CadastrarPostDTO {
    private Usuario autor;
    private String texto;

    public CadastrarPostDTO() {
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
