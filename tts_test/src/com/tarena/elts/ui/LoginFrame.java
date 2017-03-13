package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = -7212047455701630527L;
	//登陆界面
	public LoginFrame(){
		init();
	}
	//初始化界面组件和布局
	private void init(){
		this.setTitle("登录系统");
		JPanel contentPane = createContentPane();
		this.setContentPane(contentPane);
		setSize(270,188);
		setLocationRelativeTo(null);//居中
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				clientContext.exit(LoginFrame.this);
			}
		});
	}
	private JPanel createContentPane(){
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(8,8,8,8));
		p.add(BorderLayout.NORTH,new JLabel("登陆考试系统",JLabel.CENTER));
		p.add(BorderLayout.CENTER,createCenterPane());
		p.add(BorderLayout.SOUTH,createBtnPane());
		return p;
	}
	private JPanel createBtnPane(){
		JPanel p = new JPanel(new FlowLayout());
		JButton login = new JButton("Login");
		JButton cancel = new JButton("Cancel");
		
		getRootPane().setDefaultButton(login);
		
		p.add(login);
		p.add(cancel);
		
		 //1)增加LoginFrame界面登录事件响应代码:
			    login.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent e) {
			        clientContext.login();//将请求转发给控制器
			      }
			    });
			    cancel.addActionListener(new ActionListener(){
			    	public void actionPerformed(ActionEvent e){
			    		clientContext.exit(LoginFrame.this);
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
		JPanel p = new JPanel(new GridLayout(2,1));//表格布局，两行一列
		p.add(createIdPane());
		p.add(createPwdPane());
		return p;
	}
	private JPanel createIdPane(){
		JPanel p = new JPanel(new BorderLayout(6,0));
		p.add(BorderLayout.WEST,new JLabel("编号："));
		JTextField idField = new JTextField();
		p.add(BorderLayout.CENTER,idField);
		this.idField = idField;
		idField.enableInputMethods(true);//linux bug
		return p;
	}
	private JPanel createPwdPane(){
		JPanel p = new JPanel(new BorderLayout(6,0));
		p.add(BorderLayout.WEST,new JLabel("密码："));
		JPasswordField pwdField = new JPasswordField();
		this.pwdField = pwdField;
		pwdField.enableInputMethods(true);//允许输入法
		p.add(BorderLayout.CENTER,pwdField);
		pwdField.enableInputMethods(true);
		return p;
	}
	ClientContext clientContext;
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}
	//JTextField 是一个轻量级组件，它允许编辑单行文本
	//public String getText()
	//getText返回此 TextComponent 中包含的文本。如果底层文档为 null，则将给出 NullPointerException。
	private JTextField idField;
	private JPasswordField pwdField;
	private JLabel message;
	public int getUserId(){
		return Integer.parseInt(idField.getText());
	}
	public String getPassword(){
		char[] pwd = pwdField.getPassword();//为安全，sun规定返回char类型
		return new String(pwd);//转换成字符串
	}
	public void showMessage(String message){
		this.message.setText(message);
	}
}
