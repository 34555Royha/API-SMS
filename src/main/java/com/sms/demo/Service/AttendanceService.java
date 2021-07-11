package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Attendance.AttendList;
import com.sms.demo.Model.Attendance.Attendance;
import com.sms.demo.Model.Attendance.AttendanceCreate;
import com.sms.demo.Model.Attendance.AttendanceGetById;
import com.sms.demo.Model.Attendance.dropdown.Student;
import com.sms.demo.Model.Attendance.dropdown.Teacher;
import com.sms.demo.Model.Attendance.dropdown.course;

import org.springframework.stereotype.Service;

@Service
public interface AttendanceService {
    List<AttendList> List();
    AttendanceGetById getById(String id);
    Boolean Delete(String id);
    Boolean Create(AttendanceCreate attendanceCreate);
    Boolean Update(Attendance attendance);
    public List<course> courses();
    public List<Teacher> teachers();
    public List<Student> students();
    List<Attendance> Filter(String Student_Id);
    
}
