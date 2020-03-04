package com.KhadmaNdifa.entites;

import com.KhedmaNdifa.ParentEntities.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;





import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeUser",discriminatorType = DiscriminatorType.STRING,length = 4)
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private Gender gender;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean actived;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();
    
	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", actived=" + actived + "]";
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
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}

	
	public AppUser(Long id, String username, String password, boolean actived) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.actived = actived;
	}
	public AppUser() {
		super();
	}
    
    
}