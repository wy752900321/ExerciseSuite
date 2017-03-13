package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * 登陆界面是一具体窗口框
 * 单例设计：一类只设计一个对象来使用的原则 
 */
public class LoginFrame extends JFrame{

	private static final long serialVersionUID = -7993721800179709451L;
	public LoginFrame(){
		init();
	}
	/**初始化界面组件和布局的*/
	private void init(){
		this.setTitle("登录系统");//设置标题栏
		JPanel contentPane = createContentPane();//创建内容面板，frame中间的大面板
		this.setContentPane(contentPane);//放在窗口上。this是contentPane.
		setLocationRelativeTo(null);//居中
		setSize(270,288);
	}
	private JPanel createContentPane(){
		JPanel p = new JPanel(new BorderLayout());//创建具有指定布局管理器的新缓冲 JPanel。
		//EmptyBorder(int top, int left, int bottom, int right)创建具有指定 insets 的空边框
		p.setBorder(new EmptyBorder(8,8,8,8));//设置边框
		p.add(BorderLayout.NORTH, new JLabel("登陆考试系统",JLabel.CENTER));
		p.add(BorderLayout.CENTER, createCenterPane());
		p.add(BorderLayout.SOUTH,createBtnPane());
		return p;
	}
	private JPanel createBtnPane(){
		JPanel p = new JPanel(new FlowLayout());
		JButton login = new JButton("Login"); //登陆
		JButton cancel = new JButton("Cancel");
		
		getRootPane().setDefaultButton(login);//设置默认回车按纽
		
		p.add(login);
		p.add(cancel);
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				 //System.out.println("click login button");
				clientContext.login();
			}
		});
		return p;
	}
	private JPanel createCenterPane(){
		JPanel p = new JPanel(new BorderLayout());
		p.add(BorderLayout.NORTH,createIdPwdPane());
		return p;
	}
	private JPanel createIdPwdPane(){
		JPanel p = new JPanel(new GridLayout(2,1));//表格布局,两行一列
		p.add(createIdPane());
		p.add(createPwdPane());
		return p;
	}
	private JPanel createIdPane(){//创建编号输入框
		JPanel p = new JPanel(new BorderLayout(6,0));
		p.add(BorderLayout.WEST,new JLabel("编号："));
		JTextField idField  = new JTextField();
		p.add(BorderLayout.CENTER,idField);
		//实例变量idField引用到界面控件上
		this.idField = idField;//把界面上的输入，引入到....
		idField.enableInputMethods(true);//Linux bug
		p.add(BorderLayout.CENTER,idField);
		return p;
	}
	/**
	 * 简单工厂方法，封装的复杂对象的创建过程，返回一个对象实例
	 */
	private JPanel createPwdPane(){
		JPanel p = new JPanel(new BorderLayout(6,0));
		p.add(BorderLayout.WEST,new JLabel("密码："));
		JPasswordField pwdField = new JPasswordField();
		pwdField.enableInputMethods(true);//允许输入法
		p.add(BorderLayout.CENTER,pwdField);
		this.pwdField = pwdField;//引入到控制器
		pwdField.enableInputMethods(true);//Linux bug
		p.add(BorderLayout.CENTER,pwdField);
		return p;
	}
	private JPanel createBottomPane(){
		JPanel p = new JPanel(new FlowLayout());
		JButton login = new JButton("登录");
		JButton cancel = new JButton("取消");
		p.add(login);
		p.add(cancel);
		login.addActionListener(new ActionListener(){
		 /**当按钮对象被点击时候, 会执行方法actionPerformed()
		   ActionListener监听login按钮何时被点击 
		   ActionEvent e 是按钮点击的时候, 场景信息(点击位置)
		   点击了那个对象(那个按钮)等
		  */
			public void actionPerformed(ActionEvent e) {
			/**
			 	System.out.println("点击了Login"+e.getWhen());
        		访问控制器提供的登录方法, 完成登录流程
        		clientContext.login()依赖ClientContext实例
			 */
				clientContext.login();
			}
		});
		return p;
	}
	//...........
	/**ClientContext:客户端上下文，作为客户端界面控制器*/
	ClientContext clientContext;
	public void setClientContext(ClientContext clientContext){
	    //clientContext的实例通过setClientContext()注入到
	    //当前对象的属性this.clientContext中
	    //依赖注入: IOC
		this.clientContext = clientContext;
	}
	private JTextField idField;
	private JPasswordField pwdField;
	private JLabel message;
	public int getUserId(){
		return Integer.parseInt(idField.getText());
	}
	public String getPassword(){
		char[] pwd = pwdField.getPassword();//为安全，sun规定返回char类型
	    return new String(pwd);//转换成字符串
	    //return new String(pwdField.getPassword());//上面两句简写
	}
	public void showMessage(String message){
		this.message.setText(message);
	}
}
