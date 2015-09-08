package db.his.domain;

public class Doctor {
	private String doctor_id;
	private String dept_id;
	private String profession_id;
	private String name;
	private String password;
	
	
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getProfession_id() {
		return profession_id;
	}
	public void setProfession_id(String profession_id) {
		this.profession_id = profession_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Doctor() {
		super();
	}
	public Doctor(String id, String dept_id, String profession_id,
			String name, String password) {
		super();
		this.doctor_id = id;
		this.dept_id = dept_id;
		this.profession_id = profession_id;
		this.name = name;
		this.password = password;
	}
}
