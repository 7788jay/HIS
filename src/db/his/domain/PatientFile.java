package db.his.domain;

import java.util.Date;

/**
 * Created by lwt on 2015/12/23.
 * 电子病历
 *
 */
public class PatientFile {
    private String id;
    //病人id
    private String patient_id;
    //对应病历属性名
    private String name;
    //内容
    private String comment;
    //修改人
    private String modifier;
    //时间
    private Date date;
    //就诊次数
    private int times;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
