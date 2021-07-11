package com.sms.demo.Model.Student;

public class Student {
    private String Id;
    private String Name;
    private String Sex;
    private String DateOfBirth;
    private String Address;
    private String Phone;
    private String Photo;

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
        Phone = phone;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public Student(String id, String name, String sex, String dateOfBirth, String address, String phone, String photo) {
        Id = id;
        Name = name;
        Sex = sex;
        DateOfBirth = dateOfBirth;
        Address = address;
        Phone = phone;
        Photo = photo;
    }

    @Override
    public String toString() {
        return "Student [Address=" + Address + ", DateOfBirth=" + DateOfBirth + ", Id=" + Id + ", Name=" + Name
                + ", Phone=" + Phone + ", Photo=" + Photo + ", Sex=" + Sex + "]";
    }

    public Student() {
    }

}
