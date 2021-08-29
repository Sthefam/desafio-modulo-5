package br.com.zup.FaceZup.comentarios.dtos;

public class CadastrarComentarioDTO {
    private String autor;
    private String texto;

    public CadastrarComentarioDTO() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
