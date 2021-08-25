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
    private Usuario usuario_origem;
    @ManyToOne
    private Usuario usuario_destino;

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

    public Usuario getUsuario_origem() {
        return usuario_origem;
    }

    public void setUsuario_origem(Usuario usuario_origem) {
        this.usuario_origem = usuario_origem;
    }

    public Usuario getUsuario_destino() {
        return usuario_destino;
    }

    public void setUsuario_destino(Usuario usuario_destino) {
        this.usuario_destino = usuario_destino;
    }
}
