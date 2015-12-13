package db.his.web.controller;

import db.his.domain.Patient;
import db.his.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping(value = "/one_add")
    public Map<String, Object> one_add(Patient patient){
        patient.setId(db.his.util.WebUtils.makeId());
        return patientService.add(patient);
    }
}
