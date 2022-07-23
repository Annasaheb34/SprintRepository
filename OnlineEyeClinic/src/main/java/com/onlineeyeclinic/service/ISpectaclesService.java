package com.onlineeyeclinic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineeyeclinic.dto.Spectacles;
import com.onlineeyeclinic.exceptions.SpectacleIdNotFoundException;


@Service
public interface ISpectaclesService {
	//add spectacle
		public Spectacles addSpectacle(Spectacles spectacle);

		//remove spectacle
		public Spectacles removeSpectacle(int spectacleId)throws SpectacleIdNotFoundException; 

		//update spectacle
		public Spectacles updateSpectacle(Spectacles spectacle);

		//get spectacle
		public Spectacles getSpectacle(int spectacleId)throws SpectacleIdNotFoundException;

		//get spectacle list
		public List<Spectacles> getAllSpectacle();
		
		
}

