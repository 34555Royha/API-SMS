package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Attendance.AttendList;
import com.sms.demo.Model.Attendance.Attendance;
import com.sms.demo.Model.Attendance.AttendanceCreate;
import com.sms.demo.Model.Attendance.AttendanceGetById;
import com.sms.demo.Model.Attendance.dropdown.Student;
import com.sms.demo.Model.Attendance.dropdown.Teacher;
import com.sms.demo.Model.Attendance.dropdown.course;
import com.sms.demo.Repositories.AttendanceRepository;
import com.sms.demo.Service.AttendanceService;

import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    private AttendanceRepository attendanceRepository;

    

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }



    @Override
    public java.util.List<AttendList> List() {
        return this.attendanceRepository.List();
    }



    @Override
    public AttendanceGetById getById(String id) {
        return this.attendanceRepository.getById(id);
    }



    @Override
    public Boolean Delete(String id) {
        return this.attendanceRepository.Delete(id);
    }



    @Override
    public Boolean Create(AttendanceCreate attendanceCreate) {
        return this.attendanceRepository.Create(attendanceCreate);
    }



    @Override
    public Boolean Update(Attendance attendance) {
        return this.attendanceRepository.Update(attendance);
    }



    @Override
    public java.util.List<course> courses() {
        return this.attendanceRepository.courses();
    }



    @Override
    public java.util.List<Teacher> teachers() {
        return this.attendanceRepository.teachers();
    }



    @Override
    public java.util.List<Student> students() {
        return this.attendanceRepository.students();
    }



    @Override
    public java.util.List<Attendance> Filter(String Student_Id) {
        return this.attendanceRepository.Filter(Student_Id);
    }
}
