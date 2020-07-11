package com.KhadmaNdifa.service;

import java.util.ArrayList;
import java.util.List;

import com.KhadmaNdifa.entites.AppRole;
import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.entites.Emploiyee;
import com.KhadmaNdifa.entites.Emploiyeur;
import com.KhedmaNdifa.ParentEntities.Gender;

public interface AccountService {
    public AppUser saveUser(String username,String Email,Gender Gender,String password,String confirmedPassword,String TypeUser  );
    public AppRole save(AppRole role);
    public List<AppUser> loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public void delletAll();
    public List<AppUser> getAllUsers();
    public List<Emploiyee>  GetEmploiyeeByUsername(String username); 
    public AppUser GetUserByID(Long ID);
}
