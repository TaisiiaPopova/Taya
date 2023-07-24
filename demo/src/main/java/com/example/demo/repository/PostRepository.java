package com.example.demo.repository;

import com.example.demo.repository.model.Post;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;

@Qualifier("springDataPostRepository")
public interface PostRepository extends Repository<Post, Integer>{
    List<Post> getByUserId(int userId);
/*    void delete(int postId);//*/
    Post save(Post post);
    int countByUserId(int userId);
    Post getById (int postId);
    int edit(int postId, Post post);
    Collection<Post> findAll();
}
