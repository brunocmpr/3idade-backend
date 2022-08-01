package com.campera.app3idade.repository;

import com.campera.app3idade.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long>{
	Optional<AppUser> findByEmail(String email);
}
