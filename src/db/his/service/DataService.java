package db.his.service;

import db.his.dao.DataDao;
import db.his.domain.Database;
import db.his.util.WebUtils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by �� on 2015/9/14.
 */
public class DataService {

    DataDao ddao = new DataDao();
    public void backupDatabase(String realpath){

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            String time = sdf.format(new Date());
//            String time = String.valueOf(System.currentTimeMillis());
            String filename="his"+time+".sql";
            String fullfilename=realpath+"backup\\"+filename;//�����ļ���
            String command="cmd /c mysqldump -uroot -proot his>"+fullfilename;
            Runtime.getRuntime().exec(command);
            Database db=new Database();

            db.setBackuptime(time);

            db.setNo(WebUtils.makeId());////
            db.setName(filename);

            ddao.add(db);

        }catch(Exception e){
            throw new RuntimeException(e);
        }


    }

    /**
     *��ȡ�����б�
     * @return
     */
    public List<Database> getBackUpList() throws SQLException {

        return ddao.getList();
    }

    public void del(String no) throws SQLException {
        ddao.del(no);
    }
}
