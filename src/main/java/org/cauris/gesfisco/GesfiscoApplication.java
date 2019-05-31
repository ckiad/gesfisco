package org.cauris.gesfisco;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.cauris.gesfisco.dao.EtablissementRepository;
import org.cauris.gesfisco.dao.ReferenceDocImpRepository;
import org.cauris.gesfisco.dao.RoleRepository;
import org.cauris.gesfisco.dao.UtilisateurRepository;
import org.cauris.gesfisco.dao.UtilisateurRoleRepository;
import org.cauris.gesfisco.entities.Administrateurs;
import org.cauris.gesfisco.entities.Etablissement;
import org.cauris.gesfisco.entities.ReferenceDocImp;
import org.cauris.gesfisco.entities.Roles;
import org.cauris.gesfisco.entities.Utilisateurs;
import org.cauris.gesfisco.entities.UtilisateursRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
public class GesfiscoApplication implements CommandLineRunner{

	@Value("${dir.racine}")
	private String racineDir;
	
	@Value("${dir.racineEmblemes}")
	private String racineEmblemesDir;
	
	@Value("${dir.racineImage}")
	private String racineImageDir;
	
	@Value("${dir.images.personnels}")
	private String photoPersonnelsDir;
	
	@Value("${dir.images.eleves}")
	private String photoElevesDir;
	
	@Value("${dir.logs}")
	private String logsDir;
	
	Logger logger = LoggerFactory.getLogger(GesfiscoApplication.class);
	
	public static DateFormat formatdateop=new SimpleDateFormat("yyyy-MM-dd H:m:s");
	public static Date dateJour=new Date();
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UtilisateurRepository userRepository;
	
	@Autowired
	private UtilisateurRoleRepository userRoleRepository;
	
	@Autowired
	private ReferenceDocImpRepository refdocimpRepository; 
	
	@Autowired
	private EtablissementRepository etabRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GesfiscoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("L'application s'est bel et bien lancé avec succes");
		
		 logger.info("====================================================================");
		 logger.info("DEBUT DU DEMARRAGE DE L'APPLICATION.");
		 logger.info("====================================================================");
		
		 /********************************
		  * Creation de l'arborescence qui va servir a stocker les images et autres documents de l'application
		  */
		 
		 try{
			 	File f = new File(racineDir);
				f.mkdirs();
				new File(racineEmblemesDir).mkdirs();
				new File(racineImageDir).mkdirs();
				
				new File(photoPersonnelsDir).mkdirs();
				new File(photoElevesDir).mkdirs();
				new File(logsDir).mkdirs();
				//Ici il faut donc cache ce dossier racine pour qu'il ne soit pas visible par les premiers venus
				String[] cmd = {"attrib","+s","+h",f.getAbsolutePath()};
				Process process = Runtime.getRuntime().exec(cmd);
				process.getOutputStream().close();
				process.getErrorStream().close();
				
				
				logger.info("OK ARBORESCENCE DES DOCUMENTS CREES "+racineDir);
		 }
		 catch(Exception e){
			 logger.error("Erreur lors de la création des dossiers necessaires au bon fonctionnement du logiciel. Exception "+e.getMessage());
		 }
		 
		 /******************************************************************************************************
		  * On va effectuer la configuration de base de l'application directement de façon automatique et 
		  * sachant que pour plusieurs de ces enregistrement il n'en faut qu'un seul dans les tables correspondantes. 
		  * Pour se faire il faut enregistrer automatiquement s'il n'existe pas encore:
		  * 		1) Les roles de l'application ("ECONOME", "ADMIN")
		  * 		2) L'administrateur qui a par défaut le mot de passe 12345
		  * 		3) Le userRole associe à l'administrateur ie qui l'associe à son role
		  * 		4) L'établissement par défaut puisqu'il n'en faut qu'un seul dans la base de donnée et c'est 
		  * d'ailleurs l'econome qui aura la charge de modifier ces données à sa guise.
		  * 		5) les premieres valeurs qui permettront de fabriquer les matricules des eleves et les reference 
		  * des differents documents.
		  *******************************************************************************************************/
		 /*
		  * On enregistre donc les roles
		  */
		 try{
			 Roles roleAdmin = new Roles();
			 roleAdmin.setRole("ADMIN");
			 Roles roleEconome = new Roles();
			 roleEconome.setRole("ECONOME");
			 roleRepository.save(roleAdmin);
			 roleRepository.save(roleEconome);
			 
			 logger.info("OK LES ROLES SONT ENREGISTREES DANS LA BD");
		 }
		 catch(Exception e){
			 logger.error("OK les roles ADMIN et ECONOME existe deja c'est pourquoi on a: "+e.getMessage());
		 }
		    
