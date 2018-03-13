package com.glb.bootcamp.service.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Post represents the payload to send/receive from/to the Posts service.
 * Example:
 * {
 * "userId": 1,
 * "id": 1,
 * "title": "The title",
 * "body": "The body"
 * },
 */
public class Post {

    @JsonProperty()
    private String userId;

    @JsonProperty
    private String id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String body;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
