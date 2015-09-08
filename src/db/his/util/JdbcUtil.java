package db.his.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	
	private static DataSource ds=null;
	static {
		ds = new ComboPooledDataSource();
	}
	public static DataSource getDataSources(){
		return ds;
		
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	} 
}
