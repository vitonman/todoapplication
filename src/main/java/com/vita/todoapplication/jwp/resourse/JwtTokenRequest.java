package com.vita.todoapplication.jwp.resourse;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

/*     "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aXRhIiwiZXhwIjoxNjM5NjQ1NzU1LCJpYXQiOjE2MzkwNDA5NTV9
             .IfDPG7AUdmYmIlS9ej-1JxlvpK1juFpEjgm81nty5HiFQA7n8RSQtx-P0OrR-h6ua4lVbuLtsNd8s2DXLweCWg"*/

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
