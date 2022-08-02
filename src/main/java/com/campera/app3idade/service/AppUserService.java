package com.campera.app3idade.service;

import com.campera.app3idade.model.AppUser;
import com.campera.app3idade.model.datatransfer.conversion.AppUserConverter;
import com.campera.app3idade.model.datatransfer.dto.AppUserDto;
import com.campera.app3idade.model.datatransfer.form.AppUserForm;
import com.campera.app3idade.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    AppUserRepository userRepository;

    public AppUserDto register(AppUserForm appUserForm){
        AppUser appUser = AppUserConverter.convertFromForm(appUserForm);
        appUser = userRepository.save(appUser);
        return AppUserConverter.convertToDto(appUser);
    }
}
