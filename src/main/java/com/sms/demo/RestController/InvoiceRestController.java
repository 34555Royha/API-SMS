package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sms.demo.Service.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceRestController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        List<InvoiceList> invoices = this.invoiceService.List();

        if(invoices.size()>=0){
            response.put("invoices", invoices);
            response.put("Count", invoices.size());
            response.put("Status", HttpStatus.OK);
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "GetById",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> GetById(@PathVariable(required = true) String id){
        Map<String, Object> response = new HashMap<>();
        Invoice invoice = this.invoiceService.getById(id);

        if(invoice != null ){
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("invoice", invoice);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Id: "+ id.toString()+" Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }    
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Delete(@PathVariable(required = true) String id){

        Map<String, Object> response = new HashMap<>(); 
        Invoice invoice = this.invoiceService.getById(id);
        
        if(id != null){
            if(this.invoiceService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                response.put("invoice", invoice);
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("message", "Delete failed, Because Not Found or your record Connect ot other record");
            }
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please Input ID");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Create",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Create(@RequestBody InvoiceCreate invoiceCreate){
        Map<String, Object> response = new HashMap<>(); 

        if(invoiceCreate != null ){
            if(this.invoiceService.Create(invoiceCreate)){
            response.put("status", HttpStatus.OK);
            response.put("invoice", invoiceCreate);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("invoice", invoiceCreate);
                response.put("message", "Insert failed");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please input value");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    } 

    @PutMapping("")
    @ApiOperation(value = "Update",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Update(@RequestBody Invoice invoice){

        Map<String, Object> response = new HashMap<>(); 
        
        if(invoice.getId() != null){
            if(this.invoiceService.Update(invoice)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("invoice after updated", invoice); 
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Updated failed");
            }
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please Input Id");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // @GetMapping("/search")
    // @ApiOperation(value = "Search",authorizations = {@Authorization(value = "BasicAuth")})
    // public ResponseEntity<?> Search(@RequestParam(required = false,defaultValue = "") String InvoiceId){

    //     Map<String, Object> response = new HashMap<>(); 

        
    //     if(InvoiceId.equals("")){
    //         List<InvoiceList> invoices = this.invoiceService.List();
    //             response.put("invoices", invoices);
    //             response.put("status", HttpStatus.OK);
    //             response.put("message", "Get success");
    //             response.put("Count", invoices.size());
    //             return ResponseEntity.status(HttpStatus.OK).body(response);
    //     }else{
    //         Invoice invoices = this.invoiceService.getById(InvoiceId);
    //         if(invoices != null){
    //                 response.put("invoices", invoices);
    //                 response.put("status", HttpStatus.OK);
    //                 response.put("message", "Get success");
    //                 return ResponseEntity.status(HttpStatus.OK).body(response);
    //         }else{
    //             response.put("status", HttpStatus.NOT_FOUND);
    //             response.put("message", "Not Found");
    //             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    //         }
    //     }
    // }

    @GetMapping("/dropdown")
    @ApiOperation(value = "dropdown",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> dropdown(){
        Map<String, Object> response = new HashMap<>();

        List<Course> courses= this.invoiceService.courses();
        List<Room> rooms= this.invoiceService.rooms();
        List<Schedule> schedules = this.invoiceService.schedules();
        List<Student> students= this.invoiceService.students();
        List<Study> studies= this.invoiceService.studies();
        List<Teacher> teachers= this.invoiceService.teachers();
        List<Time> times= this.invoiceService.times();
        List<User> users= this.invoiceService.users();

        if(teachers.size()>=0&&students.size()>=0&&courses.size()>=0){

            response.put("courses", courses);
            response.put("rooms", rooms); 
            response.put("schedules", schedules);
            response.put("students", students);
            response.put("studies", studies); 
            response.put("teachers", teachers);
            response.put("times", times);
            response.put("users", users); 
            
            
            response.put("Status", HttpStatus.OK);
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}