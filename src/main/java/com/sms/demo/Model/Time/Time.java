package com.sms.demo.Model.Time;

public class Time {
    private String Id;
    private String Time;
    private String Description;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Time(String id, String time, String description) {
        Id = id;
        Time = time;
        Description = description;
    }

    @Override
    public String toString() {
        return "Time [Description=" + Description + ", Id=" + Id + ", Time=" + Time + "]";
    }

    public Time() {
    }

}
