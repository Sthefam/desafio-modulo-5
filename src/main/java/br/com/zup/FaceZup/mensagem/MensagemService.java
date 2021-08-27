package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        return mensagemRepository.save(new Mensagem(mensagem, usuarioOrigem, usuarioDestino, LocalDate.now()));
    }

    public void mensagemAutomatica(Usuario destino){
        Usuario sistema = new Usuario;
        sistema.setEmail("sistema@email.com");
        String mensagem = "O {"+destino.getNome()+"} leu sua mensagem.";
        mensagemRepository.save(new Mensagem(mensagem,sistema,destino,LocalDate.now()));
    }

    public Mensagem exibirMensagem(int id){
        return buscaMensagemPeloId(id);
    }

}
