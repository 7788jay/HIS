package db.his.dao;

import db.his.domain.Patient;
import db.his.domain.dto.AppointmentDTO;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2015/12/8.
 */
@Repository
public class PatientDao {
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

    /**
     * 查看病人预约列表
     * @param patient_id
     * @return
     */
    public List<AppointmentDTO> queryAppointment(String patient_id) throws SQLException {
        String sql = "SELECT od.*,ap.id appoint_id, ap.appoint_time,ap.time,ap. WEEK,ap.priority,ap. STATUS\n" +
                "FROM appointment ap\n" +
                "LEFT JOIN outpatient_docter od ON ap.doctor_id = od.doctor_id\n" +
                "WHERE ap.patient_id = ?;";
        return (List<AppointmentDTO>) qr.query(sql,patient_id,new BeanListHandler(AppointmentDTO.class));
    }

    /**
     * 根据用户名密码获取病人
     * @param p 病人账号/密码
     * @return 病人
     * @throws SQLException
     */
    public Patient queryPatientByP(Patient p) throws SQLException {
        String sql="select * from patient where name=? and password=?";
        Patient patient=(Patient) qr.query(sql,new Object[]{p.getName(),p.getPassword()},new BeanHandler(Patient.class));
        return patient;
    }

    /**
     * 增加一个病人信息
     * @param p
     * @throws SQLException
     */
    public void addPatient(Patient p) throws SQLException {
        String sql="insert into patient (id,name,password,record_id,file_id,sex,age,card_id,case_id) values (?,?,?,?,?,?,?,?,?)";
        Object params[]={p.getId(),p.getName(),p.getPassword(),p.getRecord_id(),p.getFile_id(),p.getSex(),p.getAge(),p.getCard_id(),p.getCase_id()};
        qr.update(sql,params);
    }

    /**
     * 根据id获取病人信息
     * @param id
     * @return
     * @throws SQLException
     */
    public Patient queryPatientById(String id) throws SQLException {
        String sql="select * from patient where id=?";
        Patient patient=(Patient) qr.query(sql,id,new BeanHandler(Patient.class));
        return patient;
    }

    /**
     * 修改病人主诉
     * @param patient
     * @throws SQLException
     */
    public void update(Patient patient) throws SQLException {
        String sql = "update patient set complained = ? where id = ?";
        Object[] params = new Object[]{patient.getComplained(),patient.getId()};
        qr.update(sql,params);
    }


//    /**
//     * 根据用户名获取医生
//     * @param username
//     * @return
//     */
//    public Patient getPatientByName(String username) {
//        return null;
//    }
}
