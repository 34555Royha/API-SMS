package com.sms.demo.Model.Course;

public class CourseCreate {
    private String Name;
    private Double Fee;
    private String Other;
    private String Cate_Id;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Double getFee() {
        return Fee;
    }
    public void setFee(Double fee) {
        Fee = fee;
    }
    public String getOther() {
        return Other;
    }
    public void setOther(String other) {
        Other = other;
    }
    public String getCate_Id() {
        return Cate_Id;
    }
    public void setCate_Id(String cate_Id) {
        Cate_Id = cate_Id;
    }
    public CourseCreate(String name, Double fee, String other, String cate_Id) {
        Name = name;
        Fee = fee;
        Other = other;
        Cate_Id = cate_Id;
    }
    @Override
    public String toString() {
        return "CourseCreate [Cate_Id=" + Cate_Id + ", Fee=" + Fee + ", Name=" + Name + ", Other=" + Other + "]";
    }

    
}
