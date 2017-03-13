package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;

/** 闪屏 */
public class WelcomeWindow extends JWindow {

  private static final long serialVersionUID = -2970626103134592561L;
  public WelcomeWindow() {
    init();
  }
	/*// 窗口的居中处理
	private void center(Window win){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width-win.getWidth())/2;
		int y = (screen.height-win.getHeight())/2;
		win.setLocation(x,y);
	}
	public void show(){
		final Window welcomeWindow;
		center(welcomeWindow);
		welcomeWindow.setVisible(true);
		final Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				welcomeWindosw.setVisible(false);
				center(loginFrame);
				loginFrame.setVisible(true);
				timer.cancel();
			}
		},2000);
		
	}*/
  private void init(){
    setSize(430, 300);
    JPanel pane = new JPanel(new BorderLayout());
    ImageIcon ico = new ImageIcon(
        getClass().getResource("welcome.png"));
    JLabel l = new JLabel(ico);
    pane.add(BorderLayout.CENTER, l);
    pane.setBorder(new LineBorder(Color.GRAY));
    setContentPane(pane);
  }
  public static void main(String[] args) {
    WelcomeWindow w = new WelcomeWindow();
    w.setVisible(true);
  }
}