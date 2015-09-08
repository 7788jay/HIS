package db.his.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import db.his.domain.Doctor;
import db.his.domain.Privilege;
import db.his.service.CommonService;
import db.his.service.DoctorService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommonService cService = new CommonService();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String status=request.getParameter("status");
		JSONObject json = new JSONObject();
		if("m".equals(status)){//管理员
			String cusernameString=(String) this.getServletContext().getAttribute("username");
			String cpasswordString=(String) this.getServletContext().getAttribute("password");
			if(cusernameString.equals(username)&&cpasswordString.equals(password)){
				Doctor doctor = new Doctor();
				doctor.setName("超级管理员");
				doctor.setDoctor_id("1");
				request.getSession().setAttribute("user", doctor);
				json.put("message", "IndexServlet");
			}else{
				json.put("message", "error");
//				request.setAttribute("message", "用户名或密码错误！");
//				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
		}else if("d".equals(status)){//医生
			Doctor doctor = new Doctor();
			doctor.setName(username);
			doctor.setPassword(password);
			DoctorService dService = new DoctorService();
			try {
				Doctor sDoctor = dService.getDoctorByDoc(doctor);
				if (sDoctor!=null) {
					List<Privilege> privileges = cService.getPrivilegeById(sDoctor.getDoctor_id());
					request.getSession().setAttribute("user", sDoctor);
					request.getSession().setAttribute("privileges", privileges);
					json.put("message", "IndexServlet");
				}else {
					json.put("message", "error");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.getWriter().write(json.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
