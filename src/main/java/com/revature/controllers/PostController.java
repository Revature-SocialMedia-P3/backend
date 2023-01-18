package com.revature.controllers;

import java.util.List;
import java.util.Map;

import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.annotations.Authorized;
import com.revature.models.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "http://localhost:5555",
        "http://highscoreio-frontend-bucket.s3-website.us-east-2.amazonaws.com"
}, allowedHeaders = "*", exposedHeaders = "*", allowCredentials = "true", maxAge = 2592000)
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
    @GetMapping("/search")
    public ResponseEntity<List<User>> userSearch(@RequestParam String user) {
        return ResponseEntity.ok(this.postService.userSearch(user));
    }


}
