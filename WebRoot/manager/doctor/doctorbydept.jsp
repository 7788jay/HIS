<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    		<c:forEach var="d" items="${doctors }">
	    		<tr>
	    			<td class="td_01">${d.name }</td>
	    			<td class="td_01">
	    				<c:forEach var="pro" items="${professions }">
		    				<c:if test="${pro.profession_id==d.profession_id }">${pro.profession_name }</c:if>
	    				</c:forEach>
					</td>
	    			<td class="td_01">
	    				<c:forEach var="dept" items="${departments }">
		    				<c:if test="${d.dept_id==dept.dept_id }">${dept.name }</c:if>
	    				</c:forEach>
					</td>
	    			<td class="td_01"><a href="${pageContext.request.contextPath }/servlet/OrdersServlet?method=select&order_id=${order.id}">修改</a>

	    			</td>
	    		</tr>
    		</c:forEach>
