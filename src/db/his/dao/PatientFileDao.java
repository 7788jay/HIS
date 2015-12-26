package db.his.dao;

import db.his.domain.PatientFile;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2015/12/26.
 */
@Repository
public class PatientFileDao {
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

    /**
     * 根据病人id获取病历
     * @param patient_id
     * @return
     * @throws SQLException
     */
    public List<PatientFile> queryOne(String patient_id) throws SQLException {
        String sql = "SELECT * FROM patient_file where patient_id = ?";
        return (List<PatientFile>) qr.query(sql,patient_id,new BeanListHandler(PatientFile.class));
    }

    /**
     * 批量插入病历内容
     * @param pfs
     * @throws SQLException
     */
    public void batchInsert(List<PatientFile> pfs) throws SQLException {
        this.deleteByPatientId(pfs.get(0).getPatient_id());
        Object[][] params = new Object[pfs.size()][];
        int i = 0;
        for( PatientFile pf : pfs){
            params[i] = new Object[]{pf.getName(),pf.getComment(),pf.getDate(),pf.getModifier(),pf.getPatient_id(),pf.getTimes()+1};
            i++;
        }
        String sql = "insert into patient_file(name,comment,date,modifier,patient_id,times) value(?,?,?,?,?,?)";
        qr.batch(sql,params);
    }

    /**
     * 根据病人id删除病历内容
     * @param patient_id
     * @throws SQLException
     */
    public void deleteByPatientId(String patient_id) throws SQLException {
        String sql = "delete from patient_file where patient_id=?";
        qr.update(sql,patient_id);
    }
}
