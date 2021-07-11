package com.sms.demo.Model.User;

import java.util.List;

import com.sms.demo.Model.Role.Role;

public class UserGetById {
    private String apiKey;
    private Long id;
    private String username;
    private String password;
    private Boolean status;
    private String profileImg;

    private List<Role> roles;

    public UserGetById() {

    }

    public UserGetById(String apiKey, Long id, String username, String password, Boolean status, String profileImg,
            List<Role> roles) {
        this.apiKey = apiKey;
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.profileImg = profileImg;
        this.roles = roles;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserGetById [apiKey=" + apiKey + ", id=" + id + ", password=" + password + ", profileImg=" + profileImg
                + ", roles=" + roles + ", status=" + status + ", username=" + username + "]";
    }

}
