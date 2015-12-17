package db.his.dao;

import db.his.domain.Appointment;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by lwt on 2015/12/17.
 * 预约记录表
 */
@Repository
public class AppointmentDao {
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

    /**
     * 插入预约记录
     * @param ap
     */
    public void insert(Appointment ap) throws SQLException {
        String sql = "insert into appointment(doctor_id,patient_id,time,week,appoint_time) value(?,?,?,?,?)";
        Object[] params = new Object[]{ap.getDoctor_id(),ap.getPatient_id(),ap.getTime(),ap.getWeek(),ap.getAppoint_time()};
        qr.update(sql,params);
    }
}
