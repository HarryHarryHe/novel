package novel;

import java.awt.Color;

import javax.swing.*;
@SuppressWarnings("serial")
public   class   countdown  extends   JFrame 
{ 
	JButton button; 
	JPanel panel; 
	{ 
		//去窗体框，关闭，最大化，最小化
		this.setUndecorated(true);
		
		button=new JButton(); 
		button.setFocusable(false);
		button.setOpaque(true);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		panel=new JPanel(); 
		add(panel); 
		panel.add(button); 
		setSize(170,50); 
		setVisible(true); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ButtonAction tt=new ButtonAction(); 
		tt.run(); 
} 
class ButtonAction extends Thread 
{ 
	int i=5; 
	public void run() //线程在此开始执行
	{ 
		while(i!=0) 
		{ 
			try 
				{ 
					sleep(1000);	
					button.setText( "正在跳转至登陆页: " +i); 
					i--; 
				} 
			catch(Exception   eee) {
				System.out.println("fail");
			} 
		}		 
		if(i==0) 
		{ 
			dispose();
//			JOptionPane.showMessageDialog(null, " 时间到！");	
		} 
	}	
} 
public static void main(String   args[]) 
{ 
	JFrame frm = new countdown();
	frm.dispose();
	System.exit(0);
} 
}