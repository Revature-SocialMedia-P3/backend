package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Post;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer>{

    List<Post> findAllByAuthor_IdOrderByDateDesc(int id);

    List<Post> findTop20ByOrderByDateDesc();

    Post findTop1ByGameOrderByTime(String game);
}
