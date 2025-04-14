package com.ecom.ecommerce.security.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserInfoResponse {
    private String jwtToken;
    @Getter
    @Setter
    private Long id;
    private String username;
    private List<String> roles;

    public UserInfoResponse(Long id,String username, List<String> roles, String jwtToken) {
        this.username = username;
        this.id = id;
        this.roles = roles;
        this.jwtToken = jwtToken;
    }

    public UserInfoResponse(Long id, String username, List<String> roles) {
        this.username = username;
        this.id = id;
        this.roles = roles;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}