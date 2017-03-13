package com.friend.system.manger.cn.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
public class CheckUtil {
	private static final char[] disappear={'9','g','z','2','Z','0','o','O','l','1'};
	private static final int term1=48;
	private static final int term2=57;
	private static final int term3=65;
	private static final int term4=75;
	private static final int term5=90;
	private static final int term6=97;
	private static  int count=6;
	private static  int width=60;
	private static  int height=20;
	
	public static BufferedImage getCheckImage(String check){
		return getCheckImage(check, width, height);
	}
	public static BufferedImage getCheckImage(String check,int width,int height){
		CheckUtil.width = width;
		CheckUtil.height = height;
		int x =width/12;
		int y = height/4*3;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		Random random = new Random();
		graphics.setColor(new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255)));
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.black);
		Font font = graphics.getFont();
		font.deriveFont(Font.BOLD);
		font.deriveFont(Font.TYPE1_FONT);
		graphics.setFont(font);
		graphics.drawString(check, x, y);
		graphics.setColor(Color.BLUE);
		int n = count/2;
		for (int i = 0; i < n; i++) {
			graphics.drawLine(random.nextInt(width), random.nextInt(height), random
					.nextInt(width), random.nextInt(height));
		}
		return image;
	}
	public static String getCheckCode(){
		return getCheckCode(count);
	}
	public static String getCheckCode(int count){
		CheckUtil.count = count;
		String result = "";
		StringBuilder builder = new StringBuilder();
		while(true){
			char ch = getChar();
			if(contain(ch)){
				continue;
			}
			if(builder.toString().matches(ch+"")){
				continue;
			}
			builder.append(ch);
			if(builder.length()==count){
				break;
			}
		}
		result = builder.toString();
		return result;
	}
	private static boolean contain(char ch) {
		for (char str : disappear) {
			if(str==ch){
				return true;
			}
		}
		return false;
	}
	private static char getChar() {
		char ch=' ';
		int data = 0;
		Random random = new Random();
		while(true){
			data = random.nextInt(term4)+term1;
			if(data>term2&&data<term3){
				continue;
			}
			else if(data>term5&&data<term6){
				continue;
			}
			else{
				ch=(char)data;
				break;
			}
		}
		return ch;
	}
}
