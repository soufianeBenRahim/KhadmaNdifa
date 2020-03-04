package com.KhadmaNdifa.Security.service;

import java.util.List;
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
    public AppUser saveUser(String username, String password, String confirmedPassword,String TypeUser) {
        AppUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        if("EUR".equals(TypeUser)) {
            Emploiyeur employeur=new Emploiyeur();
            employeur.setUsername(username);
            employeur.setActived(true);
            employeur.setPassword(bCryptPasswordEncoder.encode(password));
            this.emploiyeurRepository.save(employeur);
            addRoleToUser(username,"USER");
            return  employeur;
        }else {
            Emploiyee emploiyee=new Emploiyee();
            emploiyee.setUsername(username);
            emploiyee.setActived(true);
            emploiyee.setPassword(bCryptPasswordEncoder.encode(password));
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
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }
    public void delletAll() 
    {
    	appUserRepository.deleteAll();
    	appRoleRepository.deleteAll();
    }
    public List<AppUser> getAllUsers(){
    	return appUserRepository.findAll();
    }
}
