package db.his.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import db.his.domain.Privilege;
import db.his.domain.PrivilegeType;
import db.his.util.JdbcUtil;

public class PrivilegeDao {
	//获取所有权限类型
		public List<PrivilegeType> getAllPrivilegeType() throws SQLException {
			QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
			String sql="select * from type";
			List<PrivilegeType> list=(List<PrivilegeType>) qr.query(sql, new BeanListHandler(PrivilegeType.class));
			return list;
		}
		//获取所有权限
		public List<Privilege> findAllPrivilege() throws SQLException {
			QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
			String sql="select * from privilege";
			List<Privilege> list=(List<Privilege>) qr.query(sql, new BeanListHandler(Privilege.class));
			return list;
		}
		//添加一个权限
		public void add(Privilege p) throws SQLException {
			QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
			String sql="insert into privilege(pid,pname,pdescription,type_name,resourcename) values(?,?,?,?,?)";
			Object params[]={p.getPid(),p.getPname(),p.getPdescription(),p.getType_name(),p.getResourcename()};
			qr.update(sql, params);
		}
}
