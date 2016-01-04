package db.his.web.controller.foreground;

import db.his.domain.Appointment;
import db.his.domain.Doctor;
import db.his.domain.dto.PatientDTO;
import db.his.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by lwt on 2015/12/20.
 *
 */
@Controller
@RequestMapping("/fore/schedule")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    /**
     * 医生获取病人挂号列表
     * @param appointment
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAll")
    public List<PatientDTO> getAll(Appointment appointment, HttpSession session){
        Doctor doctor = (Doctor) session.getAttribute("user");
        Date date = new Date();
        appointment.setDoctor_id(doctor.getDoctor_id());
        appointment.setAppoint_time(date);
        appointment.setTime(date.getHours()> 12? "1":"0");

        return appointmentService.getAll(appointment);
    }

    /**
     * 结束诊断
     * @param appointment_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus")
    public ModelMap updateStatus(String appointment_id){
        appointmentService.update("status","1",appointment_id);
        return new ModelMap("message", "完成诊断！请选择下一位患者！");
    }
    /**
     * 取消预约
     * @param appointment_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancelAppointment")
    public ModelMap cancelAppointment(String appointment_id){
        appointmentService.update("status","-1",appointment_id);
        return new ModelMap("message", "取消预约成功！");
    }

    /**
     * 延后诊断
     * @param appointment_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePriority")
    public ModelMap updatePriority(String appointment_id){
        appointmentService.update("priority","5",appointment_id);
        return new ModelMap("message", "延后诊断！请选择下一位患者！");
    }
}
