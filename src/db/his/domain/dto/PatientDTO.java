package db.his.domain.dto;

import db.his.domain.Patient;

import java.util.Date;

/**
 * Created by lwt on 2015/12/20.
 * 查询挂号列表dto
 */
public class PatientDTO extends Patient {
    //挂号表id
    private String appointment_id;
    //预约的时间
    private Date create_time;
    //排序号
    private int priority;
    //叫号状态
    private int status;

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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
