package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserRepository userRepository;
	
	public PostService(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}


	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}

	public List<Post> getAllById(int id) {
		return this.postRepository.findAllByAuthor_Id(id);
	}
//
//	public List<Post> getAllTop() {
//		return postRepository.findAllByPostType(PostType.Top);
//	}
}
