package db.his.dao;

import db.his.domain.DoctorSchedule;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2015/12/13.
 * 挂号
 */
@Repository
public class DoctorScheduleDao {
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

    /**
     * 批量插入
     * @param doctorSchedules
     * @param doctor_id
     * @throws SQLException
     */
    public void batchInsert(List<DoctorSchedule> doctorSchedules, String doctor_id) throws SQLException {
        this.delete(doctor_id);
        Object[][] params = new Object[doctorSchedules.size()][];
        int i = 0;
        for( DoctorSchedule ds : doctorSchedules){
            System.out.println(ds.getTime());
            System.out.println(ds.getWeek());
            System.out.println(ds.getSum());
            params[i] = new Object[]{doctor_id, ds.getTime(), ds.getWeek(), ds.getSum(), ds.getSum()};
            i++;
        }
        String sql = "insert into schedule(doctor_id,time,week,sum,left_sum) value(?,?,?,?,?)";
        qr.batch(sql,params);
    }

    public void delete(String doctor_id) throws SQLException {

        String sql = "delete from schedule where doctor_id = ?";
        qr.update(sql,doctor_id);
    }
}
