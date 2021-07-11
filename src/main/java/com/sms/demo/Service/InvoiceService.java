package com.sms.demo.Service;

import java.util.List;


import com.sms.demo.Model.Invoice.Invoice;
import com.sms.demo.Model.Invoice.InvoiceCreate;
import com.sms.demo.Model.Invoice.InvoiceList;
import com.sms.demo.Model.Invoice.Dropdown.Course;
import com.sms.demo.Model.Invoice.Dropdown.Room;
import com.sms.demo.Model.Invoice.Dropdown.Schedule;
import com.sms.demo.Model.Invoice.Dropdown.Student;
import com.sms.demo.Model.Invoice.Dropdown.Study;
import com.sms.demo.Model.Invoice.Dropdown.Teacher;
import com.sms.demo.Model.Invoice.Dropdown.Time;
import com.sms.demo.Model.Invoice.Dropdown.User;

import org.springframework.stereotype.Service;
@Service
public interface InvoiceService {
    List<InvoiceList> List();
    Invoice getById(String id);
    Boolean Delete(String id);
    Boolean Create(InvoiceCreate invoiceCreate);
    Boolean Update(Invoice invoice);
    List<Course> courses();
    List<Room> rooms();
    List<Schedule> schedules();
    List<Student> students();
    List<Study> studies();
    List<Teacher> teachers();
    List<Time> times();
    List<User> users();
}
