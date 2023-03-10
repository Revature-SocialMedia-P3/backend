package com.revature.models;

import java.util.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author ;
	private Date date;

	private String game;

	private int time;

	private String youtubeURL;

	private String content;

	@OneToMany(
			mappedBy = "postId",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			targetEntity = Comment.class
	)
	private List<Comment> postComments = new ArrayList<>();

}
