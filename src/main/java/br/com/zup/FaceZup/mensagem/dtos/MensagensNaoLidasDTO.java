package br.com.zup.FaceZup.mensagem.dtos;

import java.util.List;

public class MensagensNaoLidasDTO {

    private int quantidade;
    private List<MensagensIdsDTO> ids;

    public MensagensNaoLidasDTO(int quantidade, List<MensagensIdsDTO> ids) {
        this.quantidade = quantidade;
        this.ids = ids;
    }

    public MensagensNaoLidasDTO() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<MensagensIdsDTO> getIds() {
        return ids;
    }

    public void setIds(List<MensagensIdsDTO> ids) {
        this.ids = ids;
    }
}
