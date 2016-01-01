package db.his.test;

import db.his.dao.DoctorDao;
import db.his.domain.Doctor;

import java.sql.SQLException;

public class Tset {

	public static void main(String[] args) throws SQLException {
		Doctor doc=new Doctor("7777", "gg", "gg", "8855", "888");
		DoctorDao ddao=new DoctorDao();
		ddao.addDoctor(doc);

	}

//	@Test
	public void testAnnotation(){

	}

}
