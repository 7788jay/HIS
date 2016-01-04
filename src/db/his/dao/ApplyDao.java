package db.his.dao;

import db.his.domain.Apply;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2016/1/5.
 * 申请检查
 */
@Repository
public class ApplyDao {
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

    /**
     * 增加申请记录
     * @param apply
     * @throws SQLException
     */
    public void insert(Apply apply) throws SQLException {
        String sql = "insert into exam_apply (doctor_id,patient_id,exam_type,dept_name,status,apply_time) values(?,?,?,?,?,?)";
        Object[] params = new Object[]{apply.getDoctor_id(),apply.getPatient_id(),apply.getExam_type(),apply.getDept_name(),apply.getStatus(),apply.getApply_time()};
        qr.update(sql,params);
    }

    /**
     * 查询检查申请
     * @param apply
     * @return
     * @throws SQLException
     */
    public List<Apply> queryAll(Apply apply) throws SQLException {
        String sql = "select * from exam_apply where doctor_id=? and patient_id=?";
        Object[] params = new Object[]{apply.getDoctor_id(),apply.getPatient_id()};
        return (List<Apply>) qr.query(sql,params,new BeanListHandler(Apply.class));
    }
}