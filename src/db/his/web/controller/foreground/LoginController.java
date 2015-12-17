package db.his.web.controller.foreground;

import db.his.domain.Doctor;
import db.his.domain.User;
import db.his.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwt on 2015/12/6.
 * 前台登录服务
 */
@Controller
@RequestMapping("/fore/login")
public class LoginController {
    DoctorService doctorService = new DoctorService();

    /**
     * 登录验证
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //医生登录验证
            if (user.getStatus().equals("fd")) {
                Doctor d = new Doctor();
                d.setName(user.getName());
                d.setPassword(user.getPassword());
                Doctor doctor = doctorService.getDoctorByDoc(d);
                if(doctor!=null){
                    map.put("message","");
                }else{
                    map.put("message","error");
                }
                //病人登录验证
            }else{

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
