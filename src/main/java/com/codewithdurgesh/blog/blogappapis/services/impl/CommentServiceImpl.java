package com.codewithdurgesh.blog.blogappapis.services.impl;

import com.codewithdurgesh.blog.blogappapis.entities.Comment;
import com.codewithdurgesh.blog.blogappapis.entities.Post;
import com.codewithdurgesh.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.blogappapis.payloads.CommentDto;
import com.codewithdurgesh.blog.blogappapis.repositories.CommentRepo;
import com.codewithdurgesh.blog.blogappapis.repositories.PostRepo;
import com.codewithdurgesh.blog.blogappapis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post", postId));
        Comment comment = modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepo.save(comment);
        return modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","comentId",commentId));
        commentRepo.delete(comment);
    }
}