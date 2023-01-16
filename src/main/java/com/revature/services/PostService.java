package com.revature.services;

import java.util.List;

import com.revature.models.User;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getAll(User user) {
		return (List<Post>) this.postRepository.findAllByUser(user);
	}

	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}
//
//	public List<Post> getAllTop() {
//		return postRepository.findAllByPostType(PostType.Top);
//	}
}
