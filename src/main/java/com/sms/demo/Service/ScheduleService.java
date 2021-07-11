package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Schedule.Schedule;
import com.sms.demo.Model.Schedule.ScheduleCreate;

import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {
    List<Schedule> List();
    Schedule getById(String id);
    Boolean Delete(String id);
    Boolean Create(ScheduleCreate scheduleCreate);
    Boolean Update(Schedule schedule);
    List<Schedule> Search(String Schedule);
}
