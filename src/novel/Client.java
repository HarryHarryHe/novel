package novel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	final int LOGIN = 1001;
	final int REGISTER = 1002;
	final int MARK = 1003;
	final int MODIFY = 1004;
	final int UPLOAD = 1005;
	final int MARK_AUTHOR = 1006;
	Socket s = null;

	public Client() throws IOException{

		s = new Socket("localhost", 10086);

		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}

	public User login(String account, String psw) throws IOException,
			ClassNotFoundException {
		oos.writeInt(LOGIN);
		oos.flush();
		oos.writeUTF(account);
		oos.flush();
		oos.writeUTF(psw);
		oos.flush();
		return (User) ois.readObject();
	}

	public User register(String account, String psw) throws IOException,
			ClassNotFoundException {
		oos.writeInt(REGISTER);
		oos.flush();
		oos.writeUTF(account);
		oos.flush();
		oos.writeUTF(psw);
		oos.flush();
		return (User) ois.readObject();
	}
	public User mark(String nickname,String bookname) throws IOException, ClassNotFoundException{
		
		oos.writeInt(MARK);
		oos.flush();
		oos.writeUTF(nickname);
		oos.flush();
		oos.writeUTF(bookname);
		oos.flush();
		return null;
	}
	public User mark_author(String nickname,String author) throws IOException, ClassNotFoundException{
		
		oos.writeInt(MARK_AUTHOR);
		oos.flush();
		oos.writeUTF(nickname);
		oos.flush();
		oos.writeUTF(author);
		oos.flush();
		return null;
	}
	public User modify(String book_id) throws IOException{
		oos.writeInt(MODIFY);
		oos.flush();
		oos.writeUTF(book_id);
		oos.flush();
		return null;
	}
	public void uploadFile(File f) throws IOException {
		oos.writeInt(UPLOAD);
		oos.flush();
		FileInputStream fis = new FileInputStream(f);

		OutputStream os = s.getOutputStream();

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		s.shutdownOutput();
	}
}
