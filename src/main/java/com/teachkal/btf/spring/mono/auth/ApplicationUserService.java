package com.teachkal.btf.spring.mono.auth;

import com.teachkal.btf.spring.mono.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final AppUserService appUserService;

    @Autowired
    public ApplicationUserService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        return appUserService.findByEmail(email);
    }
}
