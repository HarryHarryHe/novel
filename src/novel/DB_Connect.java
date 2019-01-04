package novel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connect {
	private static Statement stmt = null;
	private static Connection conn = null;
	private static void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=utf-8","root","19990428");
			stmt = conn.createStatement();
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Statement getStatement() {
		if (stmt == null) {
			init();
		}
		return stmt;
	}
	public static void main(String[] args) {
		getStatement();
	}
}