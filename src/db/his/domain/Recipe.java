package db.his.domain;

import java.util.Date;

/**
 * Created by lwt on 2016/1/1.
 * 处方
 */
public class Recipe {
    //id
    private String recipe_id;
    //医生id
    private String doctor_id;
    //诊断时间
    private Date diag_date;
    //病人id
    private String patient_id;
    //病症
    private String comment;

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Date getDiag_date() {
        return diag_date;
    }

    public void setDiag_date(Date diag_date) {
        this.diag_date = diag_date;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
