package com.hcl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.Entity.Users;
import com.hcl.Repository.UsersRepository;
import com.hcl.Service.IUsersService;

@Component
public class UsersServiceImpl implements IUsersService {
	
	
	@Autowired
	UsersRepository userRepo;
	
	
	@Override
	public Users getUser(String identity , String password) {
		
		Users user = null;
        
		if(userRepo.checkEmail(identity))
		{
			System.out.println("Inside email");
			//System.out.println(userRepo.findById(identity).get());
			user = userRepo.findByEmail(identity);
			 
		}
		else if(userRepo.existsById(identity))
		{
			user = userRepo.findById(identity).get();
		}
		
		
	   if( user != null  && user.getPassword().equals(password))
		 {
			  return user;
		 }
	  else 
		{
			return null;
		}
		
		
	}
	
	
	@Override
	public Users registerUser(Users user) {
			
		return userRepo.saveAndFlush(user);
		
	}

	@Override
	public String deleteUser(String userid) {
		
		
		 userRepo.deleteById(userid);
		 return "User Deleted Successfully";
	}
	
	
	@Override
	public Users updateEmail(String userid , String oldemail, String newemail) {
		
		Users user = userRepo.findById(userid).get();
		user.setEmail(newemail);
		return userRepo.saveAndFlush(user);
	}
	
	
}
