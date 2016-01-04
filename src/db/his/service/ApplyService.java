package db.his.service;

import db.his.dao.ApplyDao;
import db.his.domain.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2016/1/5.
 */
@Service
public class ApplyService {
    @Autowired
    private ApplyDao applyDao;

    /**
     * 增加申请记录
     * @param apply
     * @throws SQLException
     */
    public void insert(Apply apply) throws SQLException {
        applyDao.insert(apply);
    }

    /**
     * 查询检查申请
     * @param apply
     * @return
     * @throws SQLException
     */
    public List<Apply> queryAll(Apply apply) {
        try {
            return applyDao.queryAll(apply);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
