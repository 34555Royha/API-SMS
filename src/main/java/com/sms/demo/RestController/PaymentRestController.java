package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.Payment.Payment;
import com.sms.demo.Model.Payment.PaymentCreate;
import com.sms.demo.Service.PaymentService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController 
@RequestMapping("/api/v1/payment")
public class PaymentRestController {

    private PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @GetMapping("/")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        List<Payment> payments = this.paymentService.List();

        if(payments.size()>=0){
            response.put("payments", payments);
            response.put("Count", payments.size());
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
        Payment payment = this.paymentService.getById(id);

        if(payment != null ){
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("payment", payment);
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
        Payment payment= this.paymentService.getById(id);
        
        if(id != null){
            if(this.paymentService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                response.put("payment", payment);
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
    public ResponseEntity<?> Create(@RequestBody PaymentCreate paymentCreate){
        Map<String, Object> response = new HashMap<>(); 

        if(paymentCreate != null ){
            if(this.paymentService.Create(paymentCreate)){
            response.put("status", HttpStatus.OK);
            response.put("payment", paymentCreate);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("payment", paymentCreate);
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
    public ResponseEntity<?> Update(@RequestBody Payment payment){

        Map<String, Object> response = new HashMap<>(); 
        
        if(payment.getId() != null){
            if(this.paymentService.Update(payment)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("payment after updated", payment); 
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

    @GetMapping("/search")
    @ApiOperation(value = "Search",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Search(@RequestParam(required = false,defaultValue = "") String InvoiceID){

        Map<String, Object> response = new HashMap<>(); 

        
        if(InvoiceID.equals("")){
            List<Payment> payments = this.paymentService.List();
                response.put("payments", payments);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", payments.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            List<Payment> payments = this.paymentService.Search(InvoiceID);
            if(payments.size()>0){
                    response.put("payments", payments);
                    response.put("status", HttpStatus.OK);
                    response.put("message", "Get success");
                    response.put("Count", payments.size());
                    return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }

    @GetMapping("/dropdown")
    @ApiOperation(value = "dropdown",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> dropdown(){
        Map<String, Object> response = new HashMap<>();
        List<String> invoices= this.paymentService.invoice();

        if(invoices.size()>=0){

            response.put("invoices", invoices); 
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