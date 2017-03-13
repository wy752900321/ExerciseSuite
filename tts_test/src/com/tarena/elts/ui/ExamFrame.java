package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

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

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;

public class ExamFrame extends JFrame{

	private static final long serialVersionUID = -5355432125621015300L;
	// 选项集合, 方便答案读取的处理
	private Option[] options = new Option[4];

	public ExamFrame() {
		init();
	}

	private void init() {
		setTitle("达内在线测试系统");
		setSize(600, 380);
		setContentPane(createContentPane());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				clientContext.send();
			}
		});
	}
	private JPanel createContentPane(){
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(getClass().getResource("exam_title.png"));
		pane.setBorder(new EmptyBorder(6,6,6,6));
		pane.add(BorderLayout.NORTH,new JLabel(icon));
		pane.add(BorderLayout.CENTER,createCenterPane());
		pane.add(BorderLayout.SOUTH,createToolsPane());
		return pane;
	}
	
	private JPanel createCenterPane(){
		JPanel pane = new JPanel(new BorderLayout());
		JLabel examInfo = new JLabel("姓名：贾东坡  编号：1001"+
				"考试时间:1分钟 考试科目：Javase阶段测试 	题目数量：20",JLabel.CENTER);
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
	//提供轻量级组件的 scrollable 视图。JScrollPane 管理视口、可选的垂直和水平滚动条以及可选的行和列标题视口。
	 //除了滚动条和视口之外，JScrollPane 也可以有一个列标题和一个行标题。
	private JScrollPane createQuestionPane(){
		JScrollPane pane = new JScrollPane();
		pane.setBorder(new TitledBorder("题目"));//标题框
		//JTextArea是一个显示纯文本的多行区域
		JTextArea questionArea = new JTextArea();
		questionArea.setText("问题\nA.\nB.\nC.\nD");
		questionArea.setLineWrap(true);//允许折行显示
		questionArea.setEditable(false);//不能够编辑内容
		//JTextArea 必须放到 JScrollPane 的视图区域中(Viewport)
		pane.getViewport().add(questionArea);
		return pane;
	}
	private JPanel createToolsPane(){
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(0,10,0,10));
		//注意：
		JLabel questionCount = new JLabel("题目：20的第1题");
		JLabel timer = new JLabel("剩余60秒");
		
		pane.add(BorderLayout.WEST,questionCount);
		pane.add(BorderLayout.EAST,timer);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext){
		this.clientContext = clientContext;
	}
	private JPanel createBtnPane(){
		JPanel pane = new JPanel(new FlowLayout());
		JButton prev = new JButton("上一题");
		JButton next = new JButton("下一题");
		JButton send = new JButton("交卷");
		pane.add(prev);
		pane.add(next);
		pane.add(send);
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.prev();
			}
		});
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.next();
			}
		});
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.send();
			}
		});
		return pane;
	}
	
	class Option extends JCheckBox {// 复选框

		private static final long serialVersionUID = -5357210068923979044L;
		int value;
		
		public Option(int value, String txt) {//(0,A),(1,B),(2,C)
			super(txt);//传给父类
			this.value = value;//留下来的
		}
	}
	private JLabel info;
	private JLabel questionCount;
	private JTextArea questionArea;
	public void updateView(ExamInfo examInfo,QuestionInfo questionInfo){
		info.setText(examInfo.toString());
		questionCount.setText("题目："+
				examInfo.getQuestionCount()+"的"+
				(questionInfo.getQuestionIndex()+1)+"题");
		questionArea.setText(questionInfo.toString());
//		 更新视图为下/上一题(更新 用户的答案)
		updateOptions(questionInfo.getUserAnswers());
	}
	private void updateOptions(List<Integer> userAnswers){
		for(Option o : options){
			o.setSelected(false);
			if(userAnswers.contains(o.value)){
				o.setSelected(true);
			}
		}
	}
	public List<Integer> getUserAnswers(){
		List<Integer> ans = new ArrayList<Integer>();
		for(Option o : options){
			if(o.isSelected()){
				ans.add(o.value);
			}
		}
		return ans;
	}
	private JLabel timer;
	public void updateTime(long h,long m,long s){
		String time = h+":"+m+":"+s;
		if(h==0&&m<5){
			timer.setForeground(Color.blue);
		}
		timer.setText(time);
	}
}
