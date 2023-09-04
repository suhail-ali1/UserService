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
	public Users getUser(String email , String password) {
		
		Users user = null;
        
		if(userRepo.checkEmail(email))
		{
			System.out.println("Inside email");
			//System.out.println(userRepo.findById(identity).get());
			user = userRepo.findByEmail(email);
	       
			if( user != null  && user.getPassword().equals(password))
			 {
				  return user;
			 }
		    else 
			{
				return null;
			}
			 
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
	public String deleteUser(long userid) {
		
		
		 userRepo.deleteById(userid);
		 return "User Deleted Successfully";
	}
	
	
	@Override
	public Users updateEmail( long userid , String oldemail, String newemail) {
		
		Users user = userRepo.findById(userid).get();
		user.setEmail(newemail);
		return userRepo.saveAndFlush(user);
	}
	
	
}
