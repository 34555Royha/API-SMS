package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Payment.Payment;
import com.sms.demo.Model.Payment.PaymentCreate;
import com.sms.demo.Repositories.PaymentRepository;
import com.sms.demo.Service.PaymentService;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public java.util.List<Payment> List() {
        return this.paymentRepository.List();
    }

    @Override
    public Payment getById(String id) {
        return this.paymentRepository.getById(id);
    }

    @Override
    public Boolean Delete(String id) {
        return this.paymentRepository.Delete(id);
    }

    @Override
    public Boolean Create(PaymentCreate paymentCreate) {
        return this.paymentRepository.Create(paymentCreate);
    }

    @Override
    public Boolean Update(Payment payment) {
        return this.paymentRepository.Update(payment);
    }

    @Override
    public java.util.List<Payment> Search(String InvoiceID) {
        return this.paymentRepository.Search(InvoiceID);
    }

    @Override
    public java.util.List<String> invoice() {
        return this.paymentRepository.invoice();
    }
}
