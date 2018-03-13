package com.glb.bootcamp.service.api.test.posts;

import com.glb.bootcamp.service.api.client.PostServiceClient;
import com.glb.bootcamp.service.api.model.Post;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * PostsServiceTest represents a suite of tests to verify the Posts service operations.
 */
public class PostsServiceTest {

    private PostServiceClient client = new PostServiceClient("https://jsonplaceholder.typicode.com/");

    @Test
    public void testGetPostSuccessful() throws IOException {
        Response<Post> response = client.getPost("1");
        assertEquals(response.code(), 200, "Response:StatusCode");

        Post post = response.body();
        assertTrue(post != null, "Response:Body");
        assertEquals(post.getUserId(), "1", "Response:Body:userId field");
        assertEquals(post.getId(), "1", "Response:Body:id field");
        assertEquals(post.getTitle(), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "Response:Body:title field");
        assertEquals(post.getBody(), "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto", "Response:Body:body field");
    }

    // You may want to use the hamcrest - CoreMatchers, instead of simple Assert
    //assertThat("Response Status Code is", response.code(), is(200));
    //assertThat("Response:Body - userId field is", post.getUserId(), is(1));
}
