package com.example.RedSocial.domain.service;

import com.example.RedSocial.persistence.entity.Post;

import java.util.List;

public interface PostService {

    Post savePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long id);

    void deletePostById(Long id);

    Post updatePost(Post post);



}
