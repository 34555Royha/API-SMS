package com.sms.demo.Model.Role;

public class RoleUpdate{
    String id;
    String role;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public RoleUpdate(String id, String role) {
        this.id = id;
        this.role = role;
    }
    @Override
    public String toString() {
        return "RoleUpdate [id=" + id + ", role=" + role + "]";
    }
}
