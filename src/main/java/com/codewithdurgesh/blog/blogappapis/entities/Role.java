package com.codewithdurgesh.blog.blogappapis.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity

public class Role {

    @Id
    private int id;

    private String name;

}
