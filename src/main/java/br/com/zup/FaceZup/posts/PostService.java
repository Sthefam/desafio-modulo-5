package br.com.zup.FaceZup.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;

    public void cadastrarPost(Post post){
        postRepository.save(post);
    }

}
