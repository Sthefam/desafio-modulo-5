package br.com.zup.FaceZup.comentarios;

import br.com.zup.FaceZup.usuario.Usuario;
import br.com.zup.FaceZup.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    private UsuarioService usuarioService;
    private ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(UsuarioService usuarioService, ComentarioRepository comentarioRepository) {
        this.usuarioService = usuarioService;
        this.comentarioRepository = comentarioRepository;
    }

    public void cadastrarComentario(Comentario comentario){
        Usuario usuarioAutor = usuarioService.buscarUsuarioPeloEmail(comentario.getAutor().getEmail());

        comentarioRepository.save(new Comentario(usuarioAutor,comentario.getTexto()));
    }

}
