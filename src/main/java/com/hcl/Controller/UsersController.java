package com.hcl.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Entity.Users;
import com.hcl.Service.IUsersService;

@RestController
@RequestMapping("user")
public class UsersController {
	
	@Autowired
	IUsersService userservice;
	
	@GetMapping("/getUser/{identity}/{password}")
	public Users getUser(@PathVariable String identity , @PathVariable String password )
	{
		return userservice.getUser(identity, password);
	}
	
	@PostMapping("/addUser")
	public String addUser(Users user)
	{
		Users u = userservice.registerUser(user);
		if(u !=  null)
		{
			return "User Registration Successfully";
		}
		else
		{
			return "Registration Failed Please Try Again";
		}
	}
	
	@DeleteMapping("/deleteUser/{userid}")
	public String deleteUser(@PathVariable String userid)
	{
		return userservice.deleteUser(userid);
	}
	
	@PutMapping("/updateEmail/{userid}/{oldemail}/{newemail}")
	public Users updateUserEmail(@PathVariable String userid , @PathVariable String oldemail , @PathVariable String newemail )
	{
		return userservice.updateEmail(userid , oldemail, newemail );
	}

}
