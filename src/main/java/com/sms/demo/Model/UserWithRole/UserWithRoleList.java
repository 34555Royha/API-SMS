package com.sms.demo.Model.UserWithRole;

public class UserWithRoleList {
    private String Id;
    private String Username;
    private String Role;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public UserWithRoleList(String id, String username, String role) {
        Id = id;
        Username = username;
        Role = role;
    }

    @Override
    public String toString() {
        return "UserWithRoleList [Id=" + Id + ", Role=" + Role + ", Username=" + Username + "]";
    }

    public UserWithRoleList() {
    }

}
