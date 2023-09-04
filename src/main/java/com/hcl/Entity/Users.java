package com.hcl.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userid;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String password;
	private String DOB ;
	
}
