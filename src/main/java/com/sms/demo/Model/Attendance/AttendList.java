package com.sms.demo.Model.Attendance;

public class AttendList {
    private String Id;
    private String Date;
    private String Status;
    private String StudenName;
    private String TeacherName;
    private String CourseName;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStudenName() {
        return StudenName;
    }

    public void setStudenName(String studenName) {
        StudenName = studenName;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public AttendList(String id, String date, String status, String studenName, String teacherName, String courseName) {
        Id = id;
        Date = date;
        Status = status;
        StudenName = studenName;
        TeacherName = teacherName;
        CourseName = courseName;
    }

    @Override
    public String toString() {
        return "AttendList [CourseName=" + CourseName + ", Date=" + Date + ", Id=" + Id + ", Status=" + Status
                + ", StudenName=" + StudenName + ", TeacherName=" + TeacherName + "]";
    }

    public AttendList() {
    }

}
