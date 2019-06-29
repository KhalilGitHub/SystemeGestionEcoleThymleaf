package com.objis.cam.sgethymleaf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.objis.cam.sgethymleaf.model.Inscription;
import com.objis.cam.sgethymleaf.repository.InscriptionRepository;


@Service
public class InscriptionDTO {
	@Autowired
	InscriptionRepository inscriptionRepository;
	
	/*to save an employee*/
	
	public Inscription save(Inscription std) {
		return inscriptionRepository.save(std);
	}
	
	
	/* search all employees*/
	
	public List<Inscription> findAll(){
		return inscriptionRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Inscription findOne(Long id) {
		return inscriptionRepository.getOne(id);
	}
	
	
	/*delete an employee*/
	
	public void delete(Inscription std) {
		inscriptionRepository.delete(std);
	}
	

}
