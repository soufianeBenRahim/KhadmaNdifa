package com.KhadmaNdifa.Security.service;

import java.util.List;

import com.KhadmaNdifa.entites.AppRole;
import com.KhadmaNdifa.entites.AppUser;

public interface AccountService {
    public AppUser saveUser(String username,String password,String confirmedPassword,String TypeUser  );
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public void delletAll();
    public List<AppUser> getAllUsers();

}
