package com.hcl.Service;

import org.springframework.stereotype.Service;

import com.hcl.Entity.Users;

@Service
public interface IUsersService {

	Users getUser(String identity , String password ); // identity can be userid or email.
	Users registerUser(Users user); // Registers user. 
	String deleteUser(String userid);
	Users updateEmail(String userid ,String oldemail , String newemail);
	
}
