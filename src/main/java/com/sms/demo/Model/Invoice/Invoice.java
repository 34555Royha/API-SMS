package com.sms.demo.Model.Invoice;

public class Invoice {
    private String Id;
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
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
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
    public void setStudyTypeId(String studyTypeId) {
        StudyTypeId = studyTypeId;
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
    public Invoice(String id, String userId, String studentId, String teacherId, String courseId, String studyTypeId,
            Double fee, Integer qty, String roomId, String timeId, String scheduleId, String invoiceDate) {
        Id = id;
        UserId = userId;
        StudentId = studentId;
        TeacherId = teacherId;
        CourseId = courseId;
        StudyTypeId = studyTypeId;
        Fee = fee;
        Qty = qty;
        RoomId = roomId;
        TimeId = timeId;
        ScheduleId = scheduleId;
        InvoiceDate = invoiceDate;
    }
    @Override
    public String toString() {
        return "Invoice [CourseId=" + CourseId + ", Fee=" + Fee + ", Id=" + Id + ", InvoiceDate=" + InvoiceDate
                + ", Qty=" + Qty + ", RoomId=" + RoomId + ", ScheduleId=" + ScheduleId + ", StudentId=" + StudentId
                + ", StudyTypeId=" + StudyTypeId + ", TeacherId=" + TeacherId + ", TimeId=" + TimeId + ", UserId="
                + UserId + "]";
    }    
}
