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
		// 保存结果
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream(), Charset.forName(charset)));
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				sb.append(temp);
				sb.append('\n');
				// 网页
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

	// 链接url下载图片
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
			System.out.println("下载完成");
			dataInputStream.close();
			fileOutputStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//最后一个参数如果是0则文件以追加的方式写入，若为1，则函数以覆盖的方式写入，为其它提醒出错
	public static void writetxt(String content, String folder, int i, int j) {
		FileOutputStream fop = null;
		File file;
		FileWriter fw = null;
		PrintWriter pw = null;

		if(j==0||j==1) {
			try {
				// myeclipse的位置
//				 file = new File("D:\\MyEclipseWorkspaces\\NovelBuilder\\src\\"+folder+"\\"+i+".txt");
				
				// eclipse的位置
				file = new File("D:\\Eclipse-workspace\\正则表达式\\src\\" + folder + "\\" + i + ".txt");

				// 用到追加的时候把关于它的注释掉了
				 if(j==1) {
					 fop = new FileOutputStream(file);		 
				 }


				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// 下载书籍信息要用到的追加方法 FileWriter(File file, boolean append)
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

				System.out.println("写入文件成功");

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
			System.out.println("最后一个参数填写不恰当,0为追加，1为覆盖!");
		}
		
	}

	/***
	 * 获得封面与书籍简介
	 * 
	 * 获得书名title=.*>(.*)</a>
	 * 获得书本简介地址在在那地址爬取相关信息 </span>(.+)<br/>
	 * 匹配到七处相关信息 缺少a标签的其它3个信息 作者.*\s*<a.*href=".* /.*">.*</a>匹配作者的名字
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
//			 这下边是下载的代码，不用时最好注释掉
			 System.out.println("正在下载："+result1.get(i));
			 downloadPicture(result1.get(i),
			 "D:\\MyEclipseWorkspaces\\NovelBuilder\\src\\img\\"+i+".jpg");
			 writetxt("  "+result2.get(i).trim(),"content",i, 1);
		}
		
		int i = 0;
		for (String temp : result) {

			rs = getMatcherSubstrs(getURLContent(temp, "utf8"), "</span>(.+)<br/>");
			res = getMatcherSubstrs(getURLContent(temp, "utf8"), "作者.*\\s*<a.*href=\".*/.*\">(.*)</a>");
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
