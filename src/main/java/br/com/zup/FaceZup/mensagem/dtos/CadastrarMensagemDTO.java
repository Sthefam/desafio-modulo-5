package br.com.zup.FaceZup.mensagem.dtos;

import br.com.zup.FaceZup.usuario.Usuario;

public class CadastrarMensagemDTO {

    private int id;
    private String mensagem;
    private Usuario origem;
    private Usuario destino;

    public CadastrarMensagemDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getOrigem() {
        return origem;
    }

    public void setOrigem(Usuario origem) {
        this.origem = origem;
    }

    public Usuario getDestino() {
        return destino;
    }

    public void setDestino(Usuario destino) {
        this.destino = destino;
    }
}
