	package novel;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

@SuppressWarnings("serial")
public class User implements Serializable{
	private String account;
	private String password;
	private String nickname;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	public User(String nickname){
		this.nickname = nickname;
	}
	public boolean validate(String account,String password) throws SQLException{
		String sql = "select * from `test` where account='"+account+"' and password='"+password+"'";
		Statement stmt = DB_Connect.getStatement();
		ResultSet rs = (ResultSet)stmt.executeQuery(sql);
		if(rs.next()){
			stmt.close();
			rs.close();
			return true;
		}
		stmt.close();
		rs.close();
		return false;  
	}
	public void register(String account,String password,String nickname,String status){
		@SuppressWarnings("unused")
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=utf-8";
		String USER = "root";
		String PASSWORD = "19990428";
		String sql = "insert into `test`(`account`,`password`,`nickname`,`is`)values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("����������ݿ�...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//			System.out.println("ʵ��statement����...");
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, account);
			stmt.setString(2, password);
			stmt.setString(3, nickname);
			stmt.setString(4, status);
			stmt.executeUpdate();
			System.out.println("连接使用数据库成功");
			conn.close();
			stmt.close();
			
			} catch (ClassNotFoundException e) {  
			System.out.println("发生错误");  
//            e.printStackTrace();  
			} catch(SQLException e) {
//				System.out.println("SQL�쳣");  
				e.printStackTrace();  
			} 
		}
	public void share(String user,String to_user,String bookname,String content){
		String sql = "insert into `sharing`(user,to_user,book_name,content)values('"+user+"','"+to_user+"','"+bookname+"','"+content+"')";
		try {
			DB_Connect.getStatement().executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "分享成功");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "分享失败");
			e.printStackTrace();
		}
	}
	public void buy(String user_id,String book_id){
		String sql = "insert into `book_payment`(`user_id`,`book_id`,`pay_status`)values("+user_id+","+book_id+","+1+")";
		try {
			DB_Connect.getStatement().executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "购买成功");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "购买失败");
			e.printStackTrace();
		}
	}
	public void comment(String bookname,String user,String status,String content,String time){
		String sql = "";
	}
}