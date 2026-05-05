package com.claudia.blog.domain;

public record CreatePostRequest(
        String title,
        String content,
        Integer authorId
) {
}
