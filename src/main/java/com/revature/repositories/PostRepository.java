package com.revature.repositories;

import com.revature.models.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Post;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer>{

/*
    @Query(value = "UPDATE posts SET Likes = Likes + 1 WHERE id = :id")
    List<Post> addLike(Post post);


    @Query(value="UPDATE posts SET Likes = Likes - 1 WHERE id = :id")
    List<Post> removeLike(Post post);

    @Query(value = "SELECT likes FROM posts WHERE id = :id")
    Post getLikes();
*/



    List<Post> findAllByPostType(PostType postType);

    Post getById(int id);

}
