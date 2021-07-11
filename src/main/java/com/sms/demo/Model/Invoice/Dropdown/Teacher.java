package com.sms.demo.Model.Invoice.Dropdown;

public class Teacher {
    private String Id;
    private String Name;
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Teacher(String id, String name) {
        Id = id;
        Name = name;
    }
    @Override
    public String toString() {
        return "Course [Id=" + Id + ", Name=" + Name + "]";
    }
}
