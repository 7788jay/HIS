package db.his.web.controller.foreground;

import db.his.domain.*;
import db.his.domain.dto.DoctorDTO;
import db.his.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lwt on 2015/12/13.
 * 挂号
 */
@Controller
@RequestMapping("/servlet/doctorSchedule")
public class DoctorScheduleController {
    @Autowired
    private DoctorScheduleService doctorScheduleService;
    DepartmentService dService=new DepartmentService();//科室服务层
    DoctorService doctorService=new DoctorService();//医生服务层
    CommonService cService=new CommonService();//普通服务层
    RoleService roleService=new RoleService();//角色服务层

    /**
     *预约医生
     * @param doctorSchedule
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/appoint")
    public ModelMap appoint(DoctorSchedule doctorSchedule,int offset,HttpServletRequest request){
        //获取延期后的时间
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, offset);// offset为增加的天数，可以改变的
        Date d = ca.getTime();
//        Patient patient = (Patient) request.getSession().getAttribute("user");
        Appointment appointment = new Appointment();
        appointment.setPatient_id("5555555");
        appointment.setDoctor_id(doctorSchedule.getDoctor_id());
        appointment.setTime(doctorSchedule.getTime());
        appointment.setWeek(doctorSchedule.getWeek());

        appointment.setAppoint_time(d);
        doctorScheduleService.appoint(doctorSchedule,appointment);

        return new ModelMap("message","添加成功！");
    }


    /**
     * 获取所有医生的预约信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getAll")
    public List<DoctorDTO> getAll(){
        List<DoctorDTO> doctorDTOs = doctorScheduleService.getAll();
        return doctorDTOs;
    }

    /**
     * 后台根据doctor_id获取医生排班信息
     * @param doctor_id
     * @param request
     * @param response
     */
    @RequestMapping(value = "/init/{doctor_id}")
    public void init(@PathVariable("doctor_id") String doctor_id, HttpServletRequest request, HttpServletResponse response){
        try {
            Doctor doctor=doctorService.findDoctorById(doctor_id);//获取医生信息
            Department dept=dService.findDepartment(doctor.getDept_id());//获取医生所在科室
            Profession pro=cService.findProfession(doctor.getProfession_id());//获取医生职称
            request.setAttribute("doctor", doctor);
            request.setAttribute("dept", dept);
            request.setAttribute("pro", pro);
            request.getRequestDispatcher("/manager/doctor/schedule_doctor.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 添加医生排班记录
     * @param doctorSchedule
     * @param doctor_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/add")
    public ModelMap add(@RequestBody DoctorSchedule[] doctorSchedule, String doctor_id){
        try {
            doctorScheduleService.batchInsert(Arrays.asList(doctorSchedule),doctor_id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelMap("message","添加失败！");
        }
        return new ModelMap("message","添加成功！");
    }
}
