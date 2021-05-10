package com.teachkal.btf.spring.mono.model.dto;

import com.teachkal.btf.spring.mono.auth.security.AppUserRole;
import com.teachkal.btf.spring.mono.model.entity.AppUser;
import lombok.Data;

@Data
public class AppUserDtoResponse {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean isLocked;
    private Boolean isExpired;
    private Boolean isEnabled;
    private AppUserRole appUserRole;

    public static AppUserDtoResponse from (AppUser appUser) {

        AppUserDtoResponse dto = new AppUserDtoResponse();

        dto.setId(appUser.getId());
        dto.setEmail(appUser.getEmail());
        dto.setFirstName(appUser.getFirstName());
        dto.setLastName(appUser.getLastName());
        dto.setIsLocked(appUser.getIsLocked());
        dto.setIsExpired(appUser.getIsExpired());
        dto.setIsEnabled(appUser.getIsEnabled());
        dto.setAppUserRole(appUser.getAppUserRole());

        return dto;
    }

}
