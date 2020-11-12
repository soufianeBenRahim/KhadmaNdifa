package com.KhadmaNdifa.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.KhadmaNdifa.entites.AppRole;
import com.KhadmaNdifa.entites.AppUser;
import com.KhadmaNdifa.service.AccountService;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		java.util.List<AppUser> appUse = accountService.loadUserByUsername(username);
		if (appUse == null)
			throw new UsernameNotFoundException("invalid user");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Collection<AppRole> roles = appUse.get(0).getRoles();
		roles.forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(appUse.get(0).getUsername(), appUse.get(0).getPassword(), authorities);
	}
}
