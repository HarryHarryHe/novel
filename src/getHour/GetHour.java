package getHour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetHour {
	public static String gethour(){
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("HH");
		int t = Integer.parseInt(dateFormat.format(date));
		if(5<t&&12>t){
			return ",早上好,又是元气满满的一天呢";
		}
		else if(12<=t&&18>t){
			return ",中午好,时间段很适合读书呢";
		}
		else if(18<=t&&23>=t){
			return ",晚上好,记得别读太晚噢";
		}
		else{
			return "时间不早了,尽早休息噢";
		}
	}
}
