package com.sms.demo.Model.Teacher;

public class TeacherCreate {
    private String Name;
    private String Sex;
    private String DateOfBirth;
    private String Address;
    private String Phone;

    
    public TeacherCreate() {
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getSex() {
        return Sex;
    }
    public void setSex(String sex) {
        Sex = sex;
    }
    public String getDateOfBirth() {
        return DateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        this.Phone = phone;
    }
    public TeacherCreate(String name, String sex, String dateOfBirth, String address, String phone) {
        Name = name;
        Sex = sex;
        DateOfBirth = dateOfBirth;
        Address = address;
        this.Phone = phone;
    }
    @Override
    public String toString() {
        return "TeacherCreate [Address=" + Address + ", DateOfBirth=" + DateOfBirth + ", Name=" + Name + ", Sex=" + Sex
                + ", phone=" + Phone + "]";
    }

    
}
