package com.claudia.blog.service.impl;

import com.claudia.blog.domain.CreatePostRequest;
import com.claudia.blog.domain.dto.PostDto;
import com.claudia.blog.domain.entity.Post;
import com.claudia.blog.domain.entity.UserAccount;
import com.claudia.blog.repository.PostRepository;
import com.claudia.blog.repository.UserRepository;
import com.claudia.blog.service.PostService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post createPost(CreatePostRequest request){
        UserAccount author = userRepository.findById(request.authorId()).orElseThrow(()->new RuntimeException("User not found"));
        Post newPost = new Post(
                null,
                request.title(),
                request.content(),
                author
        );
        return postRepository.save(newPost);
    }
    @Override
    public List<Post> listPosts(){
        return postRepository.findAll(Sort.by("id"));

    }

    @Override
    public List<PostDto> getPostsByUser(Integer authorId){
        List<Post> posts = postRepository.findByAuthorId(authorId);
        return posts.stream().map(post -> new PostDto(post.getTitle(),
                post.getContent(),post.getAuthor().getUsername())).toList();
    }
}
