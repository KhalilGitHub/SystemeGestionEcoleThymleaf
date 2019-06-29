package com.objis.cam.sgethymleaf.model;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="inscription")
public class Inscription implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idInscription;
	@NotEmpty
	private String matricule;
	@OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Eleve eleve;
    private BigDecimal frais;
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date date;
    private String annee;
    private String image;
    
    
    public Inscription() {
		super();
	}
    
    

	public Inscription(long idInscription) {
		super();
		this.idInscription = idInscription;
	}



	public Inscription(String matricule, Eleve eleve,  BigDecimal frais, String annee, Date date) {
		super();
		this.matricule = matricule;
		this.eleve = eleve;
		this.frais = frais;
		this.date = date;
		this.annee = annee;
	}



	public Inscription(String matricule, Eleve eleve, BigDecimal frais, Date date, String annee, String image) {
		super();
		this.matricule = matricule;
		this.eleve = eleve;
		this.frais = frais;
		this.date = date;
		this.annee = annee;
		this.image = image;
	}
		
	
	public Inscription(long idInscription, String matricule, Eleve eleve, BigDecimal frais, Date date, String annee, String image) {
		super();
		this.idInscription = idInscription;
		this.matricule = matricule;
		this.eleve = eleve;
		this.frais = frais;
		this.date = date;
		this.annee = annee;
		this.image = image;
		
	}

	
	

	public long getIdInscription() {
		return idInscription;
	}



	public void setIdInscription(long idInscription) {
		this.idInscription = idInscription;
	}



	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public BigDecimal getFrais() {
		return frais;
	}
	

	public void setFrais(BigDecimal frais) {
		this.frais = frais;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", matricule=" + matricule + ", eleve=" + eleve + ", frais=" + frais
				+ ", date=" + date + ", annee=" + annee + ", image=" + image + "]";
	}
	
}
