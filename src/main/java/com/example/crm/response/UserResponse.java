package com.example.crm.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String surname;
    private String phoneNumber;
    private boolean active;
    private String gender;
    private String email;
    private byte[] profilePhoto;

    private String role;
}
