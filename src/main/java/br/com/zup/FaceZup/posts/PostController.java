package br.com.zup.FaceZup.posts;

import br.com.zup.FaceZup.comentarios.ComentarioService;
import br.com.zup.FaceZup.comentarios.dtos.CadastrarComentarioDTO;
import br.com.zup.FaceZup.posts.dtos.CadastrarPostDTO;
import br.com.zup.FaceZup.posts.dtos.PostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostController {
    private ModelMapper modelMapper;
    private PostService postService;
    private ComentarioService comentarioService;

    @Autowired
    public PostController(ModelMapper modelMapper, PostService postService, ComentarioService comentarioService) {
        this.modelMapper = modelMapper;
        this.postService = postService;
        this.comentarioService = comentarioService;
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarPost(@RequestBody @Valid CadastrarPostDTO postDTO){
        postService.cadastrarPost(postDTO.getAutor(),postDTO.getTexto());
    }

    @GetMapping("/post/{idPost}")
    public PostDTO exibirPost(@PathVariable int idPost){
        return modelMapper.map(postService.buscarPostPeloId(idPost), PostDTO.class);
    }


}
