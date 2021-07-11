package com.sms.demo.Model.Category;

public class CategoryCreate {
    private String Name;
    private String Description;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public CategoryCreate(String name, String description) {
        Name = name;
        Description = description;
    }
    @Override
    public String toString() {
        return "CategoryCreate [Description=" + Description + ", Name=" + Name + "]";
    }
}
