package db.his.dao;

import db.his.domain.Order;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
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
     * @param doctor_id 医生id
     * @param patient_id  病人id
     * @param orders  医嘱集合
     * @throws SQLException
     */
    public void batchInsert(String doctor_id, String patient_id, List<Order> orders) throws SQLException {
        String sql = "insert into doc_order (doctor_id,patient_id,star_time,end_time,comment)values(?,?,?,?,?)";
        Object[][] params = null;
        int i = 0;
        for( Order order : orders){
            params[i] = new Object[]{new Object[]{doctor_id,patient_id,order.getStar_time(),order.getEnd_time(),order.getComment()}};
            i++;
        }
        qr.batch(sql,params);
    }
}
