package check_code;

import java.util.Random;

public class CheckCode {
	public static String getRandomCode(int number){	
		String codeNum = "";		
		int [] code = new int[3];	
		Random random = new Random();	
		for (int i = 0; i < number; i++) {	
//			�����֣�Сд��ĸ����д��ĸ��ȡһ������������֤���һλ
//			random.nextint�÷���������������һ�������intֵ����ֵ����[0,n)�����䣬Ҳ����0��n֮������intֵ������0��������n
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
