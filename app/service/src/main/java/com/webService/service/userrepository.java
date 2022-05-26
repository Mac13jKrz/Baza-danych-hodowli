package com.webService.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface userrepository extends JpaRepository<user, Integer> {
	@Query(value="select * from user where login=:login",nativeQuery=true)
	user findByLogin(@Param("login") String login);
}