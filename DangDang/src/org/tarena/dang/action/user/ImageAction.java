package org.tarena.dang.action.user;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;
import org.tarena.dang.util.ImageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageAction {
	private Logger log = Logger.getLogger(this.getClass());
	private InputStream imageStream;

	// 生成验证码图片，然后交给stream的result返回
	public String execute() throws Exception {
		Map<String, BufferedImage> map = ImageUtil.createImage();
		// 获取图片字符
		String code = map.keySet().iterator().next();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("code", code);
		log.warn("从验证图片中取得的ImageAction->code->" + code);

		// 获取图片
		BufferedImage image = map.get(code);
		// 将image给imageStream赋值
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);

			encoder.encode(image);
			byte[] bits = bos.toByteArray();
			imageStream = new ByteArrayInputStream(bits);
			return "success";
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
}
