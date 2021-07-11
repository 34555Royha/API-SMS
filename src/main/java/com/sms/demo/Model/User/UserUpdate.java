package com.sms.demo.Model.User;

public class UserUpdate {
    private String apiKey;
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public UserUpdate(String apiKey, String id, String username, String password, Boolean status, String profileImg) {
        this.apiKey = apiKey;
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.profileImg = profileImg;
    }

    @Override
    public String toString() {
        return "UserUpdate [apiKey=" + apiKey + ", id=" + id + ", password=" + password + ", profileImg=" + profileImg
                + ", status=" + status + ", username=" + username + "]";
    }

}
