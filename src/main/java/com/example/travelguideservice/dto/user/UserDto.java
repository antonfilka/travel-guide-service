package com.example.travelguideservice.dto.user;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String phone;
    private Integer status;



}
