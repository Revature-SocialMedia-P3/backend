package com.revature;

import com.revature.models.Post;
import com.revature.models.PostType;
import com.revature.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
class SocialMediaApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	boolean likesChanged(){
		User Author = new User();
		List<Post> comments = new ArrayList<Post>();
		Post testPost = new Post(1,"Test","url.url",comments,Author, PostType.Top,5);
		return false;
	}


}
