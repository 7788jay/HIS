package db.his.domain;

public class Department {
	private String dept_id;
	private String name;
	private String depet_category_id;
	
	public String getDepet_category_id() {
		return depet_category_id;
	}
	public void setDepet_category_id(String depet_category_id) {
		this.depet_category_id = depet_category_id;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
