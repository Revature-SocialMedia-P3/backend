package com.revature.services;

import java.util.List;

import com.revature.models.PostType;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getAll() {
		return this.postRepository.findAll();
	}

	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}

	public List<Post> getAllTop() {
		return postRepository.findAllByPostType(PostType.Top);
	}

	public List<Post> likePost(Post post){
		post = postRepository.getById(post.getId());
		return postRepository.addLike(post);
	}

	public List<Post> dislikePost(Post post){
		post = postRepository.getById(post.getId());
		return postRepository.removeLike(post);
	}


}
