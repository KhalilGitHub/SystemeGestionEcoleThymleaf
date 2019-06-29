package com.objis.cam.sgethymleaf.repository;

import java.util.List;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.objis.cam.sgethymleaf.model.Eleve;
import com.objis.cam.sgethymleaf.model.Inscription;






public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
	
	public List<Inscription> findByEleve(String e);
	
	public Page<Inscription> findByEleve(String e, Pageable pageable);
	
	@Query("select e from Eleve e where e.nom like :x")
	public Page<Eleve> findByNom(@Param("x")String n, Pageable pageable);
	
	@Query("select i from Inscription i where i.matricule like :x")
	public Page<Inscription> chercherInscrip(@Param("x")String mc, Pageable pageable);
	
	///@Query("select i from Inscription i where i.matricule =:x")
	public Inscription findByMatricule(String mat);
	
	@Query("select i from Inscription i where i.date > :x and i.date < :y")
	public List<Inscription> chercherInscrip(@Param("x")Date a1, @Param("y")Date a2);

}
