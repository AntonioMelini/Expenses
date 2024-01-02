package com.project.dto.request;

public class AuthRequestDto {
    private String email;
    private String Password;

    public AuthRequestDto(String email, String password) {
        this.email = email;
        Password = password;
    }

    public AuthRequestDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
