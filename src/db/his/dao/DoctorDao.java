package db.his.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.his.domain.dto.DoctorDTO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import db.his.domain.DocRole;
import db.his.domain.Doctor;
import db.his.util.JdbcUtil;

public class DoctorDao {
	QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());

	/**
	 * 添加一个医生
	 * @param doc
	 * @throws SQLException
     */
	public void addDoctor(Doctor doc) throws SQLException{
		String sql="insert into outpatient_docter(doctor_id,name,password,dept_id,profession_id) values(?,?,?,?,?)";
		Object params[]={doc.getDoctor_id(),doc.getName(),doc.getPassword(),doc.getDept_id(),doc.getProfession_id()};
		qr.update(sql, params);
	}

	/**
	 * 获取所有医生
	 * @return
	 * @throws SQLException
     */
	public List<Doctor> getAllDoc() throws SQLException {
		String sql="select * from outpatient_docter";
		List<Doctor> list=(List<Doctor>) qr.query(sql, new BeanListHandler(Doctor.class));
		return list;
	}

	/**
	 * 根据id获取医生
	 * @param doctor_id
	 * @return
	 * @throws SQLException
     */
	public Doctor findDoctorById(String doctor_id) throws SQLException {
		String sql="select * from outpatient_docter where doctor_id=?";
		Doctor doctor=(Doctor) qr.query(sql,doctor_id,new BeanHandler(Doctor.class));
		return doctor;
	}

	/**
	 * 更新用户角色
	 * @param docid
	 * @param roleids
	 * @throws SQLException
     */
	public void update(String docid, String[] roleids) throws SQLException {
		PreparedStatement statement=null;
		Connection connection=JdbcUtil.getConnection();
		connection.setAutoCommit(false);
		try {
			String sql = "delete from role_outpatient_docter where outpatient_docter_id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, docid);
			statement.executeUpdate();
            if(roleids!=null) {
                for (int i = 0; i < roleids.length; i++) {
                    sql = "insert into role_outpatient_docter(outpatient_docter_id,roleid) value(?,?)";
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, docid);
                    statement.setString(2, roleids[i]);
                    statement.executeUpdate();
                }
            }
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * 获取该用户的角色
	 * @param doctor_id
	 * @return
	 * @throws SQLException
     */
	public List<DocRole> getDocRoles(String doctor_id) throws SQLException {
		String sql="select * from role_outpatient_docter where outpatient_docter_id=?";
		List<DocRole> docRoles=(List<DocRole>) qr.query(sql,doctor_id,new BeanListHandler(DocRole.class));
		return docRoles;
	}
	/**
	 * 根据用户名密码获取医生
	 * @param doc
	 * @return
	 * @throws SQLException 
	 */
	public Doctor getDoctorByDoc(Doctor doc) throws SQLException {
		String sql="select * from outpatient_docter where name=? and password=?";
		Doctor doctor=(Doctor) qr.query(sql,new Object[]{doc.getName(),doc.getPassword()},new BeanHandler(Doctor.class));
		return doctor;
	}

	/**
	 * 根据科室获取所有医生
	 * @param dept_id
	 * @return
	 * @throws SQLException
     */
    public List<Doctor> getAllDocByDeptId(String dept_id) throws SQLException {
        String sql="select * from outpatient_docter where dept_id = ?";
        List<Doctor> list=(List<Doctor>) qr.query(sql,dept_id,new BeanListHandler(Doctor.class));
        return list;
    }

	/**
	 * 获取所有医生用于预约挂号
	 * @return
     */
	public List<DoctorDTO> getAllForSchedule() throws SQLException {
		String sql = "SELECT\n" +
					"	od.doctor_id,\n" +
					"	od. NAME,\n" +
					"	d. NAME dept_name,\n" +
					"	p.profession_name\n" +
					"FROM\n" +
					"	outpatient_docter od\n" +
					"LEFT JOIN department d ON od.dept_id = d.dept_id\n" +
					"LEFT JOIN profession p ON od.profession_id = p.profession_id";
		List<DoctorDTO> doctorDTOs = (List<DoctorDTO>) qr.query(sql,new BeanListHandler(DoctorDTO.class));
		return doctorDTOs;
	}
}
