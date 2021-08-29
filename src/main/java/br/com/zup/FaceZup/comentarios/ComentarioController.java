package br.com.zup.FaceZup.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;


}
