package db.his.service;

import db.his.dao.DoctorScheduleDao;
import db.his.domain.DoctorSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2015/12/13.
 */
@Service
public class DoctorScheduleService {
    @Autowired
    private DoctorScheduleDao doctorScheduleDao;

    public void batchInsert(List<DoctorSchedule> doctorSchedules, String doctor_id) throws SQLException {
        doctorScheduleDao.batchInsert(doctorSchedules, doctor_id);

    }
}
