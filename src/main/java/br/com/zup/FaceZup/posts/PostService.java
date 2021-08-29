package br.com.zup.FaceZup.posts;

import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;
    private UsuarioService usuarioService;

    @Autowired
    public PostService(PostRepository postRepository, UsuarioService usuarioService) {
        this.postRepository = postRepository;
        this.usuarioService = usuarioService;
    }

    public void cadastrarPost(String autor, String texto){
        Usuario usuarioAutor = usuarioService.buscarUsuarioPeloEmail(autor);

        postRepository.save(new Post(usuarioAutor,texto));
    }

}
