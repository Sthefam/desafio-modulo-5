package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.exceptions.MensagemNaoEncontradaException;
import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

        throw new MensagemNaoEncontradaException("Mensagem não encontrada!");
    }

    public void cadastrarMensagem(String origem, String destino, String mensagem){
        Usuario usuarioDestino = usuarioService.buscarUsuarioPeloEmail(destino);
        Usuario usuarioOrigem = usuarioService.buscarUsuarioPeloEmail(origem);

        mensagemRepository.save(new Mensagem(mensagem, usuarioOrigem, usuarioDestino));
    }

    public void mensagemAutomatica(Mensagem mensagem){
        Usuario sistema = usuarioService.buscarUsuarioSistema();

        if(!mensagem.getOrigem().getEmail().equals(sistema.getEmail()) && !mensagem.isVisualizado()){
            String msg = "O "+mensagem.getDestino().getNome()+" leu sua mensagem. Talvez ele ignore ou não.";

            mensagemRepository.save(new Mensagem(msg,sistema,mensagem.getOrigem()));
        }
    }

    public Mensagem exibirMensagem(int id){
        Mensagem mensagem = buscaMensagemPeloId(id);

        if(!mensagem.isVisualizado()){
            mensagem.setDataHoraLeitura(LocalDateTime.now());
        }

        mensagemAutomatica(mensagem);
        mensagem.setVisualizado(true);

        return mensagemRepository.save(mensagem);
    }

}