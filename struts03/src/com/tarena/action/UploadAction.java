package com.tarena.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

public class UploadAction {
	private File mf;//上传后的临时文件
	private String mfFileName;//获取原文件名
	private String mfContentType;//获取原文件类型

	//将临时文件复制到目标位置
	public String execute(){
		System.out.println("将临时文件复制到目标位置");
		try {
			FileInputStream fis = 
				     	new FileInputStream(mf);
			//获取存储文件的目标路径
			String path = ServletActionContext
				.getServletContext().getRealPath("/upload");
			String file = path+File.separatorChar
								+mfFileName;
			System.out.println("目标位置:"+file);
			FileOutputStream fos = 
					new FileOutputStream(file);
			//一边读一边写
			byte[] b = new byte[1024];
			int size = -1;
			while((size = fis.read(b)) != -1){
				fos.write(b,0,size);
			}
			fis.close();
			fos.close();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	public String getMfContentType() {
		return mfContentType;
	}

	public void setMfContentType(String mfContentType) {
		this.mfContentType = mfContentType;
	}

	public String getMfFileName() {
		return mfFileName;
	}

	public void setMfFileName(String mfFileName) {
		this.mfFileName = mfFileName;
	}

	
	public File getMf() {
		return mf;
	}

	public void setMf(File mf) {
		this.mf = mf;
	}

}
