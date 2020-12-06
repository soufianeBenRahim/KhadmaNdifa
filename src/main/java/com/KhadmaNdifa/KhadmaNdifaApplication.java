package com.KhadmaNdifa;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.KhadmaNdifa.dao.AppUserRepository;
import com.KhadmaNdifa.dao.DemandeRealisationRepository;
import com.KhadmaNdifa.dao.ProjetsRepositry;
import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Compitance;
import com.KhadmaNdifa.entites.DemandeRealisation;
import com.KhadmaNdifa.entites.Deplome;
import com.KhadmaNdifa.entites.Experiance;
import com.KhadmaNdifa.entites.Projet;
import com.KhadmaNdifa.service.CVService;
import com.KhedmaNdifa.ParentEntities.EtatProjet;
import com.KhedmaNdifa.ParentEntities.Etatcivile;
import com.KhedmaNdifa.ParentEntities.Gender;
import com.KhedmaNdifa.ParentEntities.TypeUser;

@SpringBootApplication

public class KhadmaNdifaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhadmaNdifaApplication.class, args);
	}

	@Bean
	CommandLineRunner start(com.KhadmaNdifa.service.AccountService accountService, CVService cvService,
			AppUserRepository emploiyeeRepository, ProjetsRepositry projetRepository
			,DemandeRealisationRepository demandeRealisationRepository) {
		return args -> {
			cvService.DeletAll();
			projetRepository.deleteAll();
			accountService.delletAll();
			accountService.save(new com.KhadmaNdifa.entites.AppRole(null, "USER"));
			accountService.save(new com.KhadmaNdifa.entites.AppRole(null, "ADMIN"));
			Stream.of("user1", "user2", "user3", "admin").forEach(un -> {
				System.out.println("ajout de l'utilisteur : " + un);
				accountService.saveUser(un, un + "@gmail.com", Gender.MALE, "1234", "1234", TypeUser.EE);
			});
			accountService.addRoleToUser("admin", "ADMIN");
			System.out.println("ajouter le rol Admin a l'utilistaue admin : ");

			CV newCv = new CV();
			newCv.setNom("rahim");
			newCv.setPrenom("Soufiane");
			newCv.setDesignationCV("CV recrutment 1");
			newCv.setAdress("Cite val mascort");
			newCv.setEmail("soubonoi@gmail.com");
			newCv.setCreatedAt(new Date());
			newCv.setUpdatedAt(new Date());
			List<AppUser> emps = emploiyeeRepository.findByUsername("admin");
			newCv.setUser(emps.get(0));
			newCv.setEtatcivile(Etatcivile.CELEBATAIRE);
			newCv.setTel("0666666666");
			newCv=cvService.SaveCV(newCv);
			CV newCv2 = new CV();
			newCv2.setNom("rahim2");
			newCv2.setPrenom("Soufiane2");
			newCv2.setDesignationCV("CV recrutment 2");
			newCv2.setAdress("Cite val mascort 2");
			newCv2.setEmail("soubonoi2@gmail.com");
			newCv2.setCreatedAt(new Date());
			newCv2.setUpdatedAt(new Date());
			newCv2.setUser(emps.get(0));
			newCv2.setEtatcivile(Etatcivile.MARIEE);
			newCv2.setTel("066666666622");
			newCv2=cvService.SaveCV(newCv2);
			Deplome deplome = new Deplome();
			deplome.setAnnee(2020);
			deplome.setDescription("DEUA inforamtique");
			deplome.setOrganisataion("badji mokhtar");
			deplome.setMois(6);
			deplome.setCreatedAt(new Date());
			deplome.setUpdatedAt(new Date());
			cvService.AddDeplomeToCV(deplome, newCv2.getID());
			Deplome deplome2 = new Deplome();
			deplome2.setAnnee(2020);
			deplome2.setDescription("DEUA inforamtique");
			deplome2.setOrganisataion("badji mokhtar");
			deplome2.setMois(6);
			deplome2.setCreatedAt(new Date());
			deplome2.setUpdatedAt(new Date());
			cvService.AddDeplomeToCV(deplome2, newCv2.getID());
			Experiance exper1 = new Experiance();
			exper1.setAnneeDebut(2001);
			exper1.setAnneeFin(2005);
			exper1.setCreatedAt(new Date());
			exper1.setCurent(false);
			;
			exper1.setDescription("devloppeur");
			exper1.setMoisDebut(1);
			exper1.setMoisFin(5);
			exper1.setOrganisation("XpertSoft");
			exper1.setUpdatedAt(new Date());
			cvService.AddExperianceToCV(exper1, newCv2.getID());
			Compitance comp1 = new Compitance();
			comp1.setDescription("C#");
			comp1.setPourcentage(100);
			cvService.AddCompitanceToCV(comp1, newCv2.getID());

			Stream.of("emploiyeur1", "emploiyeur2", "emploiyeur3").forEach(un -> {
				System.out.println("ajout de l'emploiyeur  : " + un);
				accountService.saveUser(un, un + "@gmail.com", Gender.MALE, "123456", "123456", TypeUser.EUR);
			});
			List<AppUser> emploiyeur = emploiyeeRepository.findByUsername("emploiyeur1");
			
			Projet p = new Projet();
			p.setBudjet(1000);
			p.setCreatedAt(new Date());
			p.setUpdatedAt(new Date());
			p.setDatePostilation(new Date());
			p.setDescription("construire d une cuisine");
			p.setDetail(
					"en est  a la recherche d'un mason califier qui a construit deja des cuisine de qualite a buidjet concidirable");
			p.setEtat(EtatProjet.LANCEMMENT);
			p.setEmploiyeur(emploiyeur.get(0));

			projetRepository.save(p);
			
			System.out.println("ajout nd u projet 1");
			Projet p2 = new Projet();
			p2.setBudjet(3000);
			p2.setCreatedAt(new Date());
			p2.setUpdatedAt(new Date());
			p2.setDatePostilation(new Date());
			p2.setDescription("construire d une cuisine");
			p2.setDetail(
					"en est  a la recherche d'un mason califier qui a construit deja des cuisine de qualite a buidjet concidirable");
			p2.setEtat(EtatProjet.LANCEMMENT);
			p2.setEmploiyeur(emploiyeur.get(0));
 			p2=projetRepository.save(p2);
			System.out.println("ajout nd u projet 2");
			List<AppUser> emploiyee = emploiyeeRepository.findByUsername("admin");
			DemandeRealisation demande1 =new DemandeRealisation("Demande de user 1",p2, emploiyee.get(0),1000.00,newCv);
			demande1.setCreatedAt(new Date());
			demandeRealisationRepository.save(demande1);
			List<AppUser> emploiyee2 = emploiyeeRepository.findByUsername("user2");
			DemandeRealisation demande2 =new DemandeRealisation("Demande de user 1",p2, emploiyee2.get(0),2000.00,null);
			demande2.setCreatedAt(new Date());
			
			demandeRealisationRepository.save(demande2);
			p2.setAcceptedDemande(demande2);
			p2=projetRepository.save(p2);
		};
	}

	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_12)
	 * .select() .apis(RequestHandlerSelectors.basePackage("com.KhadmaNdifa.web"))
	 * .paths(PathSelectors.any()) .build() .apiInfo(apiInfo()); }
	 * 
	 * private ApiInfo apiInfo() { return new
	 * ApiInfoBuilder().title("Library Spring Boot REST API Documentation")
	 * .description("REST APIs For Khadma ndifa cite") .contact(new
	 * Contact("Rahim soufiane", "https://github.com/soufianeBenRahim",
	 * "soubonoi@gmail.com")) .version("1.0") .build(); }
	 */
}
