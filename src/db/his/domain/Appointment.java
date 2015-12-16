package db.his.domain;

import java.util.Date;

/**
 * Created by lwt on 2015/12/16.
 */
public class Appointment {
    private String id;
    //医生id、
    private String doctor_id;
    //病人id
    private String patient_id;
    //上午或者下午
    private String time;
    //星期几
    private String week;
    //预约时间
    private Date appoint_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Date getAppoint_time() {
        return appoint_time;
    }

    public void setAppoint_time(Date appoint_time) {
        this.appoint_time = appoint_time;
    }
}
