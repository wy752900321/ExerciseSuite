package basic.day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import basic.day16.IOUtils;
/**
 *ImageIO提供了将byte流过滤（反序列化）为图片对象的方法
 *将内存Image对象写入到文件中，就需要编码／序列化
 */
//读取照片，并显示到图形界面上
//ImageIO:该类包含一些用来查找 ImageReader 和 ImageWriter 以及执行简单编码和解码的静态便捷方法。 
public class ImageIODemo {
	public static void main(String[] args) throws IOException {
		
		File dir = new File(".");
		String pathname = dir.getCanonicalPath();
		// 在eclipse中，当前目录是”项目文件夹“
		System.out.println(pathname);//pwd
		
		String file = "test/zhaopian1.jpg";
		InputStream in = new FileInputStream(file);//byte流

		BufferedImage img = ImageIO.read(in);//过滤
		Graphics2D g = (Graphics2D)img.getGraphics();
		g.setColor(Color.BLUE);
		g.drawString("By Robin", 50, 50);
		OutputStream out = new FileOutputStream("zhaopian3.jpeg");//输出时，改名，改格式
		ImageIO.write(img, "jpeg", out);//把照片对象按jpeg格式取出
		IOUtils.print("img.jpeg");
		JFrame frame = new JFrame("查看照片");
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon(img));
		panel.add(label);
		frame.setContentPane(panel);
		frame.setSize(800,700);
		frame.setVisible(true);
		
	
		
	}
}
