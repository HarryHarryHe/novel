/*
 * NovelBuilder.java
 *
 * Created on __DATE__, __TIME__
 */

package novel;

import getHour.GetHour;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
/**
 *
 * @author  __USER__
 */
@SuppressWarnings({ "serial", "unused" })
public class NovelLogin extends javax.swing.JFrame {
	
	/** Creates new form NovelBuilder */
	public NovelLogin() {
//		new DB_Link();
		initComponents();
	}
	
	//判断数据库中是有该用户名和密码
	public boolean validate(String account,String password){
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=utf-8";
		String USER = "root";
		String PASSWORD = "19990428";
		String sql = "select * from `test` where account=? and password=?";
		Connection conn = null;
		PreparedStatement stmt = null;  //要导入com.jdbc包
		try{
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("正在连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//			System.out.println("实例化statement对象...");
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1, account);
			stmt.setString(2, password);
			
			ResultSet rs = (ResultSet)stmt.executeQuery();
			
			if(rs.next()){
				conn.close();
				stmt.close();
				rs.close();
				return true;
			}
			conn.close();
			stmt.close();
			rs.close();
			} catch (ClassNotFoundException e) {  
			System.out.println("获取驱动类失败");  
//            e.printStackTrace();  
			} catch(SQLException e) {
//				System.out.println("SQL异常");  
				e.printStackTrace();  
			} 
			return false;  
		}
	public static String getnickname(String account){
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=utf-8";
		String USER = "root";
		String PASSWORD = "19990428";
		String sql = "select * from `test` where account='"+account+"'";
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("正在连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//			System.out.println("实例化statement对象...");
			stmt = conn.createStatement();

			ResultSet rs = (ResultSet)stmt.executeQuery(sql);
			
			if(rs.next()){
				String nick_name = rs.getString("nickname");
				conn.close();
				stmt.close();
				rs.close();
				return nick_name;
			}
			conn.close();
			stmt.close();
			rs.close();
			} catch (ClassNotFoundException e) {  
			System.out.println("获取驱动类失败");  
//            e.printStackTrace();  
			} catch(SQLException e) {
//				System.out.println("SQL异常");  
				e.printStackTrace();  
			}  
		return null;
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		
		jFrame1 = new javax.swing.JFrame();
		this.setTitle("豆瓣阅读登陆");
		this.setResizable(false);
		
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jPanel6 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPasswordField1 = new javax.swing.JPasswordField();
		jPanel4 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jLabel5 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(
				jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jLabel4.setBackground(new java.awt.Color(51, 255, 51));
		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/icon1.jpg"))); // NOI18N

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addGap(30, 30, 30)
						.addComponent(jLabel4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 332,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel2.setText("\u8d26\u53f7");

		jTextField1
				.setText("\u90ae\u7bb1/\u624b\u673a\u53f7/\u7528\u6237\u540d");
		jTextField1.setFont(new Font("Serif",Font.BOLD,20));
		jTextField1.setFocusable(false);
		jTextField1.setForeground(Color.gray);
		//禁用输入法
		jTextField1.enableInputMethods(false);
		
		jTextField1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//结束不可编辑
				jTextField1.setEditable(true);
				jTextField1.enableInputMethods(false);
				
				if(jTextField1.getText().equals("")){
					jTextField1.setText("邮箱/手机号/用户名");
					jTextField1.setForeground(Color.gray);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//屏蔽空格
				if(e.getKeyChar()==KeyEvent.VK_SPACE){
					jTextField1.setEditable(false);
				}
				if(jTextField1.getText().startsWith("邮箱/手机号/用户名")){
					jTextField1.setText("");
					jTextField1.setForeground(Color.black);
				}
				else{
					
				}
			}
		});
		jTextField1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				jTextField1.setForeground(Color.black);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				jTextField1.setFocusable(true);
				// TODO Auto-generated method stub
				if(jTextField1.getText().startsWith("邮箱/手机号/用户名")){
					jTextField1.setText("");
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel3Layout.createSequentialGroup().addContainerGap(
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel2).addGap(32, 32, 32).addComponent(
								jTextField1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 274,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								229, 229, 229)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																41,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																48,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)));

		jPanel6.setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel1.setText("\u5bc6\u7801");

		jPasswordField1.enableInputMethods(false);
		jPasswordField1.setFocusable(false);
		jPasswordField1.setFont(new Font("Serif",Font.BOLD,20));
		jPasswordField1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				jPasswordField1.setEditable(true);
				jPasswordField1.enableInputMethods(false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar()==KeyEvent.VK_SPACE){
					jPasswordField1.setEditable(false);
				}
			}
		});
		jPasswordField1.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				jPasswordField1.setFocusable(true);
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
			}
		});

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel6Layout.createSequentialGroup().addContainerGap(
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1).addGap(31, 31, 31).addComponent(
								jPasswordField1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 278,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanel6Layout
				.setVerticalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel6Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel6Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPasswordField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																46,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 48));
		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/icon2.jpg"))); // NOI18N

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout.createSequentialGroup().addGap(49, 49, 49)
						.addComponent(jLabel3).addContainerGap(308,
								Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel3));

		jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox1.setForeground(new java.awt.Color(102, 102, 102));
		jCheckBox1.setText("\u4e0b\u6b21\u81ea\u52a8\u767b\u9646 |");
		jCheckBox1.setFocusable(false);
		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}
		});

		jLabel5.setForeground(new java.awt.Color(138, 188, 230));
		jLabel5.setText("\u8fd8\u6ca1\u8d26\u53f7");
		jLabel5.addMouseListener(new MouseListener() {
			Color a = new Color(138,188,230);
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
//				jLabel5.setBackground(Color.blue);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//Opaque 透明设置
				jLabel5.setOpaque(true);
				jLabel5.setBackground(Color.orange);
				jLabel5.setForeground(Color.white);
				dispose();
				try {
					Client c = new Client();
					User u = c.register(jTextField1.getText(), String.valueOf(jPasswordField1.getPassword()));
					new NovelRegister().setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "服务器连接错误");
					e1.printStackTrace();
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getDefaultCursor());
//				jLabel5.setOpaque(false);
				jLabel5.setBackground(null);
				jLabel5.setForeground(a);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jLabel5.setOpaque(true);
				jLabel5.setBackground(Color.blue);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		jButton1.setBackground(new java.awt.Color(63, 161, 86));
		jButton1.setForeground(new java.awt.Color(0, 0, 0));
		jButton1.setText("\u767b\u9646");
		jButton1.setFocusable(false);
		jButton1.addMouseListener(new MouseListener() {
			Color a = new Color(63,161,86);
			Color b = new Color(79,202,108);
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				jButton1.setBackground(b);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				jButton1.setBackground(a);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getDefaultCursor());
				jButton1.setBackground(a);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				jButton1.setOpaque(true);
				jButton1.setBackground(b);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		//按钮事件监听
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					String account = jTextField1.getText();	
					String password = String.valueOf(jPasswordField1.getPassword());
					if(validate(account,password)){
						Client c = new Client();
						User u = c.login(jTextField1.getText(), String.valueOf(jPasswordField1.getPassword()));
						dispose();
						String nickname = getnickname(account);
						String sql = "select * from `test` where nickname = '"+nickname+"'";
						if(DB_Connect.getStatement().executeQuery(sql)!=null){
							ResultSet rs = (ResultSet) DB_Connect.getStatement().executeQuery(sql);
							while(rs.next()){
								String status = rs.getString(5);
								if(status.equals("2")){
									new Manger(nickname).setVisible(true);
									return;
								}
							}
						}
						String query = "select * from `sharing` where to_user = '"+nickname+"'";
						if(DB_Connect.getStatement().executeQuery(query)!=null){
							ResultSet rs = (ResultSet) DB_Connect.getStatement().executeQuery(query);
							while(rs.next()){
							String friend = rs.getString(2);
							String bookname = rs.getString(4);
							String content = rs.getString(5);
							share s = new share(nickname,friend,friend+"推荐你看下《"+bookname+"》，因为："+content);
							s.setVisible(true);
							return;
							}
						}
						else{
							
						}
						SelectBooks sb = new SelectBooks(nickname);
						sb.setVisible(true);
						sb.setTitle(getnickname(account)+GetHour.gethour());
					}
				else{
					JOptionPane.showMessageDialog(jFrame1,"无此账号信息");
				}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "服务器连接错误?");
					e.printStackTrace();
				} 
			}
		});
		

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(
																				jPanel4,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				jPanel1Layout
																						.createSequentialGroup()
																						.addGap(
																								87,
																								87,
																								87)
																						.addGroup(
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jPanel6,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												jPanel3,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												420,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				176,
																				176,
																				176)
																		.addComponent(
																				jCheckBox1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel5)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap(192, Short.MAX_VALUE)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												129,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(186, 186, 186)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												75,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jCheckBox1)
														.addComponent(jLabel5))
										.addGap(18, 18, 18)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												56,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(32, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 502,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try
	    {
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NovelLogin().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JFrame jFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}