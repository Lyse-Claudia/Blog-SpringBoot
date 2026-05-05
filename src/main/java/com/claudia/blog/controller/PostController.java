package com.claudia.blog.controller;

import com.claudia.blog.domain.CreatePostRequest;
import com.claudia.blog.domain.dto.CreatePostRequestDto;
import com.claudia.blog.domain.dto.PostDto;
import com.claudia.blog.domain.entity.Post;
import com.claudia.blog.mapper.PostMapper;
import com.claudia.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/blogs")
public class PostController {

    private final PostService postService;

    private final PostMapper postMapper;

    public PostController(PostService postService, PostMapper postMapper){
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @Valid @RequestBody CreatePostRequestDto createPostRequestDto){
        CreatePostRequest postToCreate = postMapper.fromDto(createPostRequestDto);

        Post createdPost = postService.createPost(postToCreate);

        PostDto createdTaskDto = postMapper.toDto(createdPost);

        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    /*public List<Post> getPost(){
        return postService.listPosts();
    }
    */
    public ResponseEntity<List<PostDto>> listPosts(){
        List<Post> posts = postService.listPosts();

        List<PostDto> postDtoList = posts.stream()
                .map(postMapper::toDto)
                .toList();

        return ResponseEntity.ok(postDtoList);
    }
}
