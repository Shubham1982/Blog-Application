package com.codewithdurgesh.blog.blogappapis.payloads;

import lombok.Data;

import java.util.*;

@Data
public class PostDto {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private List<CommentDto> comments = new ArrayList<>();
}
