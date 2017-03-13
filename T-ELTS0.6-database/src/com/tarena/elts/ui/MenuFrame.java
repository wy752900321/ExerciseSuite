package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;
//import com.tarena.elts.util.Config;

/** 主菜单界面 */
public class MenuFrame extends JFrame {
	
	private static final long serialVersionUID = -1796834130339697339L;
	
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}
	
	public MenuFrame() {
		init();
	}

	/** 初始化界面组件和布局 */
	private void init() {//
		setLocationRelativeTo(null);
		this.setTitle("达内在线评测");
		// JPanel contentPane = createContentPane();
		// this.setContentPane(contentPane);
		
		this.setContentPane(createContentPane());
		this.setSize(600, 400);
		//this.setVisible(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				//e.getOldState();//e 以前的状态
				clientContext.exit(MenuFrame.this);
			}
		});
	}

	private JPanel createContentPane() {
		JPanel p = new JPanel(new BorderLayout());

		ImageIcon ico = new ImageIcon(this.getClass().getResource("title.png"));
		// MunuFrame.class.getResource("title.png");
		// p.setBorder(new EmptyBorder(8,8,8,8));
		p.add(BorderLayout.NORTH, new JLabel(ico));
		p.add(BorderLayout.CENTER, createCenterPane());
		p.add(BorderLayout.SOUTH,
				new JLabel("版权所有，盗版必杀！达内科技2012", JLabel.RIGHT));
		return p;
	}

	private JPanel createCenterPane() {
		JPanel p = new JPanel(new BorderLayout());
		// 务必将info 引用到界面控件对象
		//p.add(BorderLayout.NORTH, new JLabel("欢迎：聂云云 同学", JLabel.CENTER));
	    info = new JLabel("欢迎:XXX 同学你好！",JLabel.CENTER);
		p.add(BorderLayout.NORTH,info);
		p.add(BorderLayout.CENTER, createBtnPane());
		return p;
	}

	private JPanel createBtnPane() {
		JPanel p = new JPanel(new FlowLayout());

		JButton start = createImgBtn("exam.png", "开始");
		JButton result = createImgBtn("result.png", "考试成绩");
		JButton msg = createImgBtn("message.png", "考试规则");
		JButton exit = createImgBtn("exit.png", "离开");

		getRootPane().setDefaultButton(start);//回车的默认按钮
		
		p.add(start);
		p.add(result);
		p.add(msg);
		p.add(exit);
		
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.start();
			}
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//System.out.println("clsi");
				clientContext.exit(MenuFrame.this);
			}
		});
		result.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//e 代表发生了什么
				//long clickTime = e.getWhen();//获得事情发生时间
				clientContext.result();
			}
		});
		msg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.msg();
			}
		});

		return p;
	}

	/** 创建图片按钮的方法 */
	private JButton createImgBtn(String img, String txt) {
		ImageIcon ico = new ImageIcon(this.getClass().getResource(img));
		JButton button = new JButton(txt, ico);
		//button.setIcon(ico);
		//垂直文本对齐位置
		button.setVerticalTextPosition(JButton.BOTTOM);
		//水平文本对齐位置
		button.setHorizontalTextPosition(JButton.CENTER);
		return button;
	}
	private JLabel info;
	
	public void updateView(User user) {
		info.setText("你好： "+user+" 小童鞋，欢迎进入考试系统 ");
	}
}
