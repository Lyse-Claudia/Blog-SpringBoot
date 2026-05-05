package com.claudia.blog.service;

import com.claudia.blog.domain.CreatePostRequest;
import com.claudia.blog.domain.dto.PostDto;
import com.claudia.blog.domain.entity.Post;

import java.util.List;

public interface PostService {

    Post createPost(CreatePostRequest request);

    List<Post> listPosts();

    List<PostDto> getPostsByUser(Integer authorId);
}
