package com.codewithdurgesh.blog.blogappapis.repositories;

import com.codewithdurgesh.blog.blogappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
