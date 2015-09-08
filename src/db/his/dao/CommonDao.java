package db.his.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import db.his.domain.Privilege;
import db.his.domain.Profession;
import db.his.util.JdbcUtil;

public class CommonDao {
	QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
	//获取所有职称
	public List<Profession> getProfession() throws SQLException {
		String sql="select * from profession";
		List<Profession> list=(List<Profession>) qr.query(sql, new BeanListHandler(Profession.class));
		return list;
	}
	/**
	 * 根据id获取职称
	 * @param profession_id
	 * @return 职称
	 * @throws SQLException 
	 */
	public Profession findProfession(String profession_id) throws SQLException {
		String sql="select * from profession where profession_id=?";
		Profession profession= (Profession) qr.query(sql,profession_id, new BeanHandler(Profession.class));
		return profession;
	}
	/**
	 * 获取该用户所有权限
	 * @param doctor_id
	 * @return
	 * @throws SQLException 
	 */
	public List<Privilege> getPrivilegeById(String doctor_id) throws SQLException {
		String sql="SELECT\n" +
				"p.pname,\n" +
				"p.resourcename,\n" +
				"d.`name`\n" +
				"FROM\n" +
				"privilege AS p\n" +
				"JOIN privilege_role AS pr ON p.pid = pr.pid\n" +
				"JOIN role AS r ON pr.roleid = r.roleid\n" +
				"JOIN role_outpatient_docter AS rd ON rd.roleid = r.roleid\n" +
				"JOIN outpatient_docter AS d ON d.doctor_id = rd.outpatient_docter_id\n" +
				"where rd.outpatient_docter_id = ?";
		List<Privilege> list = (List<Privilege>) qr.query(sql, doctor_id, new BeanListHandler(Privilege.class));
		return list;
	}
	/**
	 * 获取数据库中所有权限
	 * @return
	 * @throws SQLException 
	 */
	public List<Privilege> getAllPrivilege() throws SQLException {
		String sql="SELECT\n" +
				"*\n" +
				"FROM\n" +
				"privilege";
		List<Privilege> list = (List<Privilege>) qr.query(sql, new BeanListHandler(Privilege.class));
		return list;
	}

}
