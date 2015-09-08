package db.his.service;

import java.sql.SQLException;
import java.util.List;
import db.his.dao.PrivilegeDao;
import db.his.domain.Privilege;
import db.his.domain.PrivilegeType;

public class PrivilegeService {
	
	PrivilegeDao pDao=new PrivilegeDao();
	//获取所有权限类型
	public List<PrivilegeType> getAllPrivilegeType() throws SQLException {
		return pDao.getAllPrivilegeType();
	}
	//添加一个权限
	public void add(Privilege privilege) throws SQLException {
		pDao.add(privilege);
	}
	public List<Privilege> getAllPrivilege() throws SQLException {
		
		return pDao.findAllPrivilege();
	}
}
