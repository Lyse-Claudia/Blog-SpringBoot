package com.claudia.blog.mapper.impl;

import com.claudia.blog.domain.CreatePostRequest;
import com.claudia.blog.domain.dto.CreatePostRequestDto;
import com.claudia.blog.domain.dto.PostDto;
import com.claudia.blog.domain.entity.Post;
import com.claudia.blog.mapper.PostMapper;
import org.springframework.stereotype.Component;

@Component
public class PostMapperImpl implements PostMapper {
    @Override
    public CreatePostRequest fromDto(CreatePostRequestDto dto){
        return new CreatePostRequest(
                dto.title(),
                dto.content(),
                dto.author().getId()
        );
    }

    @Override
    public PostDto toDto(Post post){
        if(null == post){
            return null;
        }
        return new PostDto(
                //post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor().getUsername()
                //post.getAuthor().getId()
        );
    }
}
