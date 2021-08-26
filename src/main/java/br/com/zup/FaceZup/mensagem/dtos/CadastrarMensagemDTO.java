package br.com.zup.FaceZup.mensagem.dtos;

import br.com.zup.FaceZup.usuario.Usuario;

public class CadastrarMensagemDTO {

    private int id;
    private String mensagem;
    private String origem;
    private String destino;

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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
