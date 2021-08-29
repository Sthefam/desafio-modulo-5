package br.com.zup.FaceZup.posts.dtos;

import br.com.zup.FaceZup.usuario.Usuario;

public class CadastrarPostDTO {
    private String autor;
    private String texto;

    public CadastrarPostDTO() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String  autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
