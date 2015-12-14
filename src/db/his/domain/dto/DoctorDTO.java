package db.his.domain.dto;

import db.his.domain.DoctorSchedule;

import java.util.List;

/**
 * Created by lwt on 2015/12/14.
 * 医生传输类
 */
public class DoctorDTO {
    private String doctor_id;
    private String dept_name;
    private String profession_name;
    private String name;
    private List<DoctorSchedule> doctorSchedules;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getProfession_name() {
        return profession_name;
    }

    public void setProfession_name(String profession_name) {
        this.profession_name = profession_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DoctorSchedule> getDoctorSchedules() {
        return doctorSchedules;
    }

    public void setDoctorSchedules(List<DoctorSchedule> doctorSchedules) {
        this.doctorSchedules = doctorSchedules;
    }
}
