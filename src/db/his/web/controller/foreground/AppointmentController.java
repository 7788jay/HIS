package db.his.web.controller.foreground;

import db.his.domain.Appointment;
import db.his.domain.Doctor;
import db.his.domain.dto.PatientDTO;
import db.his.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
