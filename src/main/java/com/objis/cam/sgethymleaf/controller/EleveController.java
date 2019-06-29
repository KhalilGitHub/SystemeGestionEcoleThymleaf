package com.objis.cam.sgethymleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.objis.cam.sgethymleaf.dao.EleveDTO;
import com.objis.cam.sgethymleaf.model.Eleve;





@Controller
public class EleveController {
	
	@Autowired
	private EleveDTO eleveDTO;
	
	@RequestMapping(value="/enroll",method=RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Eleve eleve = new Eleve();
		model.addAttribute("eleve",eleve);
		return "enroll";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveRegistration(@Valid Eleve eleve,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println("has errors");
			return "enroll";
		}
	
		eleveDTO.save(eleve);
		
		return "redirect:/viewstudents";
	}
	
	
	@RequestMapping(value="/viewstudents")
	public ModelAndView getAll() {
		
		List<Eleve> list=eleveDTO.findAll();
		return new ModelAndView("viewstudents","list",list);
	}
	
	
	@RequestMapping(value="/editstudent/{id}")
	public String edit (@PathVariable long id,ModelMap model) {
		
		Eleve eleve=eleveDTO.findOne(id);
		model.addAttribute("eleve", eleve);
		return "editstudent";
	}
	
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("eleve") Eleve e) {
		
		Eleve eleve=eleveDTO.findOne(e.getIdEleve());
		
		eleve.setMatricule(e.getMatricule());
		eleve.setNom(e.getNom());
		eleve.setPrenom(e.getPrenom());
		eleve.setClasse(e.getClasse());
		eleve.setAge(e.getAge());
		

		
		eleveDTO.save(eleve);
		return new ModelAndView("redirect:/viewstudents");
	}
	
	@RequestMapping(value="/deletestudent/{id}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable long id) {
		Eleve eleve=eleveDTO.findOne(id);
		eleveDTO.delete(eleve);
		return new ModelAndView("redirect:/viewstudents");
	}
	
	

	@ModelAttribute("sections")
	public List<String> intializeSections(){
		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Reasearch");
		return sections;
	}
	
	
	/*
	 * Method used to populate the country list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	@ModelAttribute("classes")
	public List<String> initializeCountries() {

		List<String> classes = new ArrayList<String>();
		classes.add("Sixieme");
		classes.add("Cinquieme");
		classes.add("Quatrieme");
		classes.add("Troisieme");
		classes.add("Second");
		classes.add("Premiere");
		classes.add("Terninal");
		return classes;
	}

}
