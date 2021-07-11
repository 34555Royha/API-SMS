package com.sms.demo.Model.User;

public class UserCreate {
    private String apiKey;
    private String username;
    private String password;
    private Boolean status;
    private String profileImg;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
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

    public UserCreate(String apiKey, String username, String password, Boolean status, String profileImg) {
        this.apiKey = apiKey;
        this.username = username;
        this.password = password;
        this.status = status;
        this.profileImg = profileImg;
    }

    @Override
    public String toString() {
        return "UserCreate [apiKey=" + apiKey + ", password=" + password + ", profileImg=" + profileImg + ", status="
                + status + ", username=" + username + "]";
    }
}
