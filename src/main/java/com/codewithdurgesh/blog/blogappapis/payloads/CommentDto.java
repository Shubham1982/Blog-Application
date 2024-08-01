package com.codewithdurgesh.blog.blogappapis.payloads;

import com.codewithdurgesh.blog.blogappapis.entities.Post;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class CommentDto {

    private int id;

    private String content;

}