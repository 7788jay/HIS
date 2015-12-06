package db.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import db.his.domain.Privilege_Role;
import db.his.domain.Role;
import db.his.util.JdbcUtil;

public class RoleDao {
	QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
	//添加角色
	public void add(Role r) throws SQLException {
		String sql="insert into role(roleid,rolename,createtime,description) values(?,?,?,?)";
		Object params[]={r.getRoleid(),r.getRolename(),r.getCreatetime(),r.getDescription()};
		qr.update(sql, params);
	}
	//获取所有权限
	public List<Role> getAllRoles() throws SQLException {
		String sql="select * from role";
		List<Role> list=(List<Role>) qr.query(sql, new BeanListHandler(Role.class));
		return list;
	}
	public Role getRoleById(String roleid) throws SQLException {
		String sql="select * from role where roleid=?";
		Role role=(Role) qr.query(sql,roleid,new BeanHandler(Role.class));
		return role;
	}
	//更新角色权限
	public void update(String roleid, String[] penum) throws SQLException {
		PreparedStatement statement=null;
		Connection connection=JdbcUtil.getConnection();
		connection.setAutoCommit(false);
		try {
			String sql = "delete from privilege_role where roleid=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, roleid);
			statement.executeUpdate();
            if (penum!=null) {
                for (int i = 0; i < penum.length; i++) {
                    sql = "insert into privilege_role(roleid,pid) value(?,?)";
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, roleid);
                    statement.setString(2, penum[i]);
                    statement.executeUpdate();
                }
            }
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
	//根据id获取角色的权限
	public List<Privilege_Role> getRolePrivilege(String roleid) throws SQLException {
		String sql="select r.*,p.pname from privilege_role r left join privilege p on r.pid = p.pid where r.roleid=? ";
		List<Privilege_Role> list=(List<Privilege_Role>) qr.query(sql,roleid,new BeanListHandler(Privilege_Role.class));
		return list;
		
	}
	/**
	 * 获取角色信息
	 * @param role_id
	 * @return
	 * @throws SQLException 
	 */
	public Role GetRoleDetail(String role_id) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
		String sql = "select * from role where roleid = ?";
		Role role = (Role) qr.query(sql, role_id,new BeanHandler(Role.class));
		return role;
	}
	/**
	 * 更新角色信息
	 * @param r
	 * @return
	 * @throws SQLException 
	 */
	public void updateDetail(Role r) throws SQLException {
		String sql="update role set rolename =?,updatetime=?,description=? where roleid =?";
		Object params[]={r.getRolename(),r.getUpdatetime(),r.getDescription(),r.getRoleid()};
		qr.update(sql, params);
	}

}
