package com.revature;

import com.revature.models.Post;
import com.revature.models.PostType;
import com.revature.models.User;
import com.revature.repositories.PostRepository;
import com.revature.services.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceTests {
@Autowired
PostService postService;

@MockBean
PostRepository dao;

    @Test
    public void testFindAllPosts(){
        User Author = new User();
        List<Post> comments = new ArrayList<Post>();
        List<Post> posts = new ArrayList<>();
        Post post = new Post(1,"Test","url.url",comments,Author, PostType.Top);
        Post testPost = new Post(2,"Text","url.url",comments,Author, PostType.Top);

        posts.add(post);
        posts.add(testPost);

        when(dao.findAll()).thenReturn(posts);

        List<Post> postsList = postService.getAll();

        assertEquals(2, postsList.size());
        verify(dao, times(1)).findAll();
    }




}

