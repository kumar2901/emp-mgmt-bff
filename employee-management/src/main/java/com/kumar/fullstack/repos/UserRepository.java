package com.kumar.fullstack.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kumar.fullstack.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	public static final String FIND_BY_EMAIL="Select * From users Where email_id= :emailId";
	@Query(value=FIND_BY_EMAIL,nativeQuery=true)
	User findByEmailId(String emailId);

}
