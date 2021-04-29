package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.model.AppUser;
import com.teachkal.btf.spring.mono.model.dto.AppUserDtoResponse;
import com.teachkal.btf.spring.mono.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService appUserService;

    @Autowired
    public AuthController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<AppUserDtoResponse> register(@RequestBody AppUser appUser){
        AppUser user = appUserService.addAppUser(appUser);
        AppUserDtoResponse response = AppUserDtoResponse.from(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
