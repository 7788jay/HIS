package db.his.test;

import java.sql.SQLException;

import db.his.dao.DoctorDao;
import db.his.domain.Doctor;

public class Tset {

	public static void main(String[] args) throws SQLException {
		Doctor doc=new Doctor("7777", "gg", "gg", "8855", "888");
		DoctorDao ddao=new DoctorDao();
		ddao.addDoctor(doc);

	}

}
