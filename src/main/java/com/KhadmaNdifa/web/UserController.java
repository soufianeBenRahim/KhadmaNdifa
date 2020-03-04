package com.KhadmaNdifa.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KhadmaNdifa.Security.service.AccountService;
import com.KhadmaNdifa.entites.AppUser;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public AppUser register(@RequestBody  UserForm userForm){
        return  accountService.saveUser(
                userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),userForm.getTypeUser());
    }
    
    @GetMapping("/users")
    public List<AppUser> getAllUsers(){
        return  accountService.getAllUsers();
                
    }
}

class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
    private String typeUser;
    
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
