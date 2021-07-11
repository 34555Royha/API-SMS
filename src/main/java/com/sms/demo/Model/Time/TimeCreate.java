package com.sms.demo.Model.Time;

public class TimeCreate {
    private String Time;
    private String Description;
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
    public TimeCreate(String time, String description) {
        Time = time;
        Description = description;
    }
    @Override
    public String toString() {
        return "TimeCreate [Description=" + Description + ", Time=" + Time + "]";
    }

    
}
