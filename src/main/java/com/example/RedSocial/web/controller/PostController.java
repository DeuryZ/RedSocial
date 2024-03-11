package com.example.RedSocial.web.controller;

import com.example.RedSocial.domain.service.PostServiceImpl;
import com.example.RedSocial.persistence.entity.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable String id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().body("Id is required");
            }
            if(id.isEmpty()) {
                return ResponseEntity.badRequest().body("Id cannot be empty");
            }
            if (postService.getPostById(Long.parseLong(id)) == null) {
                return ResponseEntity.badRequest().body("Post not found");
            }
            return ResponseEntity.ok(postService.getPostById(Long.parseLong(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity savePost( @RequestBody Post post) {
        try {
            return ResponseEntity.ok(postService.savePost(post));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity updatePost( @RequestBody Post post) {
        try {
            return ResponseEntity.ok(postService.updatePost(post));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable String id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().body("Id is required");
            }
            if (postService.getPostById(Long.parseLong(id)) == null) {
                return ResponseEntity.badRequest().body("Post not found");
            }
            postService.deletePostById(Long.parseLong(id));
            return ResponseEntity.ok("Post deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
