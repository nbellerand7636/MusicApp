package com.bell.MusicApp.requests;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserLoginRequest {

    private String username;

    private String password;
}
