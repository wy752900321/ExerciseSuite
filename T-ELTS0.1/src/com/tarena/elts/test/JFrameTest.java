package com.tarena.elts.test;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**Frame  picture.jpg
 * 图片加载测试
 */
public class JFrameTest {
	public static void main(String[] args) {
		//从package中加载资源(image,text...,等)
		//JFrameTest.class与picture.jpg在同一个包里面
		URL url = JFrameTest.class.getResource("picture.jpg");//URL资源定位.getResource找到同一个包中的资源
		//也可以使用绝对的package路径加载资源,可以在系统中任意的地方：如：
		//ImageIcon(URL location)根据指定的 URL 创建一个 ImageIcon。
//		URL url = JFrameTest.class.getResource("/com/tarena/elts/test/picture.jpg");
		ImageIcon ico = new ImageIcon(url);
		JFrame frame = new JFrame("测试图片加载");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(ico);
		panel.add(label);
		frame.setContentPane(panel);
		frame.setSize(300,200);
		frame.setVisible(true);
	}
}
