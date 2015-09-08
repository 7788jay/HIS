package db.his.web.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ManagerInint implements ServletContextListener {
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext Context=arg0.getServletContext();
		String path=Context.getRealPath("");
		File file=new File(path+"/manager.properties");
		try {
			FileInputStream inputStream=new FileInputStream(file);
			Properties properties=new Properties();
			properties.load(inputStream);
			String username=properties.getProperty("username");
			String password=properties.getProperty("password");
			Context.setAttribute("username", username);
			Context.setAttribute("password", password);
			System.out.println(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
