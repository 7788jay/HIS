package db.his.domain.dto;

import db.his.domain.Doctor;

import java.util.Date;

/**
 * Created by lwt on 2016/1/4.
 * 病人查看预约信息
 */
public class AppointmentDTO extends Doctor {

    private int appoint_id;
    private Date appoint_time;
    private int time;
    private int week;
    private int priority;
    private int status;

    public int getAppoint_id() {
        return appoint_id;
    }

    public void setAppoint_id(int appoint_id) {
        this.appoint_id = appoint_id;
    }

    public Date getAppoint_time() {
        return appoint_time;
    }

    public void setAppoint_time(Date appoint_time) {
        this.appoint_time = appoint_time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
