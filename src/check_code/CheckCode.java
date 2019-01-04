package check_code;

import java.util.Random;

public class CheckCode {
	public static String getRandomCode(int number){	
		String codeNum = "";		
		int [] code = new int[3];	
		Random random = new Random();	
		for (int i = 0; i < number; i++) {	
//			从数字，小写字母，大写字母抽取一个出来当成验证码的一位
//			random.nextint该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n
			int num = random.nextInt(10) + 48;	
			int uppercase = random.nextInt(26) + 65;	
			int lowercase = random.nextInt(26) + 97;	
			code[0] = num;			
			code[1] = uppercase;		
			code[2] = lowercase;		
			codeNum+=" "+(char)code[random.nextInt(3)]+" ";	
		}		
		return codeNum;
	}
//	public static void main(String[] args) {
//		getRandomCode(4);
//	}
}
