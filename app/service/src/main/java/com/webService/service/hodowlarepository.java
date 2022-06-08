package com.webService.service;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface hodowlarepository extends JpaRepository<hodowla, Integer> {
	@Transactional
	@Modifying
	@Query(value="insert into hodowla values(:numer_ID,:data1,:kolczyk_ID,:data2,:plec,:rasa,:numer_ID_matki,:kolczyk_ID_matki)",nativeQuery=true)
	void insertHodowla(@Param("numer_ID") String numerID,@Param("data1") Date data1,
			@Param("kolczyk_ID") int kolczykID,@Param("data2") Date data2,
			@Param("plec") String plec,@Param("rasa") String rasa,
			@Param("numer_ID_matki") String numerID_matki,
			@Param("kolczyk_ID_matki") int kolczykID_matki);
	@Transactional
	@Modifying
	@Query(value="delete from hodowla where numer_ID=:numer_ID",nativeQuery=true)
	void deleteHodowla(@Param("numer_ID") String numerID);
}