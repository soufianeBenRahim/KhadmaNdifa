package com.KhadmaNdifa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KhadmaNdifa.entites.AppUser;
import java.lang.String;
import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	List<AppUser> findByUsername(String username);
}
