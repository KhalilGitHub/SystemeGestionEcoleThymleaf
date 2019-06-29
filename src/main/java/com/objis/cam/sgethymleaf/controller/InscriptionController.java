package com.objis.cam.sgethymleaf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.objis.cam.sgethymleaf.model.Inscription;
import com.objis.cam.sgethymleaf.repository.InscriptionRepository;
import com.objis.cam.sgethymleaf.service.InscriptionServiceImpl;


@Controller
//@RequestMapping(value="/inscription")
public class InscriptionController {
	
	@Autowired
	private InscriptionServiceImpl inscriptionService;
	
	
	@RequestMapping(value="/index")
	public String index(Model model, @RequestParam(name="page", defaultValue="0")int p)
	{
		//Page<Inscription> pageInscrip = inscriptionRepository.findAll(new PageRequest(p, 5));
		
		Page<Inscription> pageInscrip = inscriptionService.findAllService(new PageRequest(p, 5));
		
		int pagesCount = pageInscrip.getTotalPages();
		int pages[] = new int [pagesCount];
		for(int i=0; i<pagesCount; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		
		model.addAttribute("pagesCourante", p);
		
		model.addAttribute("pageInscrip", pageInscrip);
		return "inscriptions";
	}	


	@RequestMapping(value="/find" , method=RequestMethod.GET )
	public String find(Model model, @RequestParam String matricule)
	{
		//Inscription inscrip =  inscriptionRepository.findByMatricule(matricule);
		Inscription inscrip =  inscriptionService.findByMatriculeService(matricule);
		System.out.println(inscrip);
		if(inscrip == null)
		{
			inscrip = new Inscription();
		}
		model.addAttribute("inscrip", inscrip);
		return "detailEleve";
	}	
	

	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String formIncription(Model model) {
		
		model.addAttribute("inscription", new Inscription());
		
		return "formInscription";
	}
	
	
	@RequestMapping(value="/saveInscription", method=RequestMethod.POST)
	public String save(@Valid Inscription inscrip, BindingResult br, 
			@RequestParam(name="photo")MultipartFile file) throws IllegalStateException, IOException {
		
		if(br.hasErrors()) {
			return "formInscription";
		}
		
		if(!(file.isEmpty())) {
			inscrip.setImage(file.getOriginalFilename());
		}
		inscriptionService.saveInscriptionService(inscrip);
		
		if(!(file.isEmpty())) {
			inscrip.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.home") +"/Imgs/"+ inscrip.getIdInscription()));
			
			//file.transferTo(new File(System.getProperty("user.home") +"/Imgs/"+ file.getOriginalFilename()));
			//access denied
			//file.transferTo(new File("D:\\MyDocs\\DevLab\\Java\\Spring\\ThymleafProjects\\backup\\imgs"));
		}
		return "redirect:index";
	}
	
	@ResponseBody
	@RequestMapping(value="/getPhoto", produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] getPhoto(Long id) throws FileNotFoundException, IOException {
		
		File f = new File(System.getProperty("user.home") +"/Imgs/"+ id);
		
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Long id) {
		
		inscriptionService.deleteByIdService(id);
		
		return "redirect:index";
	}
	
	@RequestMapping(value="/edit")
	public String edit(Long id, Model model) {
		
		Inscription inscrip = inscriptionService.getOneService(id);
		model.addAttribute("inscription", inscrip);
		return "editInscription";
	}
	
	@RequestMapping(value="/updateInscription", method=RequestMethod.POST)
	public String update(@Valid Inscription inscrip, BindingResult br, 
			@RequestParam(name="photo")MultipartFile file) throws IllegalStateException, IOException {
		
		if(br.hasErrors()) {
			return "editInscription";
		}
		
		if(!(file.isEmpty())) {
			inscrip.setImage(file.getOriginalFilename());
		}
		inscriptionService.saveInscriptionService(inscrip);
		
		if(!(file.isEmpty())) {
			inscrip.setImage(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.home") +"/Imgs/"+ inscrip.getIdInscription()));
			
			//file.transferTo(new File(System.getProperty("user.home") +"/Imgs/"+ file.getOriginalFilename()));
			//access denied
			//file.transferTo(new File("D:\\MyDocs\\DevLab\\Java\\Spring\\ThymleafProjects\\backup\\imgs"));
		}
		return "redirect:index";
	}
	
	/*
	@RequestMapping(value="/editSuppimer")
	public String editSuppimer(Model model, @RequestParam(name="page", defaultValue="0")int p)
	{
		Page<Inscription> pageInscrip = inscriptionService.findAllService(new PageRequest(p, 5));
		
		int pagesCount = pageInscrip.getTotalPages();
		int pages[] = new int [pagesCount];
		for(int i=0; i<pagesCount; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		
		model.addAttribute("pagesCourante", p);
		
		model.addAttribute("pageInscrip", pageInscrip);
		return "editInscription";
	}	
	*/
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	@RequestMapping(value="/editSuppimer")
	public String editSuppimer(Model model, @RequestParam(name="page", defaultValue="0")int p)
	{
		Page<Inscription> pageInscrip = inscriptionRepository.findAll(new PageRequest(p, 5));
		
		int pagesCount = pageInscrip.getTotalPages();
		int pages[] = new int [pagesCount];
		for(int i=0; i<pagesCount; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		
		model.addAttribute("pagesCourante", p);
		
		model.addAttribute("pageInscrip", pageInscrip);
		return "editSupInscriptions";
	}	

}
