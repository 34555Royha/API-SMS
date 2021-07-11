package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Invoice.Invoice;
import com.sms.demo.Model.Time.Time;
import com.sms.demo.Model.Time.TimeCreate;
import com.sms.demo.Repositories.TimeRepository;
import com.sms.demo.Service.TimeService;

import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {
    private TimeRepository timeRepository;

    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public java.util.List<Time> List() {
        return this.timeRepository.List();
    }

    @Override
    public java.util.List<Invoice> Filter(String TimeId) {
        return this.timeRepository.Filter(TimeId);
    }

    @Override
    public Time getById(String id) {
        return this.timeRepository.getById(id);
    }

    @Override
    public Boolean Delete(String id) {
        return this.timeRepository.Delete(id);
    }

    @Override
    public Boolean Create(TimeCreate timeCreate) {
        return this.timeRepository.Create(timeCreate);
    }

    @Override
    public Boolean Update(Time time) {
        return this.timeRepository.Update(time);
    }

    @Override
    public java.util.List<Time> Search(String time) {
        return this.timeRepository.Search(time);
    }



    
}
