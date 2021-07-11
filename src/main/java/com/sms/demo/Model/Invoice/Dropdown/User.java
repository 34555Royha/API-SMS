package com.sms.demo.Model.Invoice.Dropdown;

public class User {
    private String Id;
    private String username;
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public User(String id, String username) {
        Id = id;
        this.username = username;
    }
    @Override
    public String toString() {
        return "User [Id=" + Id + ", username=" + username + "]";
    }
}
