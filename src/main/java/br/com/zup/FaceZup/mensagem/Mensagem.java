package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.usuario.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensagens")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String mensagem;
    @ManyToOne
    @JoinColumn(name = "usuario_origem", nullable = false)
    private Usuario origem;
    private boolean visualizado;
    private LocalDateTime dataHoraLeitura;
    @ManyToOne
    @JoinColumn(name = "usuario_destino", nullable = false)
    private Usuario destino;

    public Mensagem(String mensagem, Usuario origem, Usuario destino, LocalDateTime dataHoraLeitura) {
        this.mensagem = mensagem;
        this.origem = origem;
        this.destino = destino;
        this.dataHoraLeitura = dataHoraLeitura;
    }

    public Mensagem(String mensagem, Usuario origem, Usuario destino) {
        this.mensagem = mensagem;
        this.origem = origem;
        this.destino = destino;
    }

    public Mensagem() {
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

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }

    public LocalDateTime getDataHoraLeitura() {
        return dataHoraLeitura;
    }

    public void setDataHoraLeitura(LocalDateTime dataHoraLeitura) {
        this.dataHoraLeitura = dataHoraLeitura;
    }
}
