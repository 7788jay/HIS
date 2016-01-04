package db.his.web.controller.foreground;

import db.his.domain.Doctor;
import db.his.domain.Patient;
import db.his.domain.PatientFile;
import db.his.service.PatientFileService;
import db.his.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lwt on 2015/12/26.
 * 病历书写
 */
@Controller
@RequestMapping("/fore/file")
public class PatientFileController {
    @Autowired
    private PatientFileService patientFileService;
    @Autowired
    private PatientService patientService;

    /**
     * 添加病人的病历
     * @param complained 主诉
     * @param patientFiles 病历信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public ModelMap add(String complained,@RequestBody PatientFile[] patientFiles) throws UnsupportedEncodingException {
        try {
            Patient patient = new Patient();
            patient.setId(patientFiles[0].getPatient_id());
            patient.setComplained(URLDecoder.decode(URLDecoder.decode(complained,"utf-8"),"utf-8"));
            //更新病人信息
            patientService.update(patient);
            //批量插入病人病历信息
            patientFileService.batchInsert(Arrays.asList(patientFiles));
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelMap("message", "保存失败！");
        }
        return new ModelMap("message", "保存成功！");
    }

    /**
     * 根据病人id获取病人病历
     * @param patient_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public List<PatientFile> queryOne(String patient_id, HttpSession session){
        //从session中获取医生信息
        Doctor doctor = (Doctor) session.getAttribute("user");
        return patientFileService.queryOne(patient_id,doctor);
    }
}
