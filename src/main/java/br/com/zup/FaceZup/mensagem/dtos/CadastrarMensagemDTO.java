package br.com.zup.FaceZup.mensagem.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastrarMensagemDTO {
    @NotBlank(message = "{validation.mensagem.texto}")
    private String mensagem;
    @Email(message = "{validation.mensagem.origem}")
    private String origem;
    @Email(message = "{validation.mensagem.destino}")
    private String destino;

    public CadastrarMensagemDTO() {
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
