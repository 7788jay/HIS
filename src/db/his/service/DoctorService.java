package db.his.service;


import java.sql.SQLException;
import java.util.List;

import db.his.dao.DoctorDao;
import db.his.domain.DocRole;
import db.his.domain.Doctor;

public class DoctorService {
	DoctorDao doctorDao=new DoctorDao();
	//单独添加一个医生
	public void addDoctor(Doctor doc) throws SQLException{
		doctorDao.addDoctor(doc);
	}
	//获取所有医生
	public List<Doctor> getAllDoc() throws SQLException {
		return doctorDao.getAllDoc();
	}
	//根据id获取医生
	public Doctor findDoctorById(String doctor_id) throws SQLException {
		return doctorDao.findDoctorById(doctor_id);
	}
	//根据id获取医生
	public Doctor getDoctorByDoc(Doctor doc) throws SQLException {
		return doctorDao.getDoctorByDoc(doc);
	}
	//更新用户角色
	public void update(String docid, String[] roleids) throws SQLException {
		doctorDao.update(docid,roleids);
	}
	//获取该用户的角色
	public List<DocRole> getDocRoles(String doctor_id) throws SQLException {
		return doctorDao.getDocRoles(doctor_id);
	}
}
