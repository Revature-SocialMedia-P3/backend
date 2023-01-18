package com.revature.controllers;

import java.util.List;
import java.util.Map;

import com.revature.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.models.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5555"}, allowedHeaders = "*", exposedHeaders = "*", allowCredentials = "true", maxAge = 3600)
public class PostController {

	private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    

    @GetMapping("/my-feed/{id}")
    public ResponseEntity<List<Post>> getAllMyPosts(@PathVariable int id) {
    	return ResponseEntity.ok(this.postService.getAllById(id));
    }
    @GetMapping("/top-feed")
    public ResponseEntity<List<Post>> getTopPosts(){
        return ResponseEntity.ok(this.postService.getTopPosts());
    }
    @GetMapping("/leaderboard")
    public ResponseEntity <Map<String, Post>> getLeaderboard(){
        return ResponseEntity.ok(this.postService.getLeaderboard());
    }

    @PostMapping("/upsert")
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
    	return ResponseEntity.ok(this.postService.upsert(post));
    }
    @PostMapping("/comment")
    public  ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.postService.createComment(comment));
    }



}
