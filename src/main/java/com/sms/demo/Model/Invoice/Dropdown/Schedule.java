package com.sms.demo.Model.Invoice.Dropdown;

public class Schedule {
    private String Id;
    private String Schedule;
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getSchedule() {
        return Schedule;
    }
    public void setSchedule(String schedule) {
        Schedule = schedule;
    }
    public Schedule(String id, String schedule) {
        Id = id;
        Schedule = schedule;
    }
    @Override
    public String toString() {
        return "Schedule [Id=" + Id + ", Schedule=" + Schedule + "]";
    }

    
}
