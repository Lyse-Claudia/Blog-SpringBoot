package com.claudia.blog.mapper;

import com.claudia.blog.domain.CreatePostRequest;
import com.claudia.blog.domain.dto.CreatePostRequestDto;
import com.claudia.blog.domain.dto.PostDto;
import com.claudia.blog.domain.entity.Post;

public interface PostMapper {

    CreatePostRequest fromDto(CreatePostRequestDto dto);

    PostDto toDto(Post post);
}
