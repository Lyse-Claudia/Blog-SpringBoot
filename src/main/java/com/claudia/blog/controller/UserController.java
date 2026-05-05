package com.claudia.blog.controller;

import com.claudia.blog.domain.dto.PostDto;
import com.claudia.blog.domain.entity.UserAccount;
import com.claudia.blog.service.PostService;
import com.claudia.blog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public List<UserAccount> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserAccount addNewUsers(@RequestBody UserAccount userAccount){
        return userService.insertUsers(userAccount);
    }
    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsByUser(@PathVariable Integer id){
        return postService.getPostsByUser(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
