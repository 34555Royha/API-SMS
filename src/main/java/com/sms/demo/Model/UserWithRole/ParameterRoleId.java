package com.sms.demo.Model.UserWithRole;

public class ParameterRoleId {
    public String id;
    public String role;

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

    public ParameterRoleId(String id, String role) {
        this.id = id;
        this.role = role;
    }

    @Override
    public String toString() {
        return "ParameterRoleId [id=" + id + ", role=" + role + "]";
    }

    public ParameterRoleId() {
    }

}
