package com.codewithdurgesh.blog.blogappapis.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name= "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "post_title", length= 100, nullable = false)
    private String title;

    @Column(length = 1000)
    private String content;

    private String imageName;

    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
}
