package db.his.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.his.util.WebUtils;
import net.sf.json.JSONObject;


import db.his.domain.DepartCategory;
import db.his.domain.Department;
import db.his.service.DepartmentService;

public class DepartmentServlet extends HttpServlet {

	DepartmentService dService=new DepartmentService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("get".equals(method)){
			get(request,response);
		}if("add".equals(method)){
			add(request, response);
		}
		if("getbyid".equals(method)){
			getbyid(request, response);
		}
		if("getdeptUI".equals(method)){
			getdeptUI(request, response);
		}
		if("UpdateInit".equals(method)){
			UpdateInit(request, response);
		}
		if("UpdateDept".equals(method)){
			UpdateDept(request, response);
		}
        if("del".equals(method)){
            del(request, response);
        }
	}

    /**
     * 添加
     * @param request
     * @param response
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dept_id = WebUtils.makeId();
        String name = request.getParameter("name");
        String depet_category_id = request.getParameter("dcid");

        Department department = new Department(dept_id,name,depet_category_id);

        JSONObject json=new JSONObject();
        try {
            dService.add(department);
            json.put("message", "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("message", "增加失败");
        }
        response.getWriter().write(json.toString());
    }

    /**
     * 删除
     * @param request
     * @param response
     */
    private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dept_id = request.getParameter("dept_id");

        JSONObject json=new JSONObject();
        try {
            dService.del(dept_id);
            json.put("message", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("message", "修改失败");
        }
        response.getWriter().write(json.toString());
    }

    //科室修改
	private void UpdateDept(HttpServletRequest request,
							HttpServletResponse response) throws IOException {
		String dept_id = request.getParameter("dept_id");
		String name = request.getParameter("dname");
		JSONObject json=new JSONObject();
		try {
			dService.update(dept_id,name);
			json.put("message", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("message", "修改失败");
		}
		response.getWriter().write(json.toString());
	}
	/**
	 * 修改页面
	 * @param request
	 * @param response
	 */
	private void UpdateInit(HttpServletRequest request, HttpServletResponse response) {
		String dept_id = request.getParameter("dept_id");
		try {
			Department department = dService.findDepartment(dept_id);
			List<DepartCategory> categories=dService.getAllDepartCategory();

			request.setAttribute("categories", categories);
			request.setAttribute("d",department);
			request.getRequestDispatcher("/manager/department/updatedept.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 管理页面初始化
	 * @param request
	 * @param response
	 */
	private void getdeptUI(HttpServletRequest request, HttpServletResponse response) {
		try{
			List<DepartCategory> categories=dService.getAllDepartCategory();

			List<Department> departments=dService.getAllDepartment();
			request.setAttribute("categories", categories);
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("/manager/department/dept.jsp").forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
		}
	}


	//根据分类id获取科室
	private void getbyid(HttpServletRequest request,
			HttpServletResponse response) {
		String depet_category_id=request.getParameter("id");
		try {
			List<Department> departments=dService.getDepartmentById(depet_category_id);
			JSONObject json=new JSONObject();
			json.put("dept", departments);
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取科室分类
	private void get(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<DepartCategory> categories=dService.getAllDepartCategory();
			List<Department> departments=dService.getDepartmentById("1");
			request.setAttribute("categories", categories);
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("/manager/doctor/aadoctor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
