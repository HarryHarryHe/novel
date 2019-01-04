package novel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Server extends Thread{

	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	final int LOGIN = 1001;
	final int REGISTER = 1002;
	final int MARK = 1003;
	final int MODIFY = 1004;
	final int UPLOAD = 1005;
	final int MARK_AUTHOR = 1006;
	
	public Server(Socket s){
		super();
		this.s = s;
	}
	
	public void run() {
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			int command = ois.readInt();
			if (command == LOGIN) {
				login();
			}
			if (command == REGISTER) {
				register();
			}
			if (command == MARK) {
				mark();
			}
			if (command == MODIFY) {
				modify();
			}
			if (command == UPLOAD) {
				UploadF();
			}
			if (command == MARK_AUTHOR) {
				mark_author();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void login() throws IOException{
		JOptionPane.showMessageDialog(null, "欢迎光临豆瓣读书");
		String account = ois.readUTF();
		String password = ois.readUTF();
		User u = null;
		u = new User(account, password);
		oos.writeObject(u);
		oos.flush();
	}
	public void register() throws IOException{
		JOptionPane.showMessageDialog(null, "感谢您来到注册界面");
		String account = ois.readUTF();
		String password = ois.readUTF();
		User u = null;
		u = new User(account, password);
		oos.writeObject(u);
		oos.flush();
	}
	public void mark() throws IOException{
		String nickname = ois.readUTF();
		String bookname = ois.readUTF();
		String query = "select * from `like_book` where user_id = '"+nickname+"'";
		String likebook = "";
		try {
			ResultSet rs = DB_Connect.getStatement().executeQuery(query);
			while(rs.next()){
				likebook = rs.getString(3);
			}
			if(likebook.equals("")){
				String sql = "insert into like_book(user_id,book_id) values('"+bookname+"','"+nickname+"')";
				DB_Connect.getStatement().executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "收藏成功");
			}
			else{
				if(likebook.contains(bookname)){
					JOptionPane.showMessageDialog(null, "您已经收藏过这本书了噢");
				}
				else{
					String all_like = likebook+","+bookname;
					String append_book = "update `like_book` set book_id='"+all_like+"' where user_id = '"+nickname+"'";
					DB_Connect.getStatement().executeUpdate(append_book);
					JOptionPane.showMessageDialog(null, "收藏成功");
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void mark_author() throws IOException{
		String nickname = ois.readUTF();
		String author = ois.readUTF();
		String query = "select * from `like_author` where nickname = '"+nickname+"'";
		String likeauthor = "";
		try {
			ResultSet rs = DB_Connect.getStatement().executeQuery(query);
			while(rs.next()){
				likeauthor = rs.getString(3);
			}
			if(likeauthor.equals("")){
				String sql = "insert into like_author(nickname,author) values('"+nickname+"','"+author+"')";
				DB_Connect.getStatement().executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "作者：'"+author+"'，关注成功");
			}
			else{
				if(likeauthor.contains(author)){
					JOptionPane.showMessageDialog(null, "您已经关注过这个作者了噢");
				}
				else{
					String all_like = likeauthor+","+author;
					String append_book = "update `like_author` set author='"+author+"' where nickname = '"+nickname+"'";
					DB_Connect.getStatement().executeUpdate(append_book);
					JOptionPane.showMessageDialog(null, "作者：'"+author+"'，关注成功");
				}
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "关注失败");
			e1.printStackTrace();
		}
	}
	public void modify(){
		try {
			String book_id = ois.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void UploadF() throws IOException {
		File f = new File("E:\\" + s.getInetAddress() + ".jpg");
		FileOutputStream fos = new FileOutputStream(f);
		InputStream is = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = is.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		fos.close();
	}
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10086);
			while(true){
				Socket s = ss.accept();
				new Server(s).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
