package db.his.service;

import db.his.dao.PatientFileDao;
import db.his.domain.Doctor;
import db.his.domain.PatientFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by lwt on 2015/12/26.
 */
@Service
public class PatientFileService {
    @Autowired
    private PatientFileDao patientFileDao;
    /**
     * 根据病人id获取病历
     * @param patient_id
     * @return
     */
    public List<PatientFile> queryOne(String patient_id,Doctor doctor){
        List<PatientFile> patientFiles = null;
        try {
            patientFiles = patientFileDao.queryOne(patient_id);
            if(patientFiles.size()==0){
                String [] names = new String []{"present","past","person","exam","diagnosis"};
                for(String name : names){
                    PatientFile p = new PatientFile();
                    p.setTimes(1);
                    p.setName(name);
                    p.setModifier(doctor.getName());
                    p.setDate(new Date());
                    p.setComment("");
                    p.setPatient_id(patient_id);
                    patientFiles.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientFiles;
    }

    /**
     *批量插入病历内容
     * @param pfs
     * @throws SQLException
     */
    public void batchInsert(List<PatientFile> pfs) throws SQLException {
        patientFileDao.batchInsert(pfs);
    }
}
