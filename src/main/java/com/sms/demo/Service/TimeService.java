package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Invoice.Invoice;
import com.sms.demo.Model.Time.Time;
import com.sms.demo.Model.Time.TimeCreate;

import org.springframework.stereotype.Service;

@Service
public interface TimeService {
    List<Time> List();
    List<Invoice> Filter(String TimeId);
    Time getById(String id);
    Boolean Delete(String id);
    Boolean Create(TimeCreate timeCreate);
    Boolean Update(Time time);
    List<Time> Search(String time);
}
