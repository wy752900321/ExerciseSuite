package control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import util.ImageUtil;

public class ImageAction extends BaseAction{
		private InputStream imageStream;
		public String execute(){
			//map中key是图片的文字内容，value是图片对象
			Map<String,BufferedImage> map = ImageUtil.createImage();
			//获取key值，即图片的内容并放入到session中
			String code = map.keySet().iterator().next();
			session.put("code", code);
			BufferedImage image = map.get(code);
			//将iamge赋值给iamgeStream属性
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
			try {
				encoder.encode(image);
				byte[] bts = bos.toByteArray();
				imageStream = new ByteArrayInputStream(bts);
			} catch (ImageFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			return "success";
		}
		public InputStream getImageStream() {
			return imageStream;
		}
		public void setImageStream(InputStream imageStream) {
			this.imageStream = imageStream;
		}
		
}
