package com.social.springwebapp.exceptions;

public class EmailAlreadyUsedException extends RuntimeException {
    private String email;

    public EmailAlreadyUsedException(String email) {
        super("User already exist for this email -> " + email);
        this.email=email;
    }

    public String getEmail() {
        return this.email;
    }
}
