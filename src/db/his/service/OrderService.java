package db.his.service;

import db.his.dao.OrderDao;
import db.his.domain.Appointment;
import db.his.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2016/1/2.
 * 医嘱服务层
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 批量插入医嘱
     * @param ap
     * @param orders  医嘱集合
     * @throws SQLException
     */
    public void batchInsert(Appointment ap, List<Order> orders) throws SQLException {
        orderDao.batchInsert(ap,orders);
    }
    /**
     * 根据医生与病人id获取医嘱
     * @param ap
     * @return
     * @throws SQLException
     */
    public List<Order> queryAll(Appointment ap) throws SQLException{
        return orderDao.queryAll(ap);
    }
}
