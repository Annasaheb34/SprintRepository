package com.onlineeyeclinic.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyeclinic.dto.Spectacles;



@Repository
public interface ISpectaclesRepo extends JpaRepository<Spectacles, Integer> {

}

