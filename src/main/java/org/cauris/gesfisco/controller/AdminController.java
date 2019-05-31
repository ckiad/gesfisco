/**
 * 
 */
package org.cauris.gesfisco.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.cauris.gesfisco.form.ModifpasswordForm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cedrickiadjeu
 *
 */
@Controller
@RequestMapping(path="/gesfisco/admin")
public class AdminController {

	DateFormat dfNameJour=new SimpleDateFormat("EEEE");
	DateFormat dfJour=new SimpleDateFormat("dd");
	DateFormat dfmois=new SimpleDateFormat("MMMM");
	DateFormat dfyear=new SimpleDateFormat("yyyy");
	DateFormat dfheure=new SimpleDateFormat("H:m:s");
	Date dateJour=new Date();
	
	/**************************************************************
	 * Chargement de la page d'accueil des administrateurs de la plateforme
	 * Avec la page de modification du mot de passe
	 *************************************************************/
	@GetMapping(path="/index")
	public String indexAdmin(@ModelAttribute("modifpasswordForm") 
			ModifpasswordForm modifpasswordForm, 
			Model model, HttpServletRequest request) throws ParseException{
		
		HttpSession session=request.getSession();
		
		session.setAttribute("dfNameJour", dfNameJour.format(dateJour).toUpperCase());
		session.setAttribute("dfJour", dfJour.format(dateJour));
		session.setAttribute("dfmois", dfmois.format(dateJour));
		session.setAttribute("dfyear", dfyear.format(dateJour));
		session.setAttribute("dfheure", dfheure.format(dateJour));
		
		/*
		 * Il faut recuperer le username de l'user connecte et placer dans la session
		 * avant toutes redirection vers la page demandée 
		 */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("username", auth.getName());
		
		session.setAttribute("username", auth.getName());
		
		return "admin/indexAdmin";
		
	}

}
