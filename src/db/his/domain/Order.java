package db.his.domain;

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
    private String star_time;
    //结束时间
    private String end_time;
    //医嘱内容
    private String comment;
    //病人id
    private String patient_id;

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

    public String getStar_time() {
        return star_time;
    }

    public void setStar_time(String star_time) {
        this.star_time = star_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
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
}
