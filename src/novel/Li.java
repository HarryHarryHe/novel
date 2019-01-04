package novel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

/**
 *
 * @author  __USER_
 */
public class Li extends javax.swing.JFrame{

	/** Creates new form С˵������ӻ� */
	public Li() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		this.setTitle("豆瓣阅读主界面");
		jPanel1 = new javax.swing.JPanel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
		jButton15 = new javax.swing.JButton();
		jButton16 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		Image img0 = new ImageIcon("src\\img\\zhanguoyexinjia.png").getImage().getScaledInstance
		(jLabel3.getWidth()+600, jLabel3.getHeight()+285, Image.SCALE_SMOOTH);
		jLabel3.setIcon(new ImageIcon(img0));
		
		Image img1 = new ImageIcon("src\\img\\woruochengxian.png").getImage().getScaledInstance
		(jLabel4.getWidth()+600,jLabel4.getHeight()+285, Image.SCALE_SMOOTH);
		jLabel4.setIcon(new ImageIcon(img1));
		
		Image img2 = new ImageIcon("src\\img\\3.0.png").getImage().getScaledInstance
		(jButton1.getWidth()+55,jButton1.getHeight()+55, Image.SCALE_SMOOTH);
		jButton1.setIcon(new ImageIcon(img2));

		
		Image img3 = new ImageIcon("src\\img\\2.1.png").getImage().getScaledInstance
		(jLabel2.getWidth()+322,jLabel2.getHeight()+55, Image.SCALE_SMOOTH);
		jLabel2.setIcon(new ImageIcon(img3));

		
		Image img4 = new ImageIcon("src\\img\\logo.png").getImage().getScaledInstance
		(jLabel1.getWidth()+322,jLabel1.getHeight()+100, Image.SCALE_SMOOTH);
		jLabel1.setIcon(new ImageIcon(img4));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/4.0.PNG"))); // NOI18N

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		jButton3.setBackground(new java.awt.Color(247, 246, 242));
		jButton3.setText("\u7384\u5e7b");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});

		jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});
		jButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});
		jButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});
		jButton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});
		jButton13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});
		jButton14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});
		jButton15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});
		jButton16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectBooks(null).setVisible(true);
			}
		});

		jButton4.setBackground(new java.awt.Color(247, 246, 242));
		jButton4.setText("\u6b66\u4fa0");
		
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovelLogin nl = new NovelLogin();
				nl.setVisible(true);
//				dispose();
				return;
			}
		});
		
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovelRegister nr = new NovelRegister();
//				dispose();
				nr.setVisible(true);
				return;
			}
		});

		jButton7.setBackground(new java.awt.Color(247, 246, 242));
		jButton7.setText("\u90fd\u5e02");

		jButton8.setBackground(new java.awt.Color(247, 246, 242));
		jButton8.setText("\u519b\u4e8b");

		jButton11.setBackground(new java.awt.Color(247, 246, 242));
		jButton11.setText("\u6587\u5b66");

		jButton12.setBackground(new java.awt.Color(247, 246, 242));
		jButton12.setText("\u6e38\u620f");

		jButton13.setBackground(new java.awt.Color(247, 246, 242));
		jButton13.setText("\u4f53\u80b2");

		jButton14.setBackground(new java.awt.Color(247, 246, 242));
		jButton14.setText("\u79d1\u5e7b");

		jButton15.setBackground(new java.awt.Color(247, 246, 242));
		jButton15.setText("\u7075\u5f02");

		jButton16.setBackground(new java.awt.Color(247, 246, 242));
		jButton16.setText("\u5973\u751f\u7f51");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jButton11,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton7,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton14,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton13,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton3,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								126,
																								Short.MAX_VALUE))
																		.addGap(
																				18,
																				18,
																				18)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jButton12,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton8,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton16,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton15,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton4,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								141,
																								Short.MAX_VALUE)))
														.addComponent(
																jLabel2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																322,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(25, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																47,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																49,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton8,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																49,
																Short.MAX_VALUE)
														.addComponent(
																jButton7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																49,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton12,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																46,
																Short.MAX_VALUE)
														.addComponent(
																jButton11,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																46,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton15,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																47,
																Short.MAX_VALUE)
														.addComponent(
																jButton13,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																47,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton16,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																51,
																Short.MAX_VALUE)
														.addComponent(
																jButton14,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																51,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		jButton5.setBackground(new java.awt.Color(255, 255, 255));
		jButton5.setText("\u767b\u5f55");

		jButton6.setBackground(new java.awt.Color(255, 255, 255));
		jButton6.setText("\u6ce8\u518c");

		jButton9.setBackground(new java.awt.Color(255, 255, 255));
		jButton9.setText("\u627e\u56de\u5bc6\u7801");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 598,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 280,
				Short.MAX_VALUE));

		jTabbedPane1.addTab("       \u6218\u56fd\u91ce\u5fc3\u5bb6       ",
				jPanel3);

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout.createSequentialGroup().addComponent(jLabel4,
						javax.swing.GroupLayout.PREFERRED_SIZE, 594,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 280,
				Short.MAX_VALUE));

		jTabbedPane1.addTab(
				"             \u6211\u82e5\u6210\u4ed9             ", jPanel4);
		
		//轮播
		Transform tr = new Transform();
		Thread th = new Thread(tr);
		th.start();

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
										.addGap(10, 10, 10)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				324,
																				Short.MAX_VALUE)
																		.addGap(
																				75,
																				75,
																				75)
																		.addComponent(
																				jTextField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				261,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jButton5))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(
																												30,
																												30,
																												30)
																										.addComponent(
																												jButton1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												56,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(
																				27,
																				27,
																				27)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jButton6)
																										.addGap(
																												30,
																												30,
																												30)
																										.addComponent(
																												jButton9))
																						.addComponent(
																								jButton2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								148,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
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
																				jTabbedPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				603,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(59, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
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
																		.createSequentialGroup()
																		.addGap(
																				7,
																				7,
																				7)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jButton5)
																						.addComponent(
																								jButton6)
																						.addComponent(
																								jButton9))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jButton1,
																												0,
																												0,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												jButton2,
																												0,
																												0,
																												Short.MAX_VALUE)
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												42,
																												Short.MAX_VALUE))))
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																87,
																Short.MAX_VALUE))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				35,
																				35,
																				35)
																		.addComponent(
																				jTabbedPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				314,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				9,
																				9,
																				9)
																		.addComponent(
																				jPanel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));

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
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		final Socket s = new Socket();
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Li().setVisible(true);
			}
		});
	}
	class Transform implements Runnable{
		@Override
		public void run() {
			boolean i = true;
			while(true){
				try {
					Thread.sleep(2000);
					if(i){
						jTabbedPane1.setSelectedComponent(jPanel4);
						i = false;
					}
					else{
						jTabbedPane1.setSelectedComponent(jPanel3);
						i = true;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton16;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables
	

}