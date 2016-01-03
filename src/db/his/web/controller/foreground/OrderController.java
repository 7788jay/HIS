package db.his.web.controller.foreground;

import db.his.domain.Appointment;
import db.his.domain.Doctor;
import db.his.domain.Order;
import db.his.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lwt on 2016/1/2.
 * 医嘱
 */
@Controller
@RequestMapping("/fore/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 保存医嘱
     * @param appointment
     * @param orders
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public ModelMap add(Appointment appointment, @RequestBody Order[] orders, HttpSession session){
        Doctor doctor = (Doctor) session.getAttribute("user");
        try {
            appointment.setDoctor_id(doctor.getDoctor_id());
            orderService.batchInsert(appointment, Arrays.asList(orders));
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelMap("message", "保存失败！");
        }
        return new ModelMap("message", "保存成功！");
    }

    /**
     * 根据医生与病人id获取医嘱
     * @param appointment  //里面包含病人及医生id
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAll")
    public List<Order> queryAll(Appointment appointment, HttpSession session){
        Doctor doctor = (Doctor) session.getAttribute("user");
        List<Order> orders = null;
        //组装成一个对象到数据库查询
        appointment.setDoctor_id(doctor.getDoctor_id());
        try {
            orders = orderService.queryAll(appointment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
