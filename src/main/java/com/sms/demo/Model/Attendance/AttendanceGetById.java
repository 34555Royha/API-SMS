package com.sms.demo.Model.Attendance;


public class AttendanceGetById {
    private String Id;
    private String Date;
    private String Student_Id;
    private Boolean Status;
    private String Teacher_Id;
    private String Course_Id;
    // private List<Student> students;
    
    // @Override
    // public String toString() {
    //     return "AttendanceGetById [Course_Id=" + Course_Id + ", Date=" + Date + ", Id=" + Id + ", Status=" + Status
    //             + ", Student_Id=" + Student_Id + ", Teacher_Id=" + Teacher_Id + ", students=" + students + "]";
    // }
    // public AttendanceGetById(String id, String date, String student_Id, Boolean status, String teacher_Id,
    //         String course_Id, List<Student> students) {
    //     Id = id;
    //     Date = date;
    //     Student_Id = student_Id;
    //     Status = status;
    //     Teacher_Id = teacher_Id;
    //     Course_Id = course_Id;
    //     this.students = students;
    // }
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
    // public List<Student> getStudents() {
    //     return students;
    // }
    // public void setStudents(List<Student> students) {
    //     this.students = students;
    // }
    
    
}
