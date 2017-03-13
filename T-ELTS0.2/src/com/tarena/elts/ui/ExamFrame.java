package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ExamFrame extends JFrame{
	private static final long serialVersionUID = -5355432125621015300L;
		//选项集合, 方便答案读取的处理
		private Option[] options= new Option[4]; 
		public ExamFrame(){
			init();
		}
		private void init(){
			setTitle("达内在线测试系统");
			setSize(600,380);
			setContentPane(createContentPane());
			setLocationRelativeTo(null);
		}
		private JPanel createContentPane(){
			JPanel  pane = new JPanel(new BorderLayout());
			ImageIcon icon = new ImageIcon(getClass().getResource("exam_title.png"));
			pane.setBorder(new EmptyBorder(6,6,6,6));
			pane.add(BorderLayout.NORTH,new JLabel(icon));
			pane.add(BorderLayout.CENTER,createCenterPane());
			pane.add(BorderLayout.SOUTH,createToolsPane());
			return pane;
		}
		private JPanel createCenterPane(){
			JPanel pane = new JPanel(new BorderLayout()	);
			//注意：
			JLabel examInfo = new JLabel("姓名：贾东坡  编号：1001	" +
					"考试时间：1分钟 考试科目：Javase阶段测试 	题目数量：20 ",JLabel.CENTER);
			pane.add(BorderLayout.NORTH,examInfo);
			pane.add(BorderLayout.CENTER,createQuestionPane());
			pane.add(BorderLayout.SOUTH,createOptionsPane());
			return pane;
		}
		private JPanel createOptionsPane(){
			JPanel pane = new JPanel();
			Option a = new Option(0,"A");
			Option b = new Option(1,"B");
			Option c = new Option(2,"C");
			Option d = new Option(3,"D");
			options[0] = a;
			options[1] = b;
			options[2] = c;
			options[3] = d;
			pane.add(a);
			pane.add(b);
			pane.add(c);
			pane.add(d);
			return pane;
			
		}
		private JScrollPane createQuestionPane(){
			JScrollPane pane = new JScrollPane();
			pane.setBorder(new TitledBorder("题目"));//标题框
			
			//注意
			//JTextArea 是一个显示纯文本的多行区域。
			JTextArea questionArea = new JTextArea();
			questionArea.setText("问题\nA.\nB.\nC.\nD.");
			questionArea.setLineWrap(true);//允许折行显示
			questionArea.setEditable(false);//不能够编辑内容
			 //JTextArea 必须放到 JScrollPane 的视图区域中(Viewport)
			pane.getViewport().add(questionArea);
			return pane;
		}
		private JPanel createToolsPane(){
			JPanel pane = new JPanel(new BorderLayout());
			pane.setBorder(new EmptyBorder(0,10,0,10));
			//注意
			JLabel questionCount = new JLabel("题目：20的第1题");
			JLabel timer = new JLabel("剩余60秒");
			
			pane.add(BorderLayout.WEST,questionCount);
			pane.add(BorderLayout.EAST,timer);
			pane.add(BorderLayout.CENTER, createBtnPane());
			return pane;
		}
		private JPanel createBtnPane(){
			JPanel pane = new JPanel(new FlowLayout());
			JButton prev = new JButton("上一题");
			JButton next = new JButton("下一题");
			JButton send = new JButton("交卷");
				pane.add(prev);
				pane.add(next);
				pane.add(send);
				return pane;
		}
		  /**使用内部类扩展了JCheckBox增加了val属性，代表答案值
		 		JCheckBox复选框的实现，复选框是一个可以被选定和取消选定的项，它将其状态显示给用户
				public JCheckBox(String text,Icon icon,boolean selected)
		    	创建一个带文本和图标的复选框，并指定其最初是否处于选定状态。
		    参数：
		        text - 复选框的文本
		        icon - 要显示的 Icon 图像
		        selected - 指示最初选择状态的 boolean 值。如果该参数为 true，则复选框被选定
		   */
		class Option extends JCheckBox{//复选框
			//java的API基本都实现了序列化接口
			 // serialVersionUID:指示与类的 JDK 1.1.x 版本的兼容性。 
			//凡是实现序列化接口的类，最好提供一个序列化版本号
			private static final long serialVersionUID = 5569918347028393191L;
			int value;
			public Option(int value,String txt){//(0,A),(1,B),(2,C)
				super(txt);//传给父类
				this.value=value;//留下来的
			}
		}
}
