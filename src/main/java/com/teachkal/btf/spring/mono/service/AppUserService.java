package com.teachkal.btf.spring.mono.service;

import com.teachkal.btf.spring.mono.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    AppUser addAppUser(AppUser appUser);
    AppUser getAppUser(Long id);
    List<AppUser> getAppUsers();
    AppUser editAppUser(AppUser appUser, Long id);
    AppUser deleteAppUser(Long id);
    AppUser findByEmail(String email);
}
