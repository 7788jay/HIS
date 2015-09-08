package db.his.service;

import java.sql.SQLException;
import java.util.List;


import db.his.dao.CommonDao;
import db.his.domain.Privilege;
import db.his.domain.PrivilegeType;
import db.his.domain.Profession;

public class CommonService {
	CommonDao cDao=new CommonDao();
	//获取所有职称
	public List<Profession> getAllProfession() throws SQLException {
		return cDao.getProfession();
	}
	/**
	 * 根据id获取职称
	 * @param profession_id
	 * @return 职称
	 * @throws SQLException 
	 */
	public Profession findProfession(String profession_id) throws SQLException {
		return cDao.findProfession(profession_id);
	}
	/**
	 * 获取该用户所有权限
	 * @param doctor_id
	 * @return
	 * @throws SQLException 
	 */
	public List<Privilege> getPrivilegeById(String doctor_id) throws SQLException {
		return cDao.getPrivilegeById(doctor_id);
	}
	/**
	 * 获取数据库中所有权限
	 * @return
	 * @throws SQLException 
	 */
	public List<Privilege> getAllPrivilege(){
		try {
			return cDao.getAllPrivilege();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
