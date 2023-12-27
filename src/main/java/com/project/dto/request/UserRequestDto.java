package com.project.dto.request;

import com.project.entity.Role;

public class UserRequestDto {
    private String email;
    private String name;
    private String lastname;
    private String password;
    private Role role;

    public UserRequestDto(String email, String name, String lastname, String password, Role role) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
    }

    public UserRequestDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
