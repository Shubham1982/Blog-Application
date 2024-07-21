package com.codewithdurgesh.blog.blogappapis.payloads;

import com.codewithdurgesh.blog.blogappapis.entities.Comment;
import com.codewithdurgesh.blog.blogappapis.entities.User;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class PostDto {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private Set<Comment> comments = new HashSet<>();
}
