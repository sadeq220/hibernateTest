package com.sadeqtest.demo.controller.dto;

public class CommentDto {
    private String postUUID;
    private String text;

    public String getPostUUID() {
        return postUUID;
    }

    public void setPostUUID(String postUUID) {
        this.postUUID = postUUID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
