package web_spider;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpider {

	public static String getURLContent(String urlStr, String charset) {
		// ������
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream(), Charset.forName(charset)));
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				sb.append(temp);
				sb.append('\n');
				// ��ҳ
				// System.out.println(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static List<String> getMatcherSubstrs(String WebURL, String regexStr) {
		Pattern p = Pattern.compile(regexStr);
		Matcher m = p.matcher(WebURL);
		List<String> result = new ArrayList<String>();
		while (m.find()) {
			result.add(m.group(1));
		}
		return result;
	}

	// ����url����ͼƬ
	private static void downloadPicture(String urlList, String path) {
		URL url = null;
		try {
			url = new URL(urlList);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());

			FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			fileOutputStream.write(output.toByteArray());
			System.out.println("�������");
			dataInputStream.close();
			fileOutputStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//���һ�����������0���ļ���׷�ӵķ�ʽд�룬��Ϊ1�������Ը��ǵķ�ʽд�룬Ϊ�������ѳ���
	public static void writetxt(String content, String folder, int i, int j) {
		FileOutputStream fop = null;
		File file;
		FileWriter fw = null;
		PrintWriter pw = null;

		if(j==0||j==1) {
			try {
				// myeclipse��λ��
//				 file = new File("D:\\MyEclipseWorkspaces\\NovelBuilder\\src\\"+folder+"\\"+i+".txt");
				
				// eclipse��λ��
				file = new File("D:\\Eclipse-workspace\\������ʽ\\src\\" + folder + "\\" + i + ".txt");

				// �õ�׷�ӵ�ʱ��ѹ�������ע�͵���
				 if(j==1) {
					 fop = new FileOutputStream(file);		 
				 }


				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// �����鼮��ϢҪ�õ���׷�ӷ��� FileWriter(File file, boolean append)
				if(j==0) {
					fw = new FileWriter(file, true);
					pw = new PrintWriter(fw);
					pw.println(content);
					pw.flush();
				}
				

				// get the content in bytes
				if(j==1) {
					byte[] contentInBytes = content.getBytes();
					fop.write(contentInBytes);
					fop.flush();
					fop.close();
				}

				System.out.println("д���ļ��ɹ�");

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fop != null) {
						fop.close();
					}
					if (fw != null) {
						fw.close();
					}
					if (pw != null) {
						pw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			System.out.println("���һ��������д��ǡ��,0Ϊ׷�ӣ�1Ϊ����!");
		}
		
	}

	/***
	 * ��÷������鼮���
	 * 
	 * �������title=.*>(.*)</a>
	 * ����鱾����ַ�����ǵ�ַ��ȡ�����Ϣ </span>(.+)<br/>
	 * ƥ�䵽�ߴ������Ϣ ȱ��a��ǩ������3����Ϣ ����.*\s*<a.*href=".* /.*">.*</a>ƥ�����ߵ�����
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		String url = getURLContent("https://book.douban.com/", "utf8");
		List<String> result = getMatcherSubstrs(url, "<a class=\"\" href=\\\"(.*)\\\"\\s.*=\\\"(.*)\\\"");
		List<String> rs = null;
		List<String> res = null;
		List<String> r = null;
		
		List<String> result1 = getMatcherSubstrs(url,"src=\"(.*.jpg)");
		 List<String> result2 = getMatcherSubstrs(url,"<p class=\"ab.*>((\\s.*){0,10})</p>");
		 for(int i=0;i<result1.size();i++) {
			 if(i == result2.size()) {
				 break;
			 }
//			 ���±������صĴ��룬����ʱ���ע�͵�
			 System.out.println("�������أ�"+result1.get(i));
			 downloadPicture(result1.get(i),
			 "D:\\MyEclipseWorkspaces\\NovelBuilder\\src\\img\\"+i+".jpg");
			 writetxt("  "+result2.get(i).trim(),"content",i, 1);
		}
		
		int i = 0;
		for (String temp : result) {

			rs = getMatcherSubstrs(getURLContent(temp, "utf8"), "</span>(.+)<br/>");
			res = getMatcherSubstrs(getURLContent(temp, "utf8"), "����.*\\s*<a.*href=\".*/.*\">(.*)</a>");
			r = getMatcherSubstrs(getURLContent(temp, "utf8") , "<span property=\"v:itemreviewed\">(.*)</span>");
			for(String temp1 : r) {
				System.out.print("temp1:");
				writetxt(temp1, "infos", i, 0);
			}
			for (String temp2 : res) {
				System.out.print("temp2:");
				writetxt(temp2, "infos", i, 0);
			}
			for (String temp3 : rs) {
				System.out.println("temp3:");
				writetxt(temp3, "infos", i, 0);
			}
			i++;
			System.out.println("--------------------");
		}
	}

}
