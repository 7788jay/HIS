package db.his.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.his.domain.Doctor;
import db.his.domain.Privilege;
import db.his.service.CommonService;

public class PrivilegeInterceptor implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		CommonService cService = new CommonService();
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Doctor d = (Doctor)(request.getSession().getAttribute("user"));
		//管理员
		if (d!=null) {
			if (d.getDoctor_id().equals("1")) {
				chain.doFilter(request, response);
				return;
			}
		}
		//获取用户访问的地址
		String uri = request.getServletPath();
		String params = request.getQueryString();
		if (params != null) {
			params = params.substring(0, params.lastIndexOf("&")==-1?params.length():params.lastIndexOf("&"));
			uri+="?"+params;
		}
		if (uri.contains("/servlet/")) {
			
			System.out.println(uri);
		
			//获取存在session中的用户所有权限
			List<Privilege> privileges_session = (List<Privilege>) request.getSession().getAttribute("privileges");
			
			//判断用户是否可以访问
			//1，判断用户是否有该权限，有则放行
			if (privileges_session != null) {
				for (Privilege p : privileges_session) {
					if (p.getResourcename().equals(uri)) {
						chain.doFilter(request, response);
					}
				}
			}
			
			//2，否，获取数据库中所有权限列表,判断数据库中是否有该权限
			List<Privilege> privileges_db = cService.getAllPrivilege();
			if (privileges_db != null) {
				for (Privilege p : privileges_db) {
					if (p.getResourcename().equals(uri)) {
						request.setAttribute("message", "你没有该操作权限，请联系管理员！");
						request.getRequestDispatcher("/noPurview.jsp").forward(request, response);
//						response.getWriter().write("<script>alert(\"hhhh\")</script>");
//						chain.doFilter(request, response);
						
						return;
					}
				}
			}
		}
		//3，否，放行，有则自定义跳转页面和信息
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
}
