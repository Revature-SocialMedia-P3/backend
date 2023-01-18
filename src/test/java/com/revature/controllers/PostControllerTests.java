package com.revature.controllers;

import com.revature.services.PostService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class PostControllerTests {

    @MockBean
    PostService postService;

    @Autowired
    MockMvc mockMvc;
}

    /*
    @Test
    public void testFindAll() throws Exception {
        User Author = new User();
        List<Post> comments = new ArrayList<Post>();
        Post post = new Post(1,"Test","url.url",comments,Author, PostType.Top,5);
        Post testPost = new Post(2,"Text","url.url",comments,Author, PostType.Top,6);
        List<Post> posts = Arrays.asList(post,testPost);

        Mockito.when(postService.getAll()).thenReturn(posts);

        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }
}
*/