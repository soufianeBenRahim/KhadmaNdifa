package com.KhadmaNdifa;

import java.util.stream.Stream;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class KhadmaNdifaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhadmaNdifaApplication.class, args);
	}
    @Bean
    CommandLineRunner start(com.KhadmaNdifa.Security.service.AccountService accountService){
        return args->{
        	 accountService.delletAll();
            accountService.save(new com.KhadmaNdifa.entites.AppRole(null,"USER"));
            accountService.save(new com.KhadmaNdifa.entites.AppRole(null,"ADMIN"));
            Stream.of("user1","user2","user3","admin").forEach(un->{
            	System.out.println("ajout de l'utilisteur : "+un);
                accountService.saveUser(un,"1234","1234", "EUR");
            });
            accountService.addRoleToUser("admin","ADMIN");
            System.out.println("ajouter le rol Admin a l'utilistaue admin : ");
        };
    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
