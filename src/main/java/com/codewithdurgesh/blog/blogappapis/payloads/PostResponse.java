package com.codewithdurgesh.blog.blogappapis.payloads;


import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;


@Data
public class PostResponse {

    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;
    private boolean lastPage;

}
