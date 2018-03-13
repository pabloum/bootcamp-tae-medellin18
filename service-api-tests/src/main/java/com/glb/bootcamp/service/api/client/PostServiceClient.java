package com.glb.bootcamp.service.api.client;

import com.glb.bootcamp.service.api.model.Post;
import com.glb.bootcamp.service.api.service.PostsService;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * PostServiceClient represents a client to perform operation against the /posts endpoint.
 */
public class PostServiceClient {

    /**
     * The service base URL.
     */
    private String url;

    /**
     * Default constructor.
     *
     * @param url the base URL
     */
    public PostServiceClient(String url) {
        this.url = url;
    }

    /**
     * Creates a post.
     *
     * @param post the {@link Post}
     * @return the response {@link PostsService#createPost(Post)}
     * @throws IOException
     */
    public Response<Post> createPost(Post post) throws IOException {
        return getPostService().createPost(post).execute();
    }

    /**
     * Gets all posts.
     *
     * @return the response {@link PostsService#getPosts()}
     * @throws IOException
     */
    public Response<List<Post>> getPosts() throws IOException {
        return getPostService().getPosts().execute();
    }

    /**
     * Gets a post by id.
     *
     * @param id the id
     * @return the response {@link PostsService#getPost(String)}
     * @throws IOException
     */
    public Response<Post> getPost(String id) throws IOException {
        return getPostService().getPost(id).execute();
    }

    /**
     * Updates a post by id
     *
     * @param id the id
     * @return the response {@link PostsService#updatePost(String)}
     * @throws IOException
     */
    public Response<Post> updatePost(String id) throws IOException {
        return getPostService().updatePost(id).execute();
    }

    /**
     * Deletes a post by id.
     *
     * @param id the id
     * @return the response {@link PostsService#deletePost(String)}
     * @throws IOException
     */
    public Response<Post> deletePost(String id) throws IOException {
        return getPostService().deletePost(id).execute();
    }

    /**
     * Created an instance of the service client based on {@link PostsService} implementation.
     *
     * @return the {@link PostsService}
     */
    private PostsService getPostService() {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .client(new OkHttpClient())
                .baseUrl(url)
                .build()
                .create(PostsService.class);
    }

}
