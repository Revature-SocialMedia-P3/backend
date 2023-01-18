package com.revature.services;

import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.CommentRepository;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PostServiceTest {
@Autowired
PostService postService;

@Autowired
UserService userService;

@MockBean
PostRepository dao;

@MockBean
UserRepository dao2;

@MockBean
CommentRepository dao3;

    @Test
    public void getTopPosts(){
        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        Post testPost = new Post();

        posts.add(post);
        posts.add(testPost);

        when(dao.findTop20ByOrderByDateDesc()).thenReturn(posts);

        List<Post> postsList = postService.getTopPosts();

        assertEquals(2, postsList.size());
        verify(dao, times(1)).findTop20ByOrderByDateDesc();
    }


    @Test
    void upsert() {
        Post post = new Post();
        when(dao.save(post)).thenReturn(post);
        postService.upsert(post);
        verify(dao,times(1)).save(post);
    }

    @Test
    void getAllById() {
        Post post = new Post();
        post.setId(1);
      List<Post> posts = new ArrayList<>();
      posts.add(post);



        when(dao.findAllByAuthor_IdOrderByDateDesc(1)).thenReturn(posts);

        List<Post> postsList = postService.getAllById(1);

        assertEquals(1, postsList.size());
        verify(dao, times(1)).findAllByAuthor_IdOrderByDateDesc(1);
    }

    @Test
    void getLeaderboard() {
        Post post = new Post();
        Post testPost = new Post();
        Post testPost2 = new Post();

        post.setTime(1);
        testPost.setTime(2);
        testPost2.setTime(340);

        post.setGame("ZergWARS");
        testPost.setGame("ZergWARS");
        testPost2.setGame("ZergWARS");

        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(testPost2);
        posts.add(testPost);


        when(dao.findTop1ByGameOrderByTime("DDNR")).thenReturn(null);
        when(dao.findTop1ByGameOrderByTime("Italian Kart Racing")).thenReturn(null);
        when(dao.findTop1ByGameOrderByTime("Ping")).thenReturn(null);
        when(dao.findTop1ByGameOrderByTime("DigCraft")).thenReturn(null);
        when(dao.findTop1ByGameOrderByTime("ZergWARS")).thenReturn(post);


        Map<String, Post> testMap = postService.getLeaderboard();


        assertEquals(5, testMap.size());

        verify(dao, times(1)).findTop1ByGameOrderByTime("DDNR");
        verify(dao, times(1)).findTop1ByGameOrderByTime("Italian Kart Racing");
        verify(dao, times(1)).findTop1ByGameOrderByTime("Ping");
        verify(dao, times(1)).findTop1ByGameOrderByTime("DigCraft");
        verify(dao, times(1)).findTop1ByGameOrderByTime("ZergWARS");

    }

    @Test
    void userSearch() {
        User author = new User();
        Post post = new Post();

        post.setId(1);
        post.setTime(100);
        post.setAuthor(author);

        List<User> users = new ArrayList<>();

        users.add(author);

        when(dao2.findByUsernameContains("author")).thenReturn(users);

        List<User> usersList = postService.userSearch("author");

        assertEquals(1, usersList.size());
        verify(dao2, times(1)).findByUsernameContains("author");
    }

    @Test
    void createComment() {
        Comment comment = new Comment();


        when(dao3.save(comment)).thenReturn(comment);

        postService.createComment(comment);

        verify(dao3,times(1)).save(comment);

    }
}

