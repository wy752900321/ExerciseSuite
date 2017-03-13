package com.tarena.action.user;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.tarena.action.BaseAction;
import com.tarena.util.ImageUtil;

/**
 * 此类用于生成图片
 * @author soft01
 *
 */
public class ImageAction extends BaseAction {
	private static final long serialVersionUID = 2442787106435367353L;
	//input
	private InputStream imageStream;

	public ImageAction() {
	}
	public String execute() {
		// 调用生成图片的方法，赋值给map集合
		Map<String, BufferedImage> map = ImageUtil.createImage();
		String code = map.keySet().iterator().next();
		// 把生成的code加入session，用于后来和用户输入的比对
		session.put("code", code);
		// 生成图片
		BufferedImage img = map.get(code);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
		try {
			encoder.encode(img);
			byte[] bts = baos.toByteArray();
			imageStream = new ByteArrayInputStream(bts);
		} catch (Exception e) {
			Logger logger=Logger.getLogger(ImageAction.class);
			logger.error("生成图片的action出了问题", e);
		}
		// 如果成功传送一个流参数
		return "success";
	}

	// getter and setter
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

	public InputStream getImageStream() {
		return imageStream;
	}
}
