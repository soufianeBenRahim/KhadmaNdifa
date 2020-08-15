package com.KhadmaNdifa.service;

import java.util.ArrayList;
import java.util.List;

import com.KhadmaNdifa.entites.AppRole;
import com.KhadmaNdifa.entites.AppUser;
import com.KhedmaNdifa.ParentEntities.Gender;
import com.KhedmaNdifa.ParentEntities.TypeUser;

public interface AccountService {
    public AppUser saveUser(String username,String Email,Gender Gender,String password,String confirmedPassword,TypeUser TypeUser  );
    public AppRole save(AppRole role);
    public List<AppUser> loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public void delletAll();
    public List<AppUser> getAllUsers();
    public List<AppUser>  GetEmploiyeeByUsername(String username); 
    public AppUser GetUserByID(Long ID);
}
