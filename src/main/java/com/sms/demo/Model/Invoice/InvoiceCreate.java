package com.sms.demo.Model.Invoice;

public class InvoiceCreate {
    private String UserId;
    private String StudentId;
    private String TeacherId;
    private String CourseId;
    private String StudyTypeId;
    private Double Fee;
    private Integer Qty;
    private String RoomId;
    private String TimeId;
    private String ScheduleId;
    private String 	InvoiceDate;
    public String getUserId() {
        return UserId;
    }
    public void setUserId(String userId) {
        UserId = userId;
    }
    public String getStudentId() {
        return StudentId;
    }
    public void setStudentId(String studentId) {
        StudentId = studentId;
    }
    public String getTeacherId() {
        return TeacherId;
    }
    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }
    public String getCourseId() {
        return CourseId;
    }
    public void setCourseId(String courseId) {
        CourseId = courseId;
    }
    public String getStudyTypeId() {
        return StudyTypeId;
    }
    public void setStudyTypeId(String studyType) {
        StudyTypeId = studyType;
    }
    public Double getFee() {
        return Fee;
    }
    public void setFee(Double fee) {
        Fee = fee;
    }
    public Integer getQty() {
        return Qty;
    }
    public void setQty(Integer qty) {
        Qty = qty;
    }
    public String getRoomId() {
        return RoomId;
    }
    public void setRoomId(String roomId) {
        RoomId = roomId;
    }
    public String getTimeId() {
        return TimeId;
    }
    public void setTimeId(String timeId) {
        TimeId = timeId;
    }
    public String getScheduleId() {
        return ScheduleId;
    }
    public void setScheduleId(String scheduleId) {
        ScheduleId = scheduleId;
    }
    public String getInvoiceDate() {
        return InvoiceDate;
    }
    public void setInvoiceDate(String invoiceDate) {
        InvoiceDate = invoiceDate;
    }
    public InvoiceCreate(String userId, String studentId, String teacherId, String courseId, String studyType,
            Double fee, Integer qty, String roomId, String timeId, String scheduleId, String invoiceDate) {
        UserId = userId;
        StudentId = studentId;
        TeacherId = teacherId;
        CourseId = courseId;
        StudyTypeId = studyType;
        Fee = fee;
        Qty = qty;
        RoomId = roomId;
        TimeId = timeId;
        ScheduleId = scheduleId;
        InvoiceDate = invoiceDate;
    }
    @Override
    public String toString() {
        return "InvoiceCreate [CourseId=" + CourseId + ", Fee=" + Fee + ", InvoiceDate=" + InvoiceDate + ", Qty=" + Qty
                + ", RoomId=" + RoomId + ", ScheduleId=" + ScheduleId + ", StudentId=" + StudentId + ", StudyType="
                + StudyTypeId + ", TeacherId=" + TeacherId + ", TimeId=" + TimeId + ", UserId=" + UserId + "]";
    }   
}
