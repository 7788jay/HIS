package db.his.service;

import java.sql.SQLException;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import db.his.dao.DepartmentDao;
import db.his.domain.DepartCategory;
import db.his.domain.Department;

public class DepartmentService {
	DepartmentDao departmentDao=new DepartmentDao();
	//根据科室分类id获取科室
	public List<Department> getDepartmentById(String depet_category_id) throws SQLException{
		
		return departmentDao.getDepartmentById(depet_category_id);
		
	}
	//获取所有科室
	public List<Department> getAllDepartment() throws SQLException{
		
		return departmentDao.getAllDepartment();
		
	}
	//获取科室分类
	public List<DepartCategory> getAllDepartCategory() throws SQLException {
		return departmentDao.getAllDepartCategory();
	}
	/**
	 * 根据科室编号获取科室
	 * @param dept_id
	 * @return Department
	 * @throws SQLException 
	 */
	public Department findDepartment(String dept_id) throws SQLException {
		return departmentDao.findDepartment(dept_id);
	}
}
