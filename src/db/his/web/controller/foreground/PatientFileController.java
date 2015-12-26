package db.his.web.controller.foreground;

import db.his.domain.Doctor;
import db.his.domain.PatientFile;
import db.his.service.PatientFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    /**
     * 添加病人的病历
     * @param patientFiles
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public ModelMap add(@RequestBody PatientFile[] patientFiles) {
        try {
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
        Doctor doctor = (Doctor) session.getAttribute("user");
        return patientFileService.queryOne(patient_id,doctor);
    }
}
