package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Payment.Payment;
import com.sms.demo.Model.Payment.PaymentCreate;

import org.springframework.stereotype.Service;


@Service
public interface PaymentService {
    List<Payment> List();
    Payment getById(String id);
    Boolean Delete(String id);
    Boolean Create(PaymentCreate paymentCreate);
    Boolean Update(Payment payment);
    List<Payment> Search(String InvoiceID);
    List<String> invoice();
}
