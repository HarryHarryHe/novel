package rand_color;

import java.awt.Color;
import java.util.Random;

public class RandColor {
	public static Color randomColor(){
		Random random = new Random();
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		return new Color(r,g,b);
	}
}
