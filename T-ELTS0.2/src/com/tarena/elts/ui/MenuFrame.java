package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;

public class MenuFrame extends JFrame {

	private static final long serialVersionUID = -4133538643155019229L;

	public MenuFrame() {
		init();
	}

	private void init() {
		setTitle("达内在线评测");
		setSize(600, 400);
		setContentPane(createContentPane());
		setLocationRelativeTo(null);// 居中
	}

	private JPanel createContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(this.getClass().getResource("title.png"));// 图片加载:
		pane.add(BorderLayout.NORTH, new JLabel(icon));
		pane.add(BorderLayout.CENTER, createMenuPane());

		pane.add(BorderLayout.SOUTH,
				new JLabel("达内科技--版权所有 盗版必究", JLabel.RIGHT));
		return pane;
	}

	public JPanel createMenuPane() {
		JPanel pane = new JPanel(new BorderLayout());
		// 务必将info 引用到界面控件对象
		JLabel info = new JLabel("贾东坡 同学 您好", JLabel.CENTER);
		this.info=info;//局部变量升级为成员属性
		pane.add(BorderLayout.NORTH, info);
		pane.add(BorderLayout.CENTER, createBtnPane());
		
		return pane;
	}

	public JPanel createBtnPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton start = createImgBtn("exam.png", "开始");
		JButton result = createImgBtn("result.png", "查看成绩");
		JButton message = createImgBtn("message.png", "考试规则");
		JButton exit = createImgBtn("exit.png", "离开");

		pane.add(start);
		pane.add(result);
		pane.add(message);
		pane.add(exit);
		// 通过此接口获得所有其他方法
		// setDefaultButton(JButton) 设置 defaultButton 属性，它确定此 JRootPane 的当前默认按钮。
		getRootPane().setDefaultButton(start);
		
	
		return pane;
	}
	
	

	// 创建图片按钮的方法
	private JButton createImgBtn(String img, String txt) {
		ImageIcon icon = new ImageIcon(this.getClass().getResource(img));
		/**JButton
				public JButton(String text,Icon icon)
    					创建一个带初始文本和图标的按钮。
    				参数：
        			text - 按钮的文本
        			icon - 显示在按钮上的 Icon 图像
		 */
		JButton button = new JButton(txt, icon);
		button.setVerticalTextPosition(JButton.BOTTOM);// 垂直文本对齐位置
		button.setHorizontalTextPosition(JButton.CENTER);// 水平文本对齐位置
		return button;
	}

	/**
	 *  8) 为MenuFrame界面增加更新用户信息的方法 updateView
  			务必将info 引用到界面控件对象
  			private JLabel info;
  			public void updateView(User user) {
    				String str = "欢迎 "+user+" 参加杀手考试!";
    				info.setText(str);
	  		}
	 */
	private JLabel info;//局部变量升级为成员属性
	public void updateView(User user) {
		String str ="欢迎 " +user+" 参加杀手考试！";
		info.setText(str);
	}
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContxt){
		this.clientContext = clientContext;
	}

}
