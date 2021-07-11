package com.sms.demo.Model.Invoice.Dropdown;

public class Time {
    private String Id;
    private String Time;
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
    public Time(String id, String time) {
        Id = id;
        Time = time;
    }
    @Override
    public String toString() {
        return "Time [Id=" + Id + ", Time=" + Time + "]";
    }

    
}
