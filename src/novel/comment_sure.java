package novel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * 
 * @author __USER__
 */
public class comment_sure extends javax.swing.JFrame {

	static String bookname = null;
	static String nickname = null;

	/** Creates new form comment_sure */
	public comment_sure(String bookname, String nickname) {
		initComponents(bookname, nickname);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents(final String bookname, final String nickname) {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
		jLabel1.setText("\u53d1\u8868\u7559\u8a00");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);
		jTextArea1.setLineWrap(true);

		jButton1.setText("\u7acb\u5373\u53d1\u5e03");
		jButton1.addActionListener(new ActionListener() {
			String status = null;

			public void actionPerformed(ActionEvent e) {
				int selected = JOptionPane.showConfirmDialog(null, "确认发表留言吗？",
						"请确认", JOptionPane.YES_NO_OPTION);
				if (selected == 1) {
					return;
				}
				if (selected == 0) {
					String content = jTextArea1.getText();
					if (content.replaceAll(" ", "").equals("")) {
						JOptionPane.showMessageDialog(null, "留言内容不能为空!");
						return;
					}

					String query = "select * from test where nickname = '"
							+ nickname + "'";
					try {
						ResultSet rs = DB_Connect.getStatement().executeQuery(
								query);
						while (rs.next()) {
							status = rs.getString(5);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (status.equals("0")) {
						status = "读者";
					}
					else if (status.equals("1")) {
						status = "作者";
					} else {
						status = "未知";
					}
					System.out.println(status);

					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String time = String.valueOf(dateFormat.format(date));
					String sql = "insert into comment(book_name,user,status,content,time) values ('"
							+ bookname
							+ "','"
							+ nickname
							+ "','"
							+ status
							+ "','" + content + "','" + time + "') ";
					try {
						DB_Connect.getStatement().executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "发表成功!");
						dispose();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "发布失败...");
						e1.printStackTrace();
					}
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
										.addGap(30, 30, 30)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jButton1)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																349,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addGap(
																				277,
																				277,
																				277)))
										.addContainerGap(30, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(18, 18, 18)
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												185,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(
												jButton1).addContainerGap(24,
												Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new comment_sure(bookname, nickname).setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	// End of variables declaration//GEN-END:variables

}