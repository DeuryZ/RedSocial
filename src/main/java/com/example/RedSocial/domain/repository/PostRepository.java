package com.example.RedSocial.domain.repository;

import com.example.RedSocial.persistence.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
