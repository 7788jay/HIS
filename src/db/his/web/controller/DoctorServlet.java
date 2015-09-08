package db.his.web.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONObject;

import db.his.domain.DepartCategory;
import db.his.domain.Department;
import db.his.domain.DocRole;
import db.his.domain.Doctor;
import db.his.domain.Profession;
import db.his.domain.Role;
import db.his.service.CommonService;
import db.his.service.DepartmentService;
import db.his.service.DoctorService;
import db.his.service.RoleService;
import db.his.util.ExcelPoiUtil;
import db.his.util.WebUtils;

public class DoctorServlet extends HttpServlet {
	DepartmentService dService=new DepartmentService();//科室服务层
	DoctorService doctorService=new DoctorService();//医生服务层
	CommonService cService=new CommonService();//普通服务层
	RoleService roleService=new RoleService();//角色服务层
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("one_add".equals(method)){
			one_add(request,response);
			return;
		}
		if("getDep_Pro".equals(method)){
			getDep_Pro(request,response);
			return;
		}
		if("getAllDoc".equals(method)){
			getAllDoc(request,response);//获取所有医生
			return;
		}if("getAllDocForUpdate".equals(method)){
			getAllDocForUpdate(request,response);//为角色授权获取所有医生
			return;
		}
		if("getRoleDoc".equals(method)){
			getRoleDoc(request,response);//获取医生角色授权页面
			return;
		}
		if("UpdateDocRole".equals(method)){
			UpdateDocRole(request,response);//更新用户角色
			return;
		}
		if("importInit".equals(method)){
			importInit(request,response);//初始化导入
			return;
		}
		if("importExcel".equals(method)){
			importExcel(request,response);//导入
			return;
		}
	}
	/**
	 * 导入
	 * @param request
	 * @param response
	 * @throws FileNotFoundException 
	 */
	private void importExcel(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException {
//		 String excelPath = request.getParameter("excelPath");  
		String excelPath = doupload(request);
        //输入流  
        InputStream fis = new FileInputStream(getServletContext().getRealPath("/")+"/upload/"+excelPath);  
          
        //POI:得到解析Excel的实体集合  
        List<Doctor> docs = ExcelPoiUtil.importDoctorsByPoi(fis);
        
        for (Doctor doctor : docs) {
			try {
				doctorService.addDoctor(doctor);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//        response.
		
	}
	/**
	 * 初始化导入
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void importInit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/manager/doctor/import.jsp").forward(request, response);
	}
	//更新用户角色
	private void UpdateDocRole(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String docid=request.getParameter("docid");
		String[] roleids=request.getParameterValues("roleid");
		JSONObject json=new JSONObject();
		try {
			doctorService.update(docid,roleids);
			json.put("message", "修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
			json.put("message", "修改失败");
		}
		response.getWriter().write(json.toString());
	}
	//获取医生角色授权页面
	private void getRoleDoc(HttpServletRequest request,
			HttpServletResponse response) {
		String doctor_id=request.getParameter("doctor_id");
		try {
			Doctor doctor=doctorService.findDoctorById(doctor_id);//获取医生信息
			Department dept=dService.findDepartment(doctor.getDept_id());//获取医生所在科室
			Profession pro=cService.findProfession(doctor.getProfession_id());//获取医生职称
			request.setAttribute("doctor", doctor);
			request.setAttribute("dept", dept);
			request.setAttribute("pro", pro);
			List<Role> roles=roleService.getAllRoles();
			request.setAttribute("roles", roles);//获取所有角色
			List<DocRole> docRoles=doctorService.getDocRoles(doctor_id);//获取该用户角色
			request.setAttribute("docRoles", docRoles);
			request.getRequestDispatcher("/manager/doctor/update_doc_role.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//为角色授权获取所有医生
	private void getAllDocForUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Doctor> doctors=doctorService.getAllDoc();
			List<Department> departments=dService.getAllDepartment();
			List<Profession> professions=cService.getAllProfession();
			request.setAttribute("doctors", doctors);
			request.setAttribute("departments", departments);
			request.setAttribute("professions", professions);
			request.getRequestDispatcher("/manager/doctor/role_doctor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取所有医生
	private void getAllDoc(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Doctor> doctors=doctorService.getAllDoc();
			List<Department> departments=dService.getAllDepartment();
			List<Profession> professions=cService.getAllProfession();
			request.setAttribute("doctors", doctors);
			request.setAttribute("departments", departments);
			request.setAttribute("professions", professions);
			request.getRequestDispatcher("/manager/doctor/list_doctor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//单独添加一个医生
	private void one_add(HttpServletRequest request,
			HttpServletResponse response) {
		String dept=request.getParameter("dept");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String pro_id=request.getParameter("pro");
		
		Doctor doctor=new Doctor(WebUtils.makeId(), dept, pro_id, username, password);
		try {
			doctorService.addDoctor(doctor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//获取科室及职称
	private void getDep_Pro(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<DepartCategory> categories=dService.getAllDepartCategory();
			List<Department> departments=dService.getDepartmentById("1");
			List<Profession> professions=cService.getAllProfession();
			request.setAttribute("pros", professions);
			request.setAttribute("categories", categories);
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("/manager/doctor/add_doctor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	/**
	 * 文件上传
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private String doupload(HttpServletRequest request){
		
		//把上传的图片保存到images/restaurant目录中，并把request中的请求参数封装到Restaurant中
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			String filename ="";
			for (FileItem item : list) {
				if (!item.isFormField()) {
					
					filename=item.getName();
					String savepath=this.getServletContext().getRealPath("/upload");
					
					InputStream in=item.getInputStream();
					FileOutputStream out=new FileOutputStream(savepath+"\\"+filename);
					int len=0;
					byte buffer[]=new byte[1024];
					while((len=in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete();
				}
			}
			return filename;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
