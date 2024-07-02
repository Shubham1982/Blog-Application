package com.codewithdurgesh.blog.blogappapis.repositories;

import com.codewithdurgesh.blog.blogappapis.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
