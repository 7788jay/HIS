<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="user">
	<span><a href="servlet/LoginOutServlet">注销</a></span><span>欢迎你：${user.name }</span>
</div>
<div class="head_ul">
		<ul>
			<li onmouseover="change(this)" onmouseout="change(this)">
			<a href="javascript:void(0)" target="body" >用户管理</a>
				<div id="ul_xiala">
					<div class="li_xiala"><a href="${pageContext.request.contextPath}/manager/doctor/doctor.jsp">医生管理</a></div>
					<div class="li_xiala"><a href="#" target="body">护士管理</a></div>
					<div class="li_xiala"><a href="${pageContext.request.contextPath}/manager/patient/add_patient.jsp">病人管理</a></div>
				</div>
			</li>
			<li onmouseover="change(this)" onmouseout="change(this)">
			<a id="nav_role" href="${pageContext.request.contextPath }/servlet/RoleServlet?method=get">角色管理</a>
			</li>
			<li><a href="${pageContext.request.contextPath }/servlet/PrivilegeServlet?method=get">权限管理</a>
			</li>
			<li><a href="${pageContext.request.contextPath }/servlet/DepartmentServlet?method=getdeptUI">科室管理</a>
			</li>
            <li><a id="gg" href="${pageContext.request.contextPath }/servlet/DataServlet?method=query">数据库管理</a>
            </li>
		</ul>
	</div>