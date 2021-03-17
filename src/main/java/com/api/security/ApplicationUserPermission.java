package com.api.security;

public enum ApplicationUserPermission {
    USER_VIEW("user:view"),
    USER_ADD("user:add"),
    USER_EDIT("user:edit"),
    USER_REMOVE("user:remove");

    private String permission ;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
