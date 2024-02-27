package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Flat;

public interface FlatDao extends JpaRepository<Flat,Long>{
	
	Optional<Flat> findById(Long id);
}
