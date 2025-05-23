package com.codewithdurgesh.blog.blogappapis.payloads;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDto {
    private Integer categoryId;

    @NotBlank
    @Size(min = 4, message = "Min size of category title is 4")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "Min size of category desc is 10")
    private String categoryDescription;
}
