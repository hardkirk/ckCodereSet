package org.example.cloudsecuritydemo.auth.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleEnum {

    USER("USER"),
    ADMIN("ADMIN");

    private final String value;

    public String getValue() {
        return this.value;
    }
}
