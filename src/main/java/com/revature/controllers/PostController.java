package com.revature.controllers;

import java.util.List;

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

    @PostMapping("/upsert")
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
    	return ResponseEntity.ok(this.postService.upsert(post));
    }
//
//    @GetMapping("/feed")
//    public ResponseEntity<List<Post>> getAllTopPosts() {
//        return ResponseEntity.ok(this.postService.getAllTop());
//    }

}
