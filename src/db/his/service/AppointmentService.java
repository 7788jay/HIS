package db.his.service;

import db.his.dao.AppointmentDao;
import db.his.domain.Appointment;
import db.his.domain.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwt on 2015/12/20.
 * 挂号服务层
 */
@Service
public class AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;

    /**
     * 医生获取患者挂号列表
     * @param ap
     * @return
     */
    public List<PatientDTO> getAll(Appointment ap ) {
        List<PatientDTO> patientDTOs =null;
        try {
            patientDTOs = appointmentDao.getAll(ap);
        } catch (SQLException e) {
            e.printStackTrace();
            patientDTOs = new ArrayList<>();
        }
        return patientDTOs;
    }

    /**
     *
     * @param property
     * @param value
     * @param appointment_id
     * @throws SQLException
     */
    public void update(String property,String value,String appointment_id) {
        try {
            appointmentDao.update(property,value,appointment_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
