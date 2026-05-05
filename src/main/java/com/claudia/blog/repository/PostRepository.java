package com.claudia.blog.repository;

import com.claudia.blog.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByAuthorId(Integer authorId);
}
