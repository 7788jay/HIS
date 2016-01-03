package db.his.dao;

import db.his.domain.Appointment;
import db.his.domain.Order;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2016/1/2.
 * 医嘱
 */
@Repository
public class OrderDao {

    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

    /**
     * 批量插入医嘱
     * @param ap
     * @param orders  医嘱集合
     * @throws SQLException
     */
    public void batchInsert(Appointment ap, List<Order> orders) throws SQLException {
        this.delete(ap);
        String sql = "insert into doc_order (doctor_id,patient_id,appointment_id,start_time,end_time,comment,type)values(?,?,?,?,?,?,?)";
        Object[][] params = new Object[orders.size()][];
        int i = 0;
        for( Order order : orders){
            params[i] = new Object[]{ap.getDoctor_id(),ap.getPatient_id(),ap.getId(),order.getStart_time(),order.getEnd_time(),order.getComment(),order.getType()};
            i++;
        }
        qr.batch(sql,params);
    }

    /**
     * 根据医生与病人id获取医嘱
     * @param ap
     * @return
     * @throws SQLException
     */
    public List<Order> queryAll(Appointment ap) throws SQLException {
        String sql = "select * from doc_order where doctor_id=? and patient_id=? and appointment_id=?";
        Object[] params = new Object[]{ap.getDoctor_id(),ap.getPatient_id(),ap.getId()};
        return (List<Order>) qr.query(sql,params,new BeanListHandler(Order.class));
    }

    /**
     * 删除之前记录
     * @param ap
     * @throws SQLException
     */
    public void delete(Appointment ap) throws SQLException {
        String sql = "delete from doc_order where doctor_id=? and patient_id=? and appointment_id=?";
        Object[] params = new Object[]{ap.getDoctor_id(),ap.getPatient_id(),ap.getId()};
        qr.update(sql,params);
    }
}
