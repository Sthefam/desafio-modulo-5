package br.com.zup.FaceZup.posts;

import br.com.zup.FaceZup.posts.dtos.CadastrarPostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostController {
    private ModelMapper modelMapper;
    private PostService postService;

    @Autowired
    public PostController(ModelMapper modelMapper, PostService postService) {
        this.modelMapper = modelMapper;
        this.postService = postService;
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarPost(@RequestBody @Valid CadastrarPostDTO postDTO){
        postService.cadastrarPost(postDTO.getAutor(),postDTO.getTexto());
    }

    @GetMapping("posts/{idPost}")
    public Post exibirPost(@PathVariable int id){
        return postService.buscarPostPeloId(id);
    }

}
