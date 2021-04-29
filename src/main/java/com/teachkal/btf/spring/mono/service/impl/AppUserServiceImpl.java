package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.auth.security.AppUserRole;
import com.teachkal.btf.spring.mono.model.AppUser;
import com.teachkal.btf.spring.mono.model.exception.UserEmailNotFoundException;
import com.teachkal.btf.spring.mono.repository.AppUserRepository;
import com.teachkal.btf.spring.mono.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User not found with email: %s", email)));
    }

    @Override
    public AppUser addAppUser(AppUser appUser) {
//        if(isEmailExist(appUser.getEmail())) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT,
//                    MessageFormat.format("Email  already exists: {0}", appUser.getEmail())
//                    );
//        };

        boolean isEmailExist = isEmailExist(appUser.getEmail());
        if(isEmailExist){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    MessageFormat.format("Email  already exists: {0}", appUser.getEmail())
            );
        }

        appUser.setAppUserRole(AppUserRole.USER_BASIC);
        appUser.setIsExpired(false);
        appUser.setIsLocked(false);
        appUser.setIsEnabled(true);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser getAppUser(Long id) {
        return appUserRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User not found with id: %s", id))
                );
    }

    @Override
    public List<AppUser> getAppUsers() {
        return StreamSupport.stream(appUserRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public AppUser editAppUser(AppUser appUser, Long id) {
        AppUser appUserToEdit = getAppUser(id);

        appUserToEdit.setAppUserRole(appUser.getAppUserRole());
        appUserToEdit.setEmail(appUser.getEmail());
        appUserToEdit.setFirstName(appUser.getFirstName());
        appUserToEdit.setLastName(appUser.getLastName());
        appUserToEdit.setIsLocked(appUser.getIsLocked());
        appUserToEdit.setIsExpired(appUser.getIsExpired());
        appUserToEdit.setIsEnabled(appUser.getIsEnabled());

        return appUserToEdit;
    }

    @Override
    public AppUser deleteAppUser(Long id) {
        AppUser appUser = getAppUser(id);
        appUserRepository.delete(appUser);
        return appUser;
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UserEmailNotFoundException(email));
    }

    @Override
    public boolean isEmailExist(String email) {

        return appUserRepository.isEmailExist(email);

    }


}
