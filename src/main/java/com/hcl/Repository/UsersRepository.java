package com.hcl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	
	Users findByEmail(String email);
	// boolean existsByEmail(String email);
	 @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Users u WHERE LOWER(u.email) = LOWER(:email)")
      boolean checkEmail(@Param("email") String email);
    
}
