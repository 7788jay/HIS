package db.his.web.listener;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import db.his.dao.PrivilegeDao;
import db.his.domain.Privilege;

public class InitDataListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		PrivilegeDao dao = new PrivilegeDao();
		//从数据库中获取所有权限列表
		List<Privilege> list = null;
		try {
			list = dao.findAllPrivilege();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//保存到application域里
		sce.getServletContext().setAttribute("privilegeList", list);
	}

}
