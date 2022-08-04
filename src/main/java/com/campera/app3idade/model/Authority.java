package com.campera.app3idade.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    SYSADMIN("SYSADMIN"),

    ACCOUNT_ADMIN("ACCOUNT_ADMIN"),
    CAREGIVER("CAREGIVER"),
    PATIENT("PATIENT"),
    ;

    private final String name;

    Authority(final String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
