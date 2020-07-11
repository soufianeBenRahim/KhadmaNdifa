package com.KhadmaNdifa.web;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.service.AccountService;
import com.KhedmaNdifa.ParentEntities.Gender;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public AppUser register(@RequestBody  UserForm userForm){
    	System.out.println(userForm.getUsername());
        return  accountService.saveUser(
                userForm.getUsername(),userForm.getEmail(),userForm.getGender(),userForm.getPassword(),userForm.getConfirmedPassword(),userForm.getTypeUser());
    }
    
    @GetMapping("/users")
    public List<AppUser> getAllUsers(){
        return  accountService.getAllUsers();
    }
    
    @GetMapping("/GetUserByName")
    public List<AppUser> getUserByName(@RequestParam String name){
        return  accountService.loadUserByUsername(name);
    }
    @GetMapping("/GetUserByID")
    public AppUser getUserById(@RequestParam Long id){
    	System.out.println("appel de la methode GetUserByID pram id ="+id);
        return  accountService.GetUserByID(id);
    }
}

class UserForm{
    private String username;
    private Gender Gender;
    private String Email;
    public Gender getGender() {
		return Gender;
	}
	public void setGender(Gender gender) {
		Gender = gender;
	}
	private String password;
    private String confirmedPassword;
    private String typeUser;
    
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
    
}
