package com.sms.demo.Model.Schedule;

public class ScheduleCreate {
    private String Schedule;
    private String Description;
    public String getSchedule() {
        return Schedule;
    }
    public void setSchedule(String schedule) {
        Schedule = schedule;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public ScheduleCreate(String schedule, String description) {
        Schedule = schedule;
        Description = description;
    }
    @Override
    public String toString() {
        return "ScheduleCreate [Description=" + Description + ", Schedule=" + Schedule + "]";
    }
    
}
