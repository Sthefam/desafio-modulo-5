package br.com.zup.FaceZup.mensagem;

import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        throw new RuntimeException("Mensagem não encontrada!");
    }

    public void cadastrarMensagem(String origem, String destino, String mensagem){
        Usuario usuarioDestino = usuarioService.buscarUsuarioPeloEmail(destino);
        Usuario usuarioOrigem = usuarioService.buscarUsuarioPeloEmail(origem);

        mensagemRepository.save(new Mensagem(mensagem, usuarioOrigem, usuarioDestino));
    }

    public void mensagemAutomatica(Mensagem mensagem){
        Usuario sistema = usuarioService.buscarUsuarioPeloEmail("sistema@email.com");
        String msg = "O {"+mensagem.getDestino().getNome()+"} leu sua mensagem.";

        mensagemRepository.save(new Mensagem(msg,sistema,mensagem.getOrigem(),LocalDate.now()));
    }

    public Mensagem exibirMensagem(int id){
        Mensagem mensagem = buscaMensagemPeloId(id);
        mensagem.setVisualizado(true);
        mensagem.setDataHoraLeitura(LocalDate.now());
        mensagemAutomatica(mensagem);

        return mensagemRepository.save(mensagem);
    }

}
