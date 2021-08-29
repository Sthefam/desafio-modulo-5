package br.com.zup.FaceZup.posts.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastrarPostDTO {
    @Email(message = "{validation.usuario.email}")
    private String autor;
    @NotBlank(message = "{validation.post.texto}")
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
