package org.colin.dang.action.user;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import org.colin.dang.action.BaseAction;
import org.colin.dang.common.Constant;
import org.colin.dang.util.ImageUtil;

public class ImageAction extends BaseAction{

	private InputStream imageStream;
	
	public String execute() throws Exception{
		
		Map<String,BufferedImage> map = 
			ImageUtil.createImage();
		
		String code = map.keySet().iterator().next();
		System.out.println(code);
		session.put(Constant.CODE, code);
		BufferedImage image = map.get(code);
		imageStream = 
			ImageUtil.getInputStream(image);
		
		return "success";
	}
	

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	
	
}
