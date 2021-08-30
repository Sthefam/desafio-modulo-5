package br.com.zup.FaceZup.comentarios;

import br.com.zup.FaceZup.posts.Post;
import br.com.zup.FaceZup.posts.PostService;
import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    private UsuarioService usuarioService;
    private PostService postService;
    private ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(UsuarioService usuarioService, ComentarioRepository comentarioRepository, PostService postService) {
        this.usuarioService = usuarioService;
        this.comentarioRepository = comentarioRepository;
        this.postService = postService;
    }

    public void cadastrarComentario(String autor, String texto, int id){
        Post post = postService.buscarPostPeloId(id);
        Usuario usuarioAutor = usuarioService.buscarUsuarioPeloEmail(autor);

        comentarioRepository.save(new Comentario(usuarioAutor,texto, post));
    }

}
