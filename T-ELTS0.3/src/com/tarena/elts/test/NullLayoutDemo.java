package com.tarena.elts.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NullLayoutDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("自定义布局演示");
		JPanel panel = new JPanel();
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		frame.setSize(464,321);
		//清除默认布局管理,让用户自己管理,自定义布局。组件的位置和大小
		panel.setLayout(null);//layout:布局，null：没有。
		ok.setLocation(291, 262);//(X,Y)
		ok.setSize(76, 23);//宽，高
		cancel.setLocation(371, 262);
		cancel.setSize(76, 23);
		panel.add(ok);
		panel.add(cancel);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}