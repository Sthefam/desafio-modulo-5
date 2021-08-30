package br.com.zup.FaceZup.comentarios;

import br.com.zup.FaceZup.comentarios.dtos.CadastrarComentarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/comentarios/post")
    public void cadastrarComentario(@RequestParam(required = false) int id, @RequestBody CadastrarComentarioDTO comentarioDTO){
        comentarioService.cadastrarComentario(comentarioDTO.getAutor(),comentarioDTO.getTexto(),id);
    }

}
