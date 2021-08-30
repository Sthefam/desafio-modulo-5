package br.com.zup.FaceZup.posts;

import br.com.zup.FaceZup.exceptions.NotFoundException;
import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UsuarioService usuarioService;

    @Autowired
    public PostService(PostRepository postRepository, UsuarioService usuarioService) {
        this.postRepository = postRepository;
        this.usuarioService = usuarioService;
    }

    public Post buscarPostPeloId(int id){
        Optional<Post> optionalPost = postRepository.findById(id);

        if(optionalPost.isPresent()){
            return optionalPost.get();
        }

        throw new NotFoundException("Post não encontrado!");
    }

    public void cadastrarPost(String autor, String texto){
        Usuario usuarioAutor = usuarioService.buscarUsuarioPeloEmail(autor);

        postRepository.save(new Post(usuarioAutor,texto));
    }

}
