package br.com.zup.FaceZup.posts;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findAllByAutorEmailContains(String email);

}
