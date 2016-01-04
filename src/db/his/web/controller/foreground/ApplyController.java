package db.his.web.controller.foreground;

import db.his.domain.Apply;
import db.his.domain.Doctor;
import db.his.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by lwt on 2016/1/5.
 */
@Controller
@RequestMapping("/fore/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    /**
     * 获取检查申请
     * @param apply
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAll")
    public List<Apply> getAll(Apply apply, HttpSession session){
        Doctor doctor = (Doctor) session.getAttribute("user");
        apply.setDoctor_id(doctor.getDoctor_id());
        return applyService.queryAll(apply);
    }

    /**
     * 增加申请记录
     * @param apply
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public ModelMap add(Apply apply, HttpSession session){
        try {
            Doctor doctor = (Doctor) session.getAttribute("user");
            apply.setDoctor_id(doctor.getDoctor_id());
            apply.setApply_time(new Date());
            applyService.insert(apply);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelMap("message", "申请失败，请重试！");
        }
        return new ModelMap("message", "申请成功，请等待审批！");
    }
}
