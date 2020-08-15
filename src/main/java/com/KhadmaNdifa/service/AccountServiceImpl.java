package com.KhadmaNdifa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KhadmaNdifa.dao.AppRoleRepository;
import com.KhadmaNdifa.dao.AppUserRepository;
import com.KhadmaNdifa.dao.EmploiyeeRepository;
import com.KhadmaNdifa.dao.EmploiyeurRepository;
import com.KhadmaNdifa.entites.AppRole;
import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.entites.Emploiyee;
import com.KhadmaNdifa.entites.Emploiyeur;
import com.KhedmaNdifa.ParentEntities.Gender;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private EmploiyeurRepository emploiyeurRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private EmploiyeeRepository emploiyeeRepositrory;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository,EmploiyeurRepository emploiyeurRepository,EmploiyeeRepository emploiyeeRepositrory, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.emploiyeurRepository=emploiyeurRepository;
        this.emploiyeeRepositrory=emploiyeeRepositrory;
    }

    @Override
    public AppUser saveUser(String username,String Email,Gender Gender, String password, String confirmedPassword,String TypeUser) {
        List<AppUser>  users=appUserRepository.findByUsername(username);
        if(!users.isEmpty() ) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        System.out.println(TypeUser);
        if("EUR".equals(TypeUser)) {
            Emploiyeur employeur=new Emploiyeur();
            employeur.setUsername(username);
            employeur.setActived(true);
            employeur.setPassword(bCryptPasswordEncoder.encode(password));
            employeur.setEmail(Email);
            employeur.setGender(Gender);
            this.emploiyeurRepository.save(employeur);
            addRoleToUser(username,"USER");
            return  employeur;
        }else {
            Emploiyee emploiyee=new Emploiyee();
            emploiyee.setUsername(username);
            emploiyee.setActived(true);
            emploiyee.setPassword(bCryptPasswordEncoder.encode(password));
            emploiyee.setEmail(Email);
            this.emploiyeeRepositrory.save(emploiyee);
            addRoleToUser(username,"USER");
            return  emploiyee;
        }
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public List<AppUser> loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        List<AppUser> appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        if(appUser!=null) appUser.get(0).getRoles().add(appRole);
    }
    public void delletAll() 
    {
    	appUserRepository.deleteAll();
    	appRoleRepository.deleteAll();
    }
    public List<AppUser> getAllUsers(){
    	return appUserRepository.findAll();
    }

    public List<Emploiyee>  GetEmploiyeeByUsername(String userName) {
    	System.out.println("userName : to find is  " + userName);
    	return this.emploiyeeRepositrory.findByUsername(userName);
    }

	@Override
	public AppUser GetUserByID(Long ID) {
		return this.appUserRepository.findById(ID).get();
	}; 
    

   
}
