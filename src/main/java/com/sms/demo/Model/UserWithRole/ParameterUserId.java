package com.sms.demo.Model.UserWithRole;

public class ParameterUserId {
    public String id;
    public String username;

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

    @Override
    public String toString() {
        return "ParameterUserId [id=" + id + ", username=" + username + "]";
    }

    public ParameterUserId(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public ParameterUserId() {
    }

}
