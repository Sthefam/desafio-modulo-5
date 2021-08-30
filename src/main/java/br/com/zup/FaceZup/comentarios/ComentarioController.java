package br.com.zup.FaceZup.comentarios;

import br.com.zup.FaceZup.comentarios.dtos.CadastrarComentarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/comentario/post/{idPost}")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarComentario(@PathVariable int idPost, @RequestBody @Valid CadastrarComentarioDTO comentarioDTO){
        comentarioService.cadastrarComentario(comentarioDTO.getAutor(),comentarioDTO.getTexto(),idPost);
    }

}
