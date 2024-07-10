package com.codewithdurgesh.blog.blogappapis.controllers;

import com.codewithdurgesh.blog.blogappapis.payloads.ApiResponse;
import com.codewithdurgesh.blog.blogappapis.payloads.PostDto;
import com.codewithdurgesh.blog.blogappapis.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
    ){
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(Pageable pageable){
        Page<PostDto> allPost = postService.getAllPost(pageable);
        return new ResponseEntity<>(allPost.getContent(), HttpStatus.OK);
    }
    //get post details by id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto post = postService.getPostById(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    //delete post by postId
    @DeleteMapping("/posts/{id}")
    public ApiResponse deletePost(@PathVariable ("id")Integer postId){
            postService.deletePost(postId);
            return new ApiResponse("Post deleted successfully!!",true);
    }
    //update post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatePost = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost,HttpStatus.OK);
    }
}
