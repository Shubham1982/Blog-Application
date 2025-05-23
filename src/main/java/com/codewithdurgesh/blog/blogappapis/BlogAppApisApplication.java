package com.codewithdurgesh.blog.blogappapis;

import com.codewithdurgesh.blog.blogappapis.Config.AppConstant;
import com.codewithdurgesh.blog.blogappapis.entities.Role;
import com.codewithdurgesh.blog.blogappapis.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("shubham"));

		try {
			Role role = new Role();
			role.setId(AppConstant.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstant.NORMAL_USER);
			role1.setName("ROLE_NORMAL");
			List<Role> roles = List.of(role, role1);
			List<Role> result = roleRepository.saveAll(roles);
			result.forEach(r->{
				System.out.println(r.getName());
			});
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}














