package br.com.zup.FaceZup.usuario;

import br.com.zup.FaceZup.mensagem.Mensagem;
import br.com.zup.FaceZup.mensagem.MensagemRepository;
import br.com.zup.FaceZup.mensagem.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private MensagemRepository mensagemRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(MensagemRepository mensagemRepository, UsuarioRepository usuarioRepository) {
        this.mensagemRepository = mensagemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarUsuarioPeloEmail(String email){
        Optional<Usuario> usuario = usuarioRepository.findById(email);
        if(usuario.isPresent()){
            return usuario.get();
        }
        throw new RuntimeException("Usuário não encontrado!");
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Mensagem> filtrarPorMensagensNaoLidas(String email){
        List<Mensagem> mensagens = mensagemRepository.findByVisualizadoFalseAndDestinoEmailContains(email);
        return mensagens;
    }

}
