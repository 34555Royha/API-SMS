package com.sms.demo.Model.Attendance;

public class Attendance {
    private String Id;
    private String Date;
    private String Student_Id;
    private Boolean Status;
    private String Teacher_Id;
    private String Course_Id;
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
    public String getStudent_Id() {
        return Student_Id;
    }
    public void setStudent_Id(String student_Id) {
        Student_Id = student_Id;
    }
    public Boolean getStatus() {
        return Status;
    }
    public void setStatus(Boolean status) {
        Status = status;
    }
    public String getTeacher_Id() {
        return Teacher_Id;
    }
    public void setTeacher_Id(String teacher_Id) {
        Teacher_Id = teacher_Id;
    }
    public String getCourse_Id() {
        return Course_Id;
    }
    public void setCourse_Id(String course_Id) {
        Course_Id = course_Id;
    }
    public Attendance(String id, String date, String student_Id, Boolean status, String teacher_Id, String course_Id) {
        Id = id;
        Date = date;
        Student_Id = student_Id;
        Status = status;
        Teacher_Id = teacher_Id;
        Course_Id = course_Id;
    }
    @Override
    public String toString() {
        return "Attendance [Course_Id=" + Course_Id + ", Date=" + Date + ", Id=" + Id + ", Status=" + Status
                + ", Student_Id=" + Student_Id + ", Teacher_Id=" + Teacher_Id + "]";
    }    
}
