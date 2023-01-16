package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post_comment")
@Data //toString, hashcode, equals, getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name="post_id", nullable = false)
    private long postId;

    @ManyToOne
    @JoinColumn(name="commenter", nullable = false)
    private User commenter;

    @Column(name="date")
    private Date date;

    @Column(name="content")
    private String content;

//    public ForumComment(ForumCommentRequest forumCommentRequest, User user) {
//        this.commenter = user;
//        this.postId = forumCommentRequest.getPostId();
//        this.date = forumCommentRequest.getDate();
//        this.content = forumCommentRequest.getContent();
//    }

}
