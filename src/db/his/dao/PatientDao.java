package db.his.dao;

import db.his.domain.Patient;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by lwt on 2015/12/8.
 */
@Repository
public class PatientDao {
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

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


//    /**
//     * 根据用户名获取医生
//     * @param username
//     * @return
//     */
//    public Patient getPatientByName(String username) {
//        return null;
//    }
}
