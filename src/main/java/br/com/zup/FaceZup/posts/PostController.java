package br.com.zup.FaceZup.posts;

import br.com.zup.FaceZup.posts.dtos.CadastrarPostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
        postService.cadastrarPost(modelMapper.map(postDTO,Post.class));
    }


}
