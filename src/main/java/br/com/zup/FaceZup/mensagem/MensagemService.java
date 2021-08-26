package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MensagemService {
    private MensagemRepository mensagemRepository;
    private UsuarioService usuarioService;

    @Autowired
    public MensagemService(MensagemRepository mensagemRepository, UsuarioService usuarioService) {
        this.mensagemRepository = mensagemRepository;
        this.usuarioService = usuarioService;
    }

    public Mensagem buscaMensagemPeloId(int id){
        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(id);

        if(mensagemOptional.isPresent()){
            return mensagemOptional.get();
        }
        throw new RuntimeException("Mensagem não encontrada!");
    }

    public Mensagem cadastrarMensagem(String origem, String destino, String mensagem){
        Usuario usuarioDestino = usuarioService.buscarUsuarioPeloEmail(destino);
        Usuario usuarioOrigem = usuarioService.buscarUsuarioPeloEmail(origem);
        return mensagemRepository.save(new Mensagem(mensagem, usuarioOrigem, usuarioDestino));
    }

    public Mensagem exibirMensagem(int id){
        return buscaMensagemPeloId(id);
    }

}
