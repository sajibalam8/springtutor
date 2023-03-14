package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Users;	
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	
	
	// List<Users> findByUserName(String userName) ;    	                                                                                               
	 @Query(value="select u from Users u where u.userName=?1")           //jpa query is incomplete     java names
	 List<Users> customFunctionTwo(String userName);                                                              
	                                                  		                                                                                              
	 
	 void deleteByUserName(String userName) ;
	 
	 @Query(value="select * from users order by id desc limit 3", nativeQuery=true)//table and column namesu7yuv 
	 List<Users> customFunctionOne();
		
	
}
