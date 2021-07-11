package com.sms.demo.Model.Invoice;

public class InvoiceList {
    private String Id;
    private String Username;
    private String StudentName;
    private String CourseName;
    private String Fee;
    private String Qty;
    private String TeacherName;
    private String StudyType;
    private String RoomNumber;
    private String Time;
    private String Schedule;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getStudyType() {
        return StudyType;
    }

    public void setStudyType(String studyType) {
        StudyType = studyType;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public InvoiceList(String id, String username, String studentName, String courseName, String fee, String qty,
            String teacherName, String studyType, String roomNumber, String time, String schedule) {
        Id = id;
        Username = username;
        StudentName = studentName;
        CourseName = courseName;
        Fee = fee;
        Qty = qty;
        TeacherName = teacherName;
        StudyType = studyType;
        RoomNumber = roomNumber;
        Time = time;
        Schedule = schedule;
    }

    @Override
    public String toString() {
        return "InvoiceList [CourseName=" + CourseName + ", Fee=" + Fee + ", Id=" + Id + ", Qty=" + Qty
                + ", RoomNumber=" + RoomNumber + ", Schedule=" + Schedule + ", StudentName=" + StudentName
                + ", StudyType=" + StudyType + ", TeacherName=" + TeacherName + ", Time=" + Time + ", Username="
                + Username + "]";
    }

    public InvoiceList() {
    }

}
