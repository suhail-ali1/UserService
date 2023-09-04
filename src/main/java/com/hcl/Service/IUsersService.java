package com.hcl.Service;

import org.springframework.stereotype.Service;

import com.hcl.Entity.Users;

@Service
public interface IUsersService {

	Users getUser(String email , String password ); // identity can be userid or email.
	Users registerUser(Users user); // Registers user. 
	String deleteUser(long userid);
	Users updateEmail(long userid ,String oldemail , String newemail);
	
}
