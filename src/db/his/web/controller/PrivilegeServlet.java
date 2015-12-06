package db.his.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.his.domain.Privilege;
import db.his.domain.PrivilegeType;
import db.his.service.PrivilegeService;
import db.his.util.WebUtils;
import net.sf.json.JSONObject;

/**
 * 权限管理
 * @author 林
 *
 */
public class PrivilegeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("get".equals(method)){
			get(request,response);
			return;
		}
		if("add".equals(method)){
			add(request,response);
			return;
		}
	}
	PrivilegeService pService=new PrivilegeService();//权限服务类
	//增加权限
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pname=request.getParameter("pname");
		String rname=request.getParameter("rname");
		String description=request.getParameter("description");
		String ptype=request.getParameter("ptype");

        JSONObject json = new JSONObject();
		Privilege privilege=new Privilege(WebUtils.makeId(), pname, description, ptype, rname);
		
		try {
			pService.add(privilege);
			//response.sendRedirect("/HIS/servlet/PrivilegeServlet?method=get");
            json.put("message","添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
            json.put("message", "添加失败！");
		}
        response.getWriter().write(json.toString());
	}
	//获取权限管理页面
	private void get(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<PrivilegeType> typesList=pService.getAllPrivilegeType();
			List<Privilege> privileges=pService.getAllPrivilege();
			request.setAttribute("typesList", typesList);
			request.setAttribute("privileges", privileges);
			request.getRequestDispatcher("/manager/privilege/privilege.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
