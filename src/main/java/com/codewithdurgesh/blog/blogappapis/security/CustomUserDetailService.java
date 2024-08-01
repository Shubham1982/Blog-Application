package com.codewithdurgesh.blog.blogappapis.security;

import com.codewithdurgesh.blog.blogappapis.Config.AppConstant;
import com.codewithdurgesh.blog.blogappapis.entities.User;
import com.codewithdurgesh.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.blogappapis.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //loading user from database by username
        User user = userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email : " + username, AppConstant.DEFAULT_VALUE));
        return user;
    }

}



















