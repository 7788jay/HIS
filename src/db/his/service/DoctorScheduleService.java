package db.his.service;

import db.his.dao.DoctorScheduleDao;
import db.his.domain.DoctorSchedule;
import db.his.domain.dto.DoctorDTO;
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
    DoctorService doctorService=new DoctorService();//医生服务层

    /**
     * 批量插入排班
     * @param doctorSchedules
     * @param doctor_id
     * @throws SQLException
     */
    public void batchInsert(List<DoctorSchedule> doctorSchedules, String doctor_id) throws SQLException {
        doctorScheduleDao.batchInsert(doctorSchedules, doctor_id);

    }

    /**
     * 获取医生信息及预约信息
     * @return
     */
    public List<DoctorDTO> getAll() {
        List<DoctorDTO> doctorDTOs = null;
        try {
            doctorDTOs = doctorService.getAllForSchedule();
            for (DoctorDTO d : doctorDTOs){
                d.setDoctorSchedules(doctorScheduleDao.queryByDoc_id(d.getDoctor_id()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorDTOs;
    }
}