		 /*
		  * On enregistre l'administrateur et on l'attribue le role ADMIN avec le mot de passe par defaut 12345
		  */
		 Utilisateurs admin=null;
		 try{
			 Pbkdf2PasswordEncoder p=new Pbkdf2PasswordEncoder();
			 Administrateurs adminuser = new Administrateurs();
			 adminuser.setEnabled(true);
			 adminuser.setPassword(p.encode(new String("12345")));
			 adminuser.setUsername("admin");
			 adminuser.setEmailAdmin("ckiadjeu89@gmail.com");
			 adminuser.setNumtel1Admin("678470262");
			 adminuser.setNumtel2Admin("695093228");
			 
			admin=userRepository.save(adminuser);
			
			UtilisateursRoles usersroles = new UtilisateursRoles();
			usersroles.setRoleAssocie(roleRepository.findByRole("ADMIN"));
			usersroles.setUsers(admin);
			
			userRoleRepository.save(usersroles);
			
			 logger.info("OK L'ADMINISTRATEUR PEUT SE CONNECTER");
		 }
		 catch(Exception e){
			 logger.error("OK l'ADMINISTRATEUR existe deja c'est pourquoi on a: "+e.getMessage());
		 }
		 
		 /*
		  * Enregistrement de l'objet qui va nous permettre de generer les identifiants des documents
		  * et le matricule des eleves
		  */
		 try{
			 List<ReferenceDocImp> listofReferencedocimp = refdocimpRepository.findAll();
			 if(listofReferencedocimp.size()>0){
				 logger.info("OK L'OBJET refdocimp EXISTE DEJA ");
			 }
			 else if(listofReferencedocimp.size()==0){
				 /*
				  * On doit faire l'enregistrement 
				  */
				 ReferenceDocImp refdocimp = new ReferenceDocImp();
				 refdocimp.setNumeroBonSortie(0);
				 refdocimp.setNumeroOrdre(0);
				 refdocimp.setNumeroRecuInscription(0);
				 refdocimp.setNumeroRecuVersement(0);
				 refdocimp.setNumeroTicketTransport(0);
				 
				 refdocimpRepository.save(refdocimp);
				 logger.info("OK ENREGISTREMENT DE L'OBJET QUI PERMETTRA DE GENERER LES IDENTIFIANTS ");
			 }
		 }
		 catch(Exception e){
			 logger.error("Erreur lors de l'enregistrement des données qui serviront a la generation des references: "+e.getMessage());
		 }
		 
		 /*
		  * Enregistrement de l'etablissement par defaut que l'econome pourra modifier
		  */
		 
			 List<Etablissement> listofEtab = etabRepository.findAll();
			 if(listofEtab != null){
				 if(listofEtab.size()>0){
					 logger.info("L'ETABLISSEMENT A GERER EST DEJA ENREGISTRE DANS LA BD ");
				 }
				 else if(listofEtab.size() == 0){
					 Etablissement etab = new Etablissement();
					 etab.setAliasEtab("Alias");
					 etab.setAliasministeretuteleanglaisEtab("MINESEC");
					 etab.setAliasministeretuteleEtab("MINESEC");
					 etab.setAliasnomanglaisEtab("Noms en anglais");
					 etab.setBanniereEtab(" ");
					 etab.setBpEtab("bp");
					 etab.setCodeMatriculeEtab("code");
					 etab.setDeleguationdeptuteleanglaisEtab("DDES");
					 etab.setDeleguationdeptuteleEtab("DDES");
					 etab.setDeleguationregtuteleanglaisEtab("DRES");
					 etab.setDeleguationregtuteleEtab("DRES");
					 etab.setDeviseanglaisEtab("Peace-Work-Fatherland");
					 etab.setDeviseEtab("Paix-Travail-Patrie");
					 etab.setEmailEtab("etablissement@gmail.com");
					 etab.setLogoEtab("");
					 etab.setMatriculeEtab("IM");
					 etab.setMinisteretuteleanglaisEtab("MINESEC");
					 etab.setMinisteretuteleEtab("MINESEC");
					 etab.setNomsanglaisEtab("Noms etab en anglais");
					 etab.setNomsEtab("Noms en français");
					 etab.setNumtel1Etab("600000000");
					 etab.setNumtel2Etab("");
					 etab.setVilleEtab("Ville ");
					 try{	
						 etabRepository.save(etab);
					 }
					 catch(Exception e){
						 logger.error("ERREUR DENREGISTREMENT DE LETABLISSEMENT  ");
					 }
					
					 logger.info("ENREGISTREMENT DE L'ETABLISSEMENT PAR DEFAUT EFFECTUE  ");
				 }
			 }
			
		 
		 
		 logger.info("====================================================================");
		 logger.info("FIN DU DEMARRAGE DE L'APPLICATION.");
		 logger.info("====================================================================");
		 
	}

}
