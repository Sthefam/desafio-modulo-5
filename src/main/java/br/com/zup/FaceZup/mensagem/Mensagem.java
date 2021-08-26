package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.usuario.Usuario;

import javax.persistence.*;

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
    private Usuario usuarioOrigem;
    @ManyToOne
    @JoinColumn(name = "usuario_destino", nullable = false)
    private Usuario usuarioDestino;

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

    public Usuario getUsuarioOrigem() {
        return usuarioOrigem;
    }

    public void setUsuarioOrigem(Usuario usuarioOrigem) {
        this.usuarioOrigem = usuarioOrigem;
    }

    public Usuario getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(Usuario usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }
}
