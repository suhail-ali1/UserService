package com.hcl.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Users {

	@Id
	private String userid;
	private String username;
	private String password;
	private String email;
	private String mobile;
	private String DOB ;
	
	
}
