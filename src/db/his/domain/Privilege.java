package db.his.domain;

import java.io.Serializable;
public class Privilege implements Serializable{

	/**
	 * 
	 */
	private String pid;
	private String pname;
	private String pdescription;//权限的描述
	private String type_name; //权限的类型是指哪方面的管理，如用户管理
	private String resourcename;//资源名称
	
	
	
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	
	public Privilege() {
		super();
	}
	public Privilege(String pid, String pname, String pdescription,
			String type_name, String resourcename) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdescription = pdescription;
		this.type_name = type_name;
		this.resourcename = resourcename;
	}
	
	
}
