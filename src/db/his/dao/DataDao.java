package db.his.dao;

import db.his.domain.Database;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 林 on 2015/9/14.
 */
public class DataDao {

    QueryRunner qr = new QueryRunner(JdbcUtil.getDataSources());
    public void add(Database db) throws SQLException {
        String sql = "insert into data_log (no,name,backuptime) values (?,?,?)";
        qr.update(sql, new Object[]{db.getNo(),db.getName(),db.getBackuptime()});
    }

    public List<Database> getList() throws SQLException {
        String sql = "select * from  data_log order by backuptime desc";
        List<Database> lists = (List<Database> )qr.query(sql,new BeanListHandler(Database.class));
        return lists;
    }

    public void del(String no) throws SQLException {
        String sql = "delete from  data_log where no = ?";
        qr.update(sql,no);
    }
}
