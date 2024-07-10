package com.codewithdurgesh.blog.blogappapis.services;

import com.codewithdurgesh.blog.blogappapis.entities.Post;
import com.codewithdurgesh.blog.blogappapis.payloads.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    //update
    PostDto updatePost (PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all posts
    Page<PostDto> getAllPost(Pageable pageable);

    //get single post
    PostDto getPostById(Integer postId);

    //get all posts by category

    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all pos by user
    List<PostDto> getPostsByUser(Integer userId);

    //search
    List<Post> searchPosts (String keyword);

}
