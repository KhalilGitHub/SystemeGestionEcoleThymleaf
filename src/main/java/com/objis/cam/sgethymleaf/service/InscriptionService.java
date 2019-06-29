package com.objis.cam.sgethymleaf.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import com.objis.cam.sgethymleaf.model.Eleve;
import com.objis.cam.sgethymleaf.model.Inscription;


public interface InscriptionService {
	
	public Inscription getOneService(Long id);
	
	public void deleteByIdService(Long id);
	
	public void saveInscriptionService(Inscription inscription);
	
	public Page<Inscription> findAllService(PageRequest pageRequest);
	
	 public List<Inscription> findByEleveService(String e);
	
	public Page<Inscription> findByEleveService(String e, Pageable pageable);
	
	
	public Page<Eleve> findByNomService(@Param("x")String n, Pageable pageable);
	
	
	public Page<Inscription> chercherInscripService(@Param("x")String mc, Pageable pageable);
	
	
	public Inscription findByMatriculeService(String mat);
	
	
	public List<Inscription> chercherInscripService(@Param("x")Date a1, @Param("y")Date a2);
	 

}
