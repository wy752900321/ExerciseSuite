package com.tarena.action.user;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.tarena.action.BaseAction;
import com.tarena.util.ImgeUtil;

public class GetCodeImage extends BaseAction{
	private InputStream imageStream;
	
	public String execute(){
		Map<String,BufferedImage> map =ImgeUtil. createImage();
		String code = map.keySet().iterator().next();
		session.put("code",code);
		System.out.println("code....."+code);
		BufferedImage image = map.get(code);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
		try {
			encoder.encode(image);
			byte[] bts = bos.toByteArray();
			imageStream = new ByteArrayInputStream(bts);
		} catch (Exception e) {
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
