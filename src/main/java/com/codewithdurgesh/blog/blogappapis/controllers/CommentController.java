package com.codewithdurgesh.blog.blogappapis.controllers;

import com.codewithdurgesh.blog.blogappapis.payloads.CommentDto;
import com.codewithdurgesh.blog.blogappapis.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){
        CommentDto createComment = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(createComment, HttpStatus.CREATED);
    }
}
