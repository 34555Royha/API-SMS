package com.sms.demo.Model.Course;

public class CourseList {
    private String Id;
    private String Name;
    private Double Fee;
    private String Other;
    private String Cate_Name;

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

    public String getCate_Name() {
        return Cate_Name;
    }

    public void setCate_Name(String cate_Name) {
        Cate_Name = cate_Name;
    }

    public CourseList(String id, String name, Double fee, String other, String cate_Name) {
        Id = id;
        Name = name;
        Fee = fee;
        Other = other;
        Cate_Name = cate_Name;
    }

    @Override
    public String toString() {
        return "CourseList [Cate_Name=" + Cate_Name + ", Fee=" + Fee + ", Id=" + Id + ", Name=" + Name + ", Other="
                + Other + "]";
    }

    public CourseList() {
    }

}
