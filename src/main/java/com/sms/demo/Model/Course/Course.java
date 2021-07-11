package com.sms.demo.Model.Course;

public class Course {
    private String Id;
    private String Name;
    private Double Fee;
    private String Other;
    private String Cate_Id;
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
    public Course(String id, String name, Double fee, String other, String cate_Id) {
        Id = id;
        Name = name;
        Fee = fee;
        Other = other;
        Cate_Id = cate_Id;
    }
    @Override
    public String toString() {
        return "Course [Cate_Id=" + Cate_Id + ", Fee=" + Fee + ", Id=" + Id + ", Name=" + Name + ", Other=" + Other
                + "]";
    }

    
}
