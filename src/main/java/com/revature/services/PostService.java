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

	/*

	public int likePost(int postId){
		Post post = postRepository.getById(postId);
		postRepository.addLike(post);
		return post.getLikes();
	}

	public int dislikePost(int postId){
		Post post = postRepository.getById(postId);
		postRepository.removeLike(post);
		return post.getLikes();
	}

	public int getLikeCount(int postId){
		Post post = postRepository.getById(postId);
		return post.getLikes();
	}
	 */
}
