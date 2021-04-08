package com.teachkal.btf.spring.mono.auth.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.teachkal.btf.spring.mono.auth.security.AppUserPermission.*;


public enum AppUserRole {

    ADMIN(Sets.newHashSet(
            ORDER_READ, ORDER_WRITE, ORDER_UPDATE,
            ORDER_ITEM_READ, ORDER_ITEM_WRITE, ORDER_ITEM_UPDATE
    )),
    MODERATOR(Sets.newHashSet()),   //TODO need to give permissions
    USER_SUB(Sets.newHashSet()),    //TODO need to give permissions
    USER_BASIC(Sets.newHashSet(
            ORDER_ITEM_READ,
            ORDER_READ, ORDER_WRITE
    )
    );

    private final Set<AppUserPermission> permission;

    AppUserRole(Set<AppUserPermission> permission) {
        this.permission = permission;
    }

    public Set<AppUserPermission> getPermission() {
        return permission;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" +  this.name()));

        return permissions;
    }

}
