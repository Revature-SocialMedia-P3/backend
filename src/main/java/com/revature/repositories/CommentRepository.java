package com.revature.repositories;

import com.revature.models.Comment;
import com.revature.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
