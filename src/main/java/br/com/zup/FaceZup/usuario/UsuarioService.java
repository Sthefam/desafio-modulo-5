package br.com.zup.FaceZup.usuario;

import br.com.zup.FaceZup.exceptions.UsuarioNaoEncontradoException;
import br.com.zup.FaceZup.mensagem.Mensagem;
import br.com.zup.FaceZup.mensagem.MensagemRepository;
import br.com.zup.FaceZup.posts.Post;
import br.com.zup.FaceZup.posts.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private MensagemRepository mensagemRepository;
    private UsuarioRepository usuarioRepository;
    private PostRepository postRepository;

    @Autowired
    public UsuarioService(MensagemRepository mensagemRepository, UsuarioRepository usuarioRepository, PostRepository postRepository) {
        this.mensagemRepository = mensagemRepository;
        this.usuarioRepository = usuarioRepository;
        this.postRepository = postRepository;
    }

    public Usuario buscarUsuarioPeloEmail(String email){
        Optional<Usuario> usuario = usuarioRepository.findById(email);

        if(usuario.isPresent()){
            return usuario.get();
        }

        throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
    }

    public boolean usuarioExiste(String email){
        return usuarioRepository.existsById(email);
    }

    public void cadastrarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioSistema(){
        if(!usuarioExiste("sistema@email.com")){
            return usuarioRepository.save(new Usuario("Sistema","Automático","sistema@email.com","TI-Interno"));
        }

        return buscarUsuarioPeloEmail("sistema@email.com");
    }

    public List<Mensagem> filtrarPorMensagensNaoLidas(String email){
        if(usuarioExiste(email)){
            return mensagemRepository.findByVisualizadoFalseAndDestinoEmailContains(email);
        }

        throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
    }

    public List<Post> exibirTodosOsPostPorEmail(String email){
        if(usuarioExiste(email)){
            return postRepository.findAllByAutorEmailContains(email);
        }

        throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
    }

}
