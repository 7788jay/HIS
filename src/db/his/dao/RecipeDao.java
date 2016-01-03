package db.his.dao;

import db.his.domain.Appointment;
import db.his.domain.Drug;
import db.his.domain.Recipe;
import db.his.domain.Recipe_Treatment;
import db.his.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2015/12/30.
 * 处方
 */
@Repository
public class RecipeDao {
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

    public List<Recipe_Treatment> queryOne(Appointment appointment){
        String sql = "SELECT\n" +
                    "	rt.*\n" +
                    "FROM\n" +
                    "	recipe_treatment rt\n" +
                    "LEFT JOIN recipe r ON r.recipe_id = rt.recipe_id\n" +
                    "WHERE\n" +
                    "	r.patient_id = ?\n" +
                    "	AND r.doctor_id=?\n" +
                    "	AND r.appointment_id = ?;";
        return null;
    }

    /**
     * 查询所有药品
     * @return
     * @throws SQLException
     */
    public List<Drug> queryAll() throws SQLException {
        String sql = "select * from drug order by id";
        return (List<Drug>) qr.query(sql,new BeanListHandler(Drug.class));
    }

    /**
     * 插入处方
     * @param r  处方
     * @param rts  处方药
     * @throws SQLException
     */
    public void insert(Recipe r, List<Recipe_Treatment> rts) throws SQLException {
        String sql = "insert into recipe (recipe_id,doctor_id,diag_date,patient_id,comment,appointment_id)values(?,?,?,?,?,?) ";
        Object [] params = new Object[]{r.getRecipe_id(),r.getDoctor_id(),r.getDiag_date(),r.getPatient_id(),r.getComment(),r.getAppointment_id()};
        qr.update(sql,params);
        sql =  "insert into recipe_treatment (recipe_id,drug_code,drug_name,amount,unit) values(?,?,?,?,?)";
        Object[][] rts_params = new Object[rts.size()][];
        int i = 0;
        for( Recipe_Treatment rt : rts){
            rts_params[i] = new Object[]{r.getRecipe_id(),rt.getDrug_code(),rt.getDrug_name(),rt.getAmount(),rt.getUnit()};
            i++;
        }
        qr.batch(sql,rts_params);
    }
}
