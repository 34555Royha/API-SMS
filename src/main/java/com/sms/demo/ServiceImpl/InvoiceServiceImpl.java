package com.sms.demo.ServiceImpl;

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
import com.sms.demo.Repositories.InvoiceRepository;
import com.sms.demo.Service.InvoiceService;

import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    private InvoiceRepository invoiceRepository;

    

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }



    @Override
    public java.util.List<InvoiceList> List() {
        return this.invoiceRepository.List();
    }



    @Override
    public Invoice getById(String id) {
        return this.invoiceRepository.getById(id);
    }



    @Override
    public Boolean Delete(String id) {
        return this.invoiceRepository.Delete(id);
    }



    @Override
    public Boolean Create(InvoiceCreate invoiceCreate) {
        return this.invoiceRepository.Create(invoiceCreate);
    }



    @Override
    public Boolean Update(Invoice invoice) {
        return this.invoiceRepository.Update(invoice);
    }



    @Override
    public java.util.List<Course> courses() {
        return this.invoiceRepository.courses();
    }



    @Override
    public java.util.List<Room> rooms() {
        return this.invoiceRepository.rooms();
    }



    @Override
    public java.util.List<Schedule> schedules() {
        return this.invoiceRepository.schedules();
    }



    @Override
    public java.util.List<Student> students() {
        return this.invoiceRepository.students();
    }



    @Override
    public java.util.List<Study> studies() {
        return this.invoiceRepository.studies();
    }



    @Override
    public java.util.List<Teacher> teachers() {
        return this.invoiceRepository.teachers();
    }



    @Override
    public java.util.List<Time> times() {
        return this.invoiceRepository.times();
    }



    @Override
    public java.util.List<User> users() {
        return this.invoiceRepository.users();
    }
    
}
