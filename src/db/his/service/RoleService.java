package db.his.service;


import java.sql.SQLException;
import java.util.List;

import db.his.dao.RoleDao;
import db.his.domain.Privilege_Role;
import db.his.domain.Role;

public class RoleService {
	RoleDao rDao=new RoleDao();
	//添加角色
	public void add(Role role) throws SQLException {
		rDao.add(role);
	}
	//获取所有角色
	public List<Role> getAllRoles() throws SQLException {
		return rDao.getAllRoles();
	}
	//根据Id获取角色
	public Role getRoleById(String roleid) throws SQLException {
		return rDao.getRoleById(roleid);
	}
	//更新权限信息
	public void update(String roleid, String[] penum) throws SQLException {
		rDao.update(roleid,penum);
	}
	//根据id获取角色的权限
	public List<Privilege_Role> getRolePrivilege(String roleid) throws SQLException {
		return rDao.getRolePrivilege(roleid);
	}
	/**
	 * 获取角色信息
	 * @param role_id
	 * @return
	 * @throws SQLException 
	 */
	public Role GetRoleDetail(String role_id) throws SQLException {
		return rDao.GetRoleDetail(role_id);
	}
	/**
	 * 更新角色信息
	 * @param role
	 * @throws SQLException 
	 */
	public void updateDetail(Role role) throws SQLException {
		rDao.updateDetail(role);
	}

}
