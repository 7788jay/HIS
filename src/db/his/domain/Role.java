package db.his.domain;

import java.util.Date;

/**
 * 角色（岗位）
 * 
 * @author 林
 * 
 */
public class Role {

	private String roleid;
	private String rolename;
	private String description;
	private Date createtime;
	private Date updatetime;
	public Role() {
		super();
	}
	public Role(String roleid, String rolename, String description,
			Date createtime, Date updatetime) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.description = description;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}


	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
