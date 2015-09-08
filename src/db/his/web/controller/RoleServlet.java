package db.his.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import db.his.domain.Privilege;
import db.his.domain.PrivilegeType;
import db.his.domain.Privilege_Role;
import db.his.domain.Role;
import db.his.service.PrivilegeService;
import db.his.service.RoleService;
import db.his.util.WebUtils;

public class RoleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	PrivilegeService pService=new PrivilegeService();//权限服务类
	RoleService roleService=new RoleService();//角色服务类
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("get".equals(method)){//获取角色页面
			get(request,response);
			return;
		}
		if("add".equals(method)){
			add(request,response);//创建角色
			return;
		}
		if("getUpdateRole".equals(method)){
			getUpdateRole(request,response);//获取角色权限修改页面
			return;
		}
		if("UpdateRole".equals(method)){
			UpdateRole(request,response);//角色权限修改
			return;
		}
		if("GetRoleById".equals(method)){
			GetRoleById(request,response);//角色权限修改
			return;
		}
		if("GetRoleDetail".equals(method)){
			GetRoleDetail(request,response);//初始化角色信息修改
			return;
		}
		if("UpdateRoleDetail".equals(method)){
			UpdateRoleDetail(request,response);//角色信息修改
			return;
		}
		
	}
	/**
	 * 角色信息修改
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void UpdateRoleDetail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String roleid=request.getParameter("role_id");
		String rname=request.getParameter("rname");
		String description=request.getParameter("description");
		
		Role role=new Role(roleid, rname, description,null,new Date());
		JSONObject json = new JSONObject();
		try {
			rService.updateDetail(role);
			json.put("message", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("message", "修改失败");
		}
		response.getWriter().write(json.toString());
	}
	/**
	 * 初始化角色信息修改
	 * @param request
	 * @param response
	 */
	private void GetRoleDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String role_id =request.getParameter("role_id");
		try {
			Role role=roleService.GetRoleDetail(role_id);
			request.setAttribute("role", role);
			request.getRequestDispatcher("/manager/role/roledetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查看角色权限
	 * @param request
	 * @param response
	 */
	private void GetRoleById(HttpServletRequest request,
			HttpServletResponse response) {
		String roleid=request.getParameter("roleid");
		//根据id获取角色的权限
		try {
			List<Privilege_Role> role_privileges=roleService.getRolePrivilege(roleid);
			request.setAttribute("role_privileges", role_privileges);
			request.getRequestDispatcher("/manager/role/listprivilege.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//角色权限修改
	private void UpdateRole(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String roleid=request.getParameter("roleid");
		String[] penum=request.getParameterValues("privilege");
		JSONObject json=new JSONObject();
		try {
			roleService.update(roleid,penum);
			json.put("message", "修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
			json.put("message", "修改失败");
		}
		response.getWriter().write(json.toString());
	}
	//获取角色权限修改页面
	private void getUpdateRole(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String roleid=request.getParameter("roleid");
			//根据id获取角色信息
			Role role=roleService.getRoleById(roleid);
			//根据id获取角色的权限
			List<Privilege_Role> role_privileges=roleService.getRolePrivilege(roleid);
			List<PrivilegeType> typesList=pService.getAllPrivilegeType();
			List<Privilege> privileges=pService.getAllPrivilege();
			request.setAttribute("typesList", typesList);
			request.setAttribute("privileges", privileges);
			request.setAttribute("role_privileges", role_privileges);
			request.setAttribute("role", role);
			request.getRequestDispatcher("/manager/role/update_role.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	RoleService rService=new RoleService();
	//添加角色
	private void add(HttpServletRequest request, HttpServletResponse response) {
		String rname=request.getParameter("rname");
		String description=request.getParameter("description");
		
		Role role=new Role(WebUtils.makeId(), rname, description, new Date(),null);
		
		try {
			rService.add(role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//获取所有角色
	private void get(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Role> roles=rService.getAllRoles();
			request.setAttribute("roles", roles);
			request.getRequestDispatcher("/manager/role/role.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
