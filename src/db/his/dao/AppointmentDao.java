package db.his.dao;

import db.his.domain.Appointment;
import db.his.domain.dto.PatientDTO;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2015/12/17.
 * 预约记录表
 */
@Repository
public class AppointmentDao {
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

    /**
     * 插入挂号记录
     * @param ap
     */
    public void insert(Appointment ap) throws SQLException {
        String sql = "insert into appointment(doctor_id,patient_id,time,week,appoint_time,priority) value(?,?,?,?,?,?)";
        Object[] params = new Object[]{ap.getDoctor_id(),ap.getPatient_id(),ap.getTime(),ap.getWeek(),ap.getAppoint_time(),ap.getPriority()};
        qr.update(sql,params);
    }

    /**
     * 医生获取病人的挂号列表
     * @param ap
     * @return
     * @throws SQLException
     */
    public List<PatientDTO> getAll(Appointment ap ) throws SQLException {
        String sql = "SELECT\n" +
                "	ap.id appointment_id,\n" +
                "	ap.priority,\n" +
                "	ap.create_time,\n" +
                "	ap. STATUS,\n" +
                "	p.id,\n" +
                "	p. NAME,\n" +
                "	p.age,\n" +
                "	p.record_id,\n" +
                "	p.sex\n" +
                "FROM\n" +
                "	appointment ap\n" +
                "LEFT JOIN patient p ON ap.patient_id = p.id\n" +
                "WHERE\n" +
                "	ap.doctor_id = ?\n" +
                "AND ap.appoint_time = ?\n" +
                "AND ap.time = ?\n" +
                "AND ap. STATUS = 0\n" +
                "ORDER BY\n" +
                "	ap.priority,ap.id";
        Object[] params = new Object[]{ap.getDoctor_id(),ap.getAppoint_time(),ap.getTime()};
        List<PatientDTO> patientDTOs = (List<PatientDTO>) qr.query(sql,params,new BeanListHandler(PatientDTO.class));
        return patientDTOs;
    }

    /**
     * 更新挂号状态
     * @param property
     * @param value
     * @param appointment_id
     * @throws SQLException
     */
    public void update(String property,String value,String appointment_id) throws SQLException {
        String sql = "";
        if ("priority".equals(property)) {
            sql = "update appointment set priority = priority+? where id = ?";
        }else {
            sql = "update appointment set " + property + " = ? where id = ?";
        }
        Object[] params = new Object[]{value,appointment_id};
        qr.update(sql,params);
    }


}
