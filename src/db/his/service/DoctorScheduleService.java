package db.his.service;

import db.his.dao.AppointmentDao;
import db.his.dao.DoctorScheduleDao;
import db.his.domain.Appointment;
import db.his.domain.DoctorSchedule;
import db.his.domain.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwt on 2015/12/13.
 */
@Service
public class DoctorScheduleService {
    @Autowired
    private DoctorScheduleDao doctorScheduleDao;
    @Autowired
    private AppointmentDao appointmentDao;
    DoctorService doctorService = new DoctorService();//医生服务层

    /**
     * 批量插入排班
     *
     * @param doctorSchedules
     * @param doctor_id
     * @throws SQLException
     */
    public void batchInsert(List<DoctorSchedule> doctorSchedules, String doctor_id) throws SQLException {
        doctorScheduleDao.batchInsert(doctorSchedules, doctor_id);

    }

    /**
     * 获取全部医生信息及预约信息（病人挂号）
     *
     * @return
     */
    public List<DoctorDTO> getAll() {
        List<DoctorDTO> doctorDTOs = null;
        try {
            doctorDTOs = doctorService.getAllForSchedule();
            for (DoctorDTO d : doctorDTOs) {
                d.setDoctorSchedules(doctorScheduleDao.queryByDoc_id(d.getDoctor_id()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorDTOs;
    }

    /**
     * 预约
     *
     * @param doctorSchedule
     * @param appointment
     */
    public void appoint(DoctorSchedule doctorSchedule, Appointment appointment) throws SQLException {
        //先添加挂号记录
        appointmentDao.insert(appointment);

        //修改可挂号数量
        doctorScheduleDao.update(doctorSchedule);
    }

    /**
     * 根据医生id获取排班信息
     * @param doctor_id
     * @return
     * @throws SQLException
     */
    public List<DoctorSchedule> queryByDoc_id(String doctor_id) {
        List<DoctorSchedule> doctorSchedules = new ArrayList<DoctorSchedule>();
        try {
            doctorSchedules = doctorScheduleDao.queryByDoc_id(doctor_id);
            if(doctorSchedules.size()==0){
                for(int i=0;i<7;i++) {
                    DoctorSchedule d = new DoctorSchedule();
                    d.setTime("0");
                    d.setWeek(i+"");
                    d.setSum(0);
                    doctorSchedules.add(d);
                }
                for(int i=0;i<7;i++) {
                    DoctorSchedule d = new DoctorSchedule();
                    d.setTime("1");
                    d.setWeek(i+"");
                    d.setSum(0);
                    doctorSchedules.add(d);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorSchedules;
    }
}
