package com.swcoaching.example1.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserSignUpDto {
    private String username;
    private String password;
    private String name;

    @Builder
    public UserSignUpDto(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
