package db.his.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import db.his.domain.DepartCategory;
import db.his.domain.Department;
import db.his.util.JdbcUtil;

public class DepartmentDao {
	//根据科室分类id获取科室
	public List<Department> getDepartmentById(String depet_category_id) throws SQLException{
		
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
		String sql="select * from department where depet_category_id=?";
		List<Department> list=(List<Department>) qr.query(sql,depet_category_id, new BeanListHandler(Department.class));
		return list;
	}
	//获取科室分类
	public List<DepartCategory> getAllDepartCategory() throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
		String sql="select * from department_category";
		List<DepartCategory> list= (List<DepartCategory>) qr.query(sql, new BeanListHandler(DepartCategory.class));
		return list;
	}
	//获取所有科室
	public List<Department> getAllDepartment() throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
		String sql="select * from department";
		List<Department> list=(List<Department>) qr.query(sql,new BeanListHandler(Department.class));
		return list;
	}
	/**
	 * 根据科室编号获取科室
	 * @param dept_id
	 * @return Department
	 * @throws SQLException 
	 */
	public Department findDepartment(String dept_id) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
		String sql="select * from department where dept_id=?";
		Department department =(Department) qr.query(sql,dept_id,new BeanHandler(Department.class));
		return department;
	}

	/**
	 * 更新
	 * @param dept_id
	 * @param name
	 */
	public void update(String dept_id, String name) throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
		String sql="update department set name = ? where dept_id = "+dept_id;
		qr.update(sql,name);
	}

    /**
     * 删除
     * @param dept_id
     */
    public void del(String dept_id) throws SQLException {
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
        String sql="delete from department where dept_id = "+dept_id;
        qr.update(sql);
    }

    public void add(Department department) throws SQLException {
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSources());
        String sql="insert into department (dept_id,name,depet_category_id) values (?,?,?)";
        qr.update(sql,new Object[]{department.getDept_id(),department.getName(),department.getDepet_category_id()});
    }
}
