package db.his.dao;

import db.his.domain.DoctorSchedule;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
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

    /**
     * 根据医生id删除排班信息
     * @param doctor_id
     * @throws SQLException
     */
    public void delete(String doctor_id) throws SQLException {
        String sql = "delete from schedule where doctor_id = ?";
        qr.update(sql,doctor_id);
    }

    /**
     * 根据医生id获取排班信息
     * @param doctor_id
     * @return
     * @throws SQLException
     */
    public List<DoctorSchedule> queryByDoc_id(String doctor_id) throws SQLException {
        String sql = "select * from schedule where doctor_id = ?";
        List<DoctorSchedule>  doctorSchedules = (List<DoctorSchedule>) qr.query(sql,doctor_id,new BeanListHandler(DoctorSchedule.class));
        return doctorSchedules;
    }

    /**
     * 更新排班信息
     * @param doctorSchedule
     */
    public void update(DoctorSchedule doctorSchedule) throws SQLException {
        String sql = "update schedule set left_sum = ? where id = ?";
        Object[] params = new Object[]{doctorSchedule.getLeft_sum()-1,doctorSchedule.getId()};
        qr.update(sql,params);
    }
}
