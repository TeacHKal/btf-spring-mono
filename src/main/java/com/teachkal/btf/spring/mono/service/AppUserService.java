package com.teachkal.btf.spring.mono.service;

import com.teachkal.btf.spring.mono.model.entity.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser addAppUser(AppUser appUser);
    AppUser getAppUser(Long id);
    List<AppUser> getAppUsers();
    AppUser editAppUser(AppUser appUser, Long id);
    AppUser deleteAppUser(Long id);
    AppUser findByEmail(String email);
    boolean isEmailExist(String email);
}
