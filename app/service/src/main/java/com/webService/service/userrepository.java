package com.webService.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface userrepository extends JpaRepository<user, Integer> {
	@Query(value="select * from user where login=:login",nativeQuery=true)
	user findByLogin(@Param("login") String login);
	@Transactional
	@Modifying
	@Query(value="insert into user(login, haslo) values (:login,:haslo)",nativeQuery=true)
	void insertUser(@Param("login") String login,@Param("haslo") String password);
}