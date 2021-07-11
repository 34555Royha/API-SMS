package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Schedule.Schedule;
import com.sms.demo.Model.Schedule.ScheduleCreate;
import com.sms.demo.Repositories.ScheduleRepository;
import com.sms.demo.Service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public java.util.List<Schedule> List() {
        return this.scheduleRepository.List();
    }

    @Override
    public Schedule getById(String id) {
        return this.scheduleRepository.getById(id);
    }

    @Override
    public Boolean Delete(String id) {
        return this.scheduleRepository.Delete(id);
    }

    @Override
    public Boolean Create(ScheduleCreate scheduleCreate) {
        return this.scheduleRepository.Create(scheduleCreate);
    }

    @Override
    public Boolean Update(Schedule schedule) {
        return this.scheduleRepository.Update(schedule);
    }

    @Override
    public java.util.List<Schedule> Search(String Schedule) {
        return this.scheduleRepository.Search(Schedule);
    }

    
    
}
