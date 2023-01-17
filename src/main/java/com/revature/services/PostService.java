package com.revature.services;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserRepository userRepository;
	private String[] games = {"DDNR", "Italian Kart Racing", "Ping", "DigCraft", "ZergWARS"};
	
	public PostService(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}


	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}

	public List<Post> getAllById(int id) {
		return this.postRepository.findAllByAuthor_IdOrderByDateDesc(id);
	}

	public List<Post> getTopPosts() {
		return this.postRepository.findTop10ByOrderByDateDesc();
	}

	public Map<String, Post> getLeaderboard() {
		Map<String, Post> ret = new TreeMap<>();
		for (String s : this.games){
			ret.put(s, this.postRepository.findTop1ByGameOrderByTime(s));
		}
		return ret;
	}

	public List<User> userSearch(String user) {
		return this.userRepository.findByUsernameContains(user);
	}


//	public List<Post> getAllTop() {
//		return postRepository.findAllByPostType(PostType.Top);
//	}
}
