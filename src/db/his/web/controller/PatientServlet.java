package db.his.web.controller;

import db.his.domain.Patient;
import db.his.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by lwt on 2015/12/11.
 * 病人Controller
 */
@Controller
@RequestMapping("/servlet/PatientServlet")
public class PatientServlet {
    @Autowired
    private PatientService patientService;

    /**
     * 新增一个病人
     * @param patient
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/one_add")
    public Map<String, Object> one_add(Patient patient){
        patient.setId(db.his.util.WebUtils.makeId());
        return patientService.add(patient);
    }

    /**
     * 根据病人id获取病人信息
     * @param patient_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public Patient queryOne(String patient_id){
        Patient patient = null;
        try {
            patient = patientService.queryPatientById(patient_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }
}
