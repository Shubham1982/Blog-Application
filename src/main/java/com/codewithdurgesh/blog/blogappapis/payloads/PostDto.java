package com.codewithdurgesh.blog.blogappapis.payloads;

import com.codewithdurgesh.blog.blogappapis.entities.User;
import lombok.Data;

import java.util.Date;

@Data
public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
}
