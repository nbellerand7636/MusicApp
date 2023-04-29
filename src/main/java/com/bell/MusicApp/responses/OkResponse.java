package com.bell.MusicApp.responses;

import org.springframework.stereotype.Component;

public class OkResponse {
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
