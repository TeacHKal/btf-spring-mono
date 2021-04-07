package com.teachkal.btf.spring.mono.auth.security;

import lombok.Getter;
@Getter
public enum AppUserPermission {

    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),
    ORDER_UPDATE("order:update"),
    ORDER_ITEM_READ("orderItem:read"),
    ORDER_ITEM_WRITE("orderItem:read"),
    ORDER_ITEM_UPDATE("orderItem:read");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

}
