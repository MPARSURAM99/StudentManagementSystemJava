package in.cutm.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static Connection con = null;
	
	public static Connection dbconnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_dbs", "root", "123@Shriramsms");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// : handle exception
		}
		
		return con;
	}
}
