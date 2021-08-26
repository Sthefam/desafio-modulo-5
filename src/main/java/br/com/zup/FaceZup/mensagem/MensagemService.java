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
        Usuario usuarioDestino = usuarioService.buscarUsuarioPeloEmail(mensagem.getUsuarioDestino().getEmail());
        Usuario usuarioOrigem = usuarioService.buscarUsuarioPeloEmail(mensagem.getUsuarioOrigem().getEmail());
        mensagem.setUsuarioOrigem(usuarioOrigem);
        mensagem.setUsuarioDestino(usuarioDestino);
        return mensagemRepository.save(mensagem);
    }
}
