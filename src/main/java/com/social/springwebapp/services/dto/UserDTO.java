package com.social.springwebapp.services.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String city;
    private int postalcode;
    private String address;
}
