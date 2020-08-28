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
import com.KhadmaNdifa.entites.AppRole;
import com.KhadmaNdifa.entites.AppUser;

import com.KhedmaNdifa.ParentEntities.Gender;
import com.KhedmaNdifa.ParentEntities.TypeUser;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String username,String Email,Gender Gender, String password, String confirmedPassword,TypeUser TypeUser) {
        List<AppUser>  users=appUserRepository.findByUsername(username);
        if(!users.isEmpty() ) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        System.out.println(TypeUser);
      
            AppUser user=new AppUser();
            user.setUsername(username);
            user.setActived(true);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setEmail(Email);
            user.setGender(Gender);
            user.setTypeuser(TypeUser);
            this.appUserRepository.save(user);
            addRoleToUser(username,"USER");
            return  user;
      
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public List<AppUser>  loadUserByUsername(String username) {
    	List<AppUser> usrs= appUserRepository.findByUsername(username);
    	System.out.println("loadUserByUsername : "+usrs);
    	return usrs;
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

    public List<AppUser>  GetEmploiyeeByUsername(String userName) {
    	System.out.println("userName : to find is  " + userName);
    	return this.appUserRepository.findByUsername(userName);
    }

	@Override
	public AppUser GetUserByID(Long ID) {
		return this.appUserRepository.findById(ID).get();
	}; 
    

   
}
