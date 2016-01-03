package db.his.domain;

import java.util.Date;

/**
 * Created by lwt on 2016/1/2.
 * 医嘱
 */
public class Order {
    //id
    private String doc_order_id;
    //医生id
    private String doctor_id;
    //开始时间
    private Date start_time;
    //结束时间
    private Date end_time;
    //医嘱内容
    private String comment;
    //病人id
    private String patient_id;
    //预约id
    private int appointment_id;
    //医嘱类型
    private String type;

    public String getDoc_order_id() {
        return doc_order_id;
    }

    public void setDoc_order_id(String doc_order_id) {
        this.doc_order_id = doc_order_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
