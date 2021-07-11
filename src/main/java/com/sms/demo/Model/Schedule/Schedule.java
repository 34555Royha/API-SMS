package com.sms.demo.Model.Schedule;

public class Schedule {
    private String Id;
    private String Schedule;
    private String Description;

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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Schedule(String id, String schedule, String description) {
        Id = id;
        Schedule = schedule;
        Description = description;
    }

    @Override
    public String toString() {
        return "Schedule [Description=" + Description + ", Id=" + Id + ", Schedule=" + Schedule + "]";
    }

    public Schedule() {
    }

}
