/**
 * 
 */
package org.cauris.gesfisco.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cedrickiadjeu
 *
 */
@Controller
public class HelloController {

	@Value("${lang}")
	private String lang;
	
	
	/********************************************************************************************
	 * Porte d'entrée de l'application pour tous les utilisateurs administrateurs et economes
	 * @param model
	 * @param request
	 * @param lang
	 * @return
	 * @throws ParseException
	 */
	@GetMapping("/gesfisco/index")
	    public String index(Model model, HttpServletRequest request,
	    		@RequestParam(name="lang", defaultValue="fr") String lang) throws ParseException {
		 DateFormat dfNameJour=new SimpleDateFormat("EEEE");
		 DateFormat dfheure=new SimpleDateFormat("H:m:s");
		 HttpSession session=request.getSession();
	    session.setAttribute("lang", lang);
	    Date dateJour=new Date(); 
	    if(lang.equals("fr")==true){
    		Locale localeFr = new Locale("fr","FR");
    		dfNameJour = DateFormat.getDateInstance(DateFormat.FULL, localeFr);
    		dfheure = DateFormat.getTimeInstance(DateFormat.FULL, localeFr);
    	}
	    else{
    		Locale localeEn = new Locale("en","EN");
    		dfNameJour = DateFormat.getDateInstance(DateFormat.FULL, localeEn);
    		dfheure = DateFormat.getTimeInstance(DateFormat.FULL, localeEn);
    	}
	    
	    model.addAttribute("dfNameJour", dfNameJour.format(dateJour).toUpperCase());;
    	model.addAttribute("dfheure", dfheure.format(dateJour));
    	
    	session.setAttribute("dfNameJour", dfNameJour.format(dateJour).toUpperCase());
    	session.setAttribute("dfheure", dfheure.format(dateJour));
    	
        return "index";
	    
	 }
	
	@GetMapping("/login")
    public String login(Model model, HttpServletRequest request,
    		@RequestParam(name="lang", defaultValue="fr") String lang) throws ParseException{
		DateFormat dfNameJour=new SimpleDateFormat("EEEE");
    	DateFormat dfJour=new SimpleDateFormat("dd");
    	DateFormat dfmois=new SimpleDateFormat("MMMM");
    	DateFormat dfyear=new SimpleDateFormat("yyyy");
    	DateFormat dfheure=new SimpleDateFormat("H:m:s");
    	Date dateJour=new Date();
    	
    	if(lang.equals("fr")==true){
    		Locale localeFr = new Locale("fr","FR");
    		dfNameJour = DateFormat.getDateInstance(DateFormat.FULL, localeFr);
    		dfmois = DateFormat.getDateInstance(DateFormat.FULL, localeFr);
    	}
    	else if(lang.equals("en")==true){
    		Locale localeEn = new Locale("en","EN");
    		dfNameJour = DateFormat.getDateInstance(DateFormat.FULL, localeEn);
    		dfmois = DateFormat.getDateInstance(DateFormat.FULL, localeEn);
    	}
    	
    	model.addAttribute("dfNameJour", dfNameJour.format(dateJour).toUpperCase());
    	model.addAttribute("dfJour", dfJour.format(dateJour));
    	model.addAttribute("dfmois", dfmois.format(dateJour));
    	model.addAttribute("dfyear", dfyear.format(dateJour));
    	model.addAttribute("dfheure", dfheure.format(dateJour));
    	
		return "login";
    	
	}
	
	@GetMapping("/errors/403")
    public String error403() {
        return "/errors/403";
    }
	
	@GetMapping("/404")
    public String error404() {
        return "/errors/404";
    }

}
