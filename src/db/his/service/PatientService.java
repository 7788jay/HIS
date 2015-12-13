package db.his.service;

import db.his.dao.PatientDao;
import db.his.domain.Patient;
import db.his.domain.enums.MessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwt on 2015/12/10.
 * 病人服务层
 */
@Service
public class PatientService {

    @Autowired
    private PatientDao patientDao;

    /**
     * 增加一个病人信息
     *
     * @param patient
     */
    public Map<String, Object> add(Patient patient) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            patientDao.addPatient(patient);
            map.put("message", MessageEnum.ADD_SUCCESS.getName());
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("message", MessageEnum.ADD_ERROR.getName());
        }
        return map;
    }
}
