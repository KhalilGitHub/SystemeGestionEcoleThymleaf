package com.objis.cam.sgethymleaf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.objis.cam.sgethymleaf.model.Eleve;
import com.objis.cam.sgethymleaf.repository.EleveRepository;


@Service
public class EleveDTO {
	@Autowired
	EleveRepository eleveRepository;
	
	/*to save an employee*/
	
	public Eleve save(Eleve std) {
		return eleveRepository.save(std);
	}
	
	
	/* search all employees*/
	
	public List<Eleve> findAll(){
		return eleveRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Eleve findOne(Long id) {
		return eleveRepository.getOne(id);
	}
	
	
	/*delete an employee*/
	
	public void delete(Eleve std) {
		eleveRepository.delete(std);
	}
	

}
