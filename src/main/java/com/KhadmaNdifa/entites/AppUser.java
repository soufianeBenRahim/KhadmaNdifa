package com.KhadmaNdifa.entites;

import com.KhedmaNdifa.ParentEntities.Gender;
import com.KhedmaNdifa.ParentEntities.TypeUser;
import com.fasterxml.jackson.annotation.JsonProperty;





import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String Email;
	private Gender gender;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean actived;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();
    private TypeUser typeuser;
	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", Email=" + Email + ", Gender=" + gender +", password=" + password + ", actived=" + actived + "]";
	}
	


	public AppUser(Long id, String username, String email, Gender gender, String password, boolean actived,TypeUser _typeuser) {
		super();
		this.id = id;
		this.username = username;
		this.Email = email;
		this.gender = gender;
		this.password = password;
		this.actived = actived;
		this.typeuser=_typeuser;
	}
	public AppUser() {
		super();
	}
	
    public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public TypeUser getTypeuser() {
		return typeuser;
	}

	public void setTypeuser(TypeUser typeuser) {
		this.typeuser = typeuser;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
    
}
