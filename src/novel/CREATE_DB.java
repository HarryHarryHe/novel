package novel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CREATE_DB {
	//数据库基本信息
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/friendinfos?useUnicode=true&characterEncoding=utf-8";
	static final String USER = "root";
	static final String PASSWORD = "19990428";
	public CREATE_DB(){
		Connection conn = null;	
		Statement stmt = null;
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("正在连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("实例化statement对象...");
			stmt = conn.createStatement();
			
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS `hello`;");
		
			final String DB_URL_1 = "jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=utf-8";
			conn = DriverManager.getConnection(DB_URL_1, USER, PASSWORD);
			stmt = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS `test`("
							 + "`id` int(16) AUTO_INCREMENT,"
				             + "`account` varchar(32) not null,"
				             + "`password` varchar(32) not null,"
				             + "PRIMARY KEY(id,account)"
				             + ")charset=utf8;";
			if(0==stmt.executeUpdate(sql)){
				System.out.println("创建数据库和表成功");
			}
			else{
				System.out.println("Fail to create!");
			}
			stmt.close();
			conn.close();
	     } catch (ClassNotFoundException e) {  
				System.out.println("获取驱动类失败");  
	            e.printStackTrace();  
	     } catch(SQLException e) {
	         System.out.println("连接数据库失败");  
	    	 e.printStackTrace();  
	     }   
	}
	public static void main(String[] args) {
		new CREATE_DB();
	}
}
