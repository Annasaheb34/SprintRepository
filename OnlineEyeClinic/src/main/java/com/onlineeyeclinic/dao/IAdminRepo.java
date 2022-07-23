package com.onlineeyeclinic.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyeclinic.dto.Admin;

@Repository
public interface IAdminRepo extends JpaRepository<Admin,Integer> {

	
}
