package com.revature;

import com.revature.models.Post;
import com.revature.models.PostType;
import com.revature.models.User;
import com.revature.services.PostService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.MDC.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class StandAloneControllerTests {

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