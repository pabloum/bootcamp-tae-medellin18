package com.glb.bootcamp.service.api.service;

import com.glb.bootcamp.service.api.model.Post;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Service API interface to represent Posts Service implementation.
 */
public interface PostsService {

    @POST("/posts")
    Call<Post> createPost(@Body Post post);

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/posts/{id}")
    Call<Post> getPost(@Path("id") String id);

    @PUT("/posts/{id}")
    Call<Post> updatePost(@Path("id") String id);

    @DELETE("/posts/{id}")
    Call<Post> deletePost(@Path("id") String id);

}
