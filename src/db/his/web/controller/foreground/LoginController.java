package db.his.web.controller.foreground;

import db.his.domain.Doctor;
import db.his.domain.Patient;
import db.his.domain.User;
import db.his.service.DoctorService;
import db.his.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwt on 2015/12/6.
 * 前台登录服务
 */
@Controller
@RequestMapping("/fore")
public class LoginController {
    @Autowired
    private PatientService patientService;
    DoctorService doctorService = new DoctorService();

    /**
     * 登录验证
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public Map<String, Object> login(User user, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //医生登录验证
            if (user.getStatus().equals("fd")) {
                Doctor d = new Doctor(user.getName(), user.getPassword());
                Doctor doctor = doctorService.getDoctorByDoc(d);
                if (doctor != null) {
                    session.setAttribute("user", doctor);
                    map.put("message", "foreground/doctor/list_schedule.html");
                } else {
                    map.put("message", "error");
                }
                //病人登录验证
            } else {
                Patient p = new Patient(user.getName(), user.getPassword());
                Patient patient = patientService.queryPatientByP(p);
                if (patient != null) {
                    session.setAttribute("patient",patient);
                    map.put("message", "foreground/list_schedule.jsp");
                }else {
                    map.put("message", "error");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "error");
        }
        return map;
    }

    /**
     * 获取当前用户
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCurrentUser")
    public Doctor getCurrentUser(HttpSession session){
        return (Doctor) session.getAttribute("user");
    }
}
