package com.tarena.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 此类为生成图片的工具类
 * 
 * @author soft01
 * 
 */
public class ImageUtil implements Serializable {
	private static final long serialVersionUID = -8309498246462328056L;
	// 定义图片上的字符
	private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
			"X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z" };
	// 图片上的字符个数
	private static final int SIZE = 4;
	// 图片上线的条数
	private static final int LINES = 10;
	// 图片的宽度
	private static final int WIDTH = 300;
	// 图片的高度
	private static final int HEIGHT = 100;
	// 图片上字符的字体
	private static final int FONT_SIZE = 60;

	/**
	 * 创建图片的方法
	 * 
	 * @return 返回一个含有字符和图片缓冲流的Map集合
	 */
	public static Map<String, BufferedImage> createImage() {
		StringBuffer sb = new StringBuffer();
		BufferedImage img = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = img.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		Random random = new Random();
		// 画随机字符
		for (int i = 1; i <= SIZE; i++) {
			int ran = random.nextInt(chars.length);
			graphics.setColor(getRandomColor());
			graphics
					.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			graphics.drawString(chars[ran], (i - 1) * WIDTH / SIZE, HEIGHT / 2);
			// 将字符保存，存入Session
			sb.append(chars[ran]);
		}
		// 画干扰线
		for (int i = 1; i <= LINES; i++) {
			graphics.setColor(getRandomColor());
			graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
					random.nextInt(WIDTH), random.nextInt(HEIGHT));
		}
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		map.put(sb.toString(), img);
		return map;
	}

	/**
	 * 获取随机颜色
	 * 
	 * @return
	 */
	private static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran
				.nextInt(256));
		return color;
	}

	// public static void main(String[] args) {
	// Map<String, BufferedImage> map = createImage();
	// System.out.println(map.size());
	// }
}
