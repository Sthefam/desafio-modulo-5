package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    private MensagemRepository mensagemRepository;
    private UsuarioService usuarioService;

    @Autowired
    public MensagemService(MensagemRepository mensagemRepository, UsuarioService usuarioService) {
        this.mensagemRepository = mensagemRepository;
        this.usuarioService = usuarioService;
    }

    public Mensagem cadastrarMensagem(Mensagem mensagem){
        Usuario usuarioDestino = usuarioService.buscarUsuarioPeloEmail(mensagem.getUsuario_destino().getEmail());
        Usuario usuarioOrigem = usuarioService.buscarUsuarioPeloEmail(mensagem.getUsuario_origem().getEmail());
        mensagem.setUsuario_destino(usuarioDestino);
        mensagem.setUsuario_origem(usuarioOrigem);
        return mensagemRepository.save(mensagem);
    }
}
