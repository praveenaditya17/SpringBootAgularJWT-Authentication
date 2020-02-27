package com.example.demo.service.Impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.UserDetail;
import com.example.demo.repository.UserDetailService;

@Service
public class JwtUserDetailsService  implements UserDetailsService{
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Transactional
	public UserDetail save(UserDetail user) {
		UserDetail newUser = new UserDetail();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDetailService.save(newUser);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/* this code is used for hardcode user name and password =>
		 * if ("praveen".equals(username)) {
		 * 
		 * return new User("praveen",
		 * "$2a$10$NEOqzL0.JH5uWiJPT6KVduqDvDrDrH49dJX2VFk4MfqipVGZlHevy", new
		 * ArrayList<>()); } else { throw new
		 * UsernameNotFoundException("User not found with username: " + username); }
		 */
		UserDetail userDetail =userDetailService.findByUserName(username);
		
		if (userDetail == null) { 
			  throw new UsernameNotFoundException("User not found with username: " + username); 
		 }
		 return new org.springframework.security.core.userdetails.User(userDetail.getUserName(),
				  userDetail.getPassword(), new ArrayList<>());
	}

}
