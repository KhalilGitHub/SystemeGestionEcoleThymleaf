package com.objis.cam.sgethymleaf.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.objis.cam.sgethymleaf.model.Eleve;
import com.objis.cam.sgethymleaf.model.Inscription;
import com.objis.cam.sgethymleaf.repository.InscriptionRepository;

@Service
public class InscriptionServiceImpl implements InscriptionService{

	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	@Override
	public List<Inscription> findByEleveService(String e) {
		
		return inscriptionRepository.findByEleve(e);
	}

	@Override
	public Page<Inscription> findByEleveService(String e, Pageable pageable) {
		// TODO Auto-generated method stub
		return inscriptionRepository.findByEleve(e, pageable);
	}

	@Override
	public Page<Eleve> findByNomService(String n, Pageable pageable) {
		// TODO Auto-generated method stub
		return inscriptionRepository.findByNom(n, pageable);
	}

	@Override
	public Page<Inscription> chercherInscripService(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return inscriptionRepository.chercherInscrip(mc, pageable);
	}

	@Override
	public Inscription findByMatriculeService(String mat) {
		// TODO Auto-generated method stub
		return inscriptionRepository.findByMatricule(mat);
	}

	@Override
	public List<Inscription> chercherInscripService(Date a1, Date a2) {
		// TODO Auto-generated method stub
		return inscriptionRepository.chercherInscrip(a1, a2);
	}

	@Override
	public Page<Inscription> findAllService(PageRequest pageRequest) {
		
		return inscriptionRepository.findAll(pageRequest);
	}

	@Override
	public void saveInscriptionService(Inscription inscription) {

		inscriptionRepository.save(inscription);
		
	}

	@Override
	public void deleteByIdService(Long id) {

		inscriptionRepository.deleteById(id);
		
	}

	@Override
	public Inscription getOneService(Long id) {

		return inscriptionRepository.getOne(id);
		
	}

	
	

}
