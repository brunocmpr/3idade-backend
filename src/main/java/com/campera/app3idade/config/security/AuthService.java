package com.campera.app3idade.config.security;

import com.campera.app3idade.model.AppUser;
import com.campera.app3idade.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userOptional = repository.findByEmail(username);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new UsernameNotFoundException("Invalid credentials!");
    }

}
