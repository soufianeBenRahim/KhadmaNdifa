package com.KhadmaNdifa;

import java.util.Date;
import java.util.stream.Stream;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.KhadmaNdifa.dao.AppUserRepository;
import com.KhadmaNdifa.entites.CV;
import com.KhadmaNdifa.entites.Compitance;
import com.KhadmaNdifa.entites.Deplome;
import com.KhadmaNdifa.entites.Experiance;
import com.KhadmaNdifa.service.CVService;
import com.KhedmaNdifa.ParentEntities.Etatcivile;
import com.KhedmaNdifa.ParentEntities.TypeUser;

@SpringBootApplication
public class KhadmaNdifaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhadmaNdifaApplication.class, args);
	}
    @Bean
    CommandLineRunner start(com.KhadmaNdifa.service.AccountService accountService,CVService cvService,
    		AppUserRepository emploiyeeRepository){
        return args->{
        	accountService.delletAll();
            accountService.save(new com.KhadmaNdifa.entites.AppRole(null,"USER"));
            accountService.save(new com.KhadmaNdifa.entites.AppRole(null,"ADMIN"));
            Stream.of("user1","user2","user3","admin").forEach(un->{
            	System.out.println("ajout de l'utilisteur : "+un);
                accountService.saveUser(un,un+"@gmail.com",null,"1234","1234", TypeUser.EE);
            });
            accountService.addRoleToUser("admin","ADMIN");
            System.out.println("ajouter le rol Admin a l'utilistaue admin : ");
            cvService.DeletAll();
            CV newCv= new CV();
            newCv.setNom("rahim");
            newCv.setPrenom("Soufiane");
            newCv.setDesignationCV("CV recrutment 1");
            newCv.setAdress("Cite val mascort");
            newCv.setEmail("soubonoi@gmail.com");
            newCv.setCreatedAt(new Date());
            newCv.setUpdatedAt(new Date());
            emploiyeeRepository.findByUsername("admin").forEach(emp -> {
            	System.out.println(emp.toString());
            	newCv.setUser(emp);
              });
            newCv.setEtatcivile(Etatcivile.CELEBATAIRE);
            newCv.setTel("0666666666");
            cvService.SaveCV(newCv);
            CV newCv2= new CV();
            newCv2.setNom("rahim2");
            newCv2.setPrenom("Soufiane2");
            newCv2.setDesignationCV("CV recrutment 2");
            newCv2.setAdress("Cite val mascort 2");
            newCv2.setEmail("soubonoi2@gmail.com");
            newCv2.setCreatedAt(new Date());
            newCv2.setUpdatedAt(new Date());
            emploiyeeRepository.findByUsername("admin").forEach(emp -> {
            	System.out.println(emp.toString());
            	newCv2.setUser(emp);
              });
            newCv2.setEtatcivile(Etatcivile.MARIEE);
            newCv2.setTel("066666666622");
            cvService.SaveCV(newCv2);
            Deplome deplome =new Deplome();
           deplome.setAnnee(2020);
           deplome.setDescription("DEUA inforamtique");
           deplome.setOrganisataion("badji mokhtar");
           deplome.setMois(6);
           deplome.setCreatedAt(new Date());
           deplome.setUpdatedAt(new Date());
           cvService.AddDeplomeToCV(deplome, newCv2.getID());
           Deplome deplome2 =new Deplome();
           deplome2.setAnnee(2020);
           deplome2.setDescription("DEUA inforamtique");
           deplome2.setOrganisataion("badji mokhtar");
           deplome2.setMois(6);
           deplome2.setCreatedAt(new Date());
           deplome2.setUpdatedAt(new Date());
           cvService.AddDeplomeToCV(deplome2, newCv2.getID());
           Experiance exper1 = new  Experiance();
           exper1.setAnneeDebut(2001);
           exper1.setAnneeFin(2005);
           exper1.setCreatedAt(new Date());
           exper1.setCurent(false);;
           exper1.setDescription("devloppeur");
           exper1.setMoisDebut(1);
           exper1.setMoisFin(5);
           exper1.setOrganisation("XpertSoft");
           exper1.setUpdatedAt(new Date());
           cvService.AddExperianceToCV(exper1, newCv2.getID());
           Compitance comp1=new Compitance();
           comp1.setDescription("C#");
           comp1.setPourcentage(100);
           cvService.AddCompitanceToCV(comp1, newCv2.getID());           
        };
    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
