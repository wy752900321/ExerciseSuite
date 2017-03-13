package com.wangxin.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UploadAction extends BaseAction{
		private String some;//客户端文件xxx
		private String someFileName;//文件名xxxFileName
		private String ContentType;//文件类型
		//存放文件的路径
		private String imagePath;
		
		
		public String execute(){
			//随机生成上传文件名
			String imageName =
			     "file_" + System.currentTimeMillis()+ someFileName.substring(someFileName.lastIndexOf("."));
			/*
			 * 上传文件的相对路径
			 * 链接的时候使用
			 */
			imagePath = "upload/" + imageName;
			/*
			  * 上传文件的绝对路径
			  * 写文件时使用
			  */
			
			String realImagePath = httpApplication.getRealPath(imagePath);
			System.out.println(realImagePath);
			//从缓存中读取图片文件
			BufferedInputStream is;
			try {
				is = new BufferedInputStream(
				            new FileInputStream(some));
				BufferedOutputStream os = new BufferedOutputStream(
						new FileOutputStream(realImagePath));
				int len = -1;
				byte[] buf = new byte[1024];
				while(-1!= (len = is.read(buf))){
					os.write(buf, 0, len);
				}
				is.close();
				os.close();
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}


		}
		public String getSome() {
			return some;
		}
		public void setSome(String some) {
			this.some = some;
		}
		public String getSomeFileName() {
			return someFileName;
		}
		public void setSomeFileName(String someFileName) {
			this.someFileName = someFileName;
		}
		public String getContentType() {
			return ContentType;
		}
		public void setContentType(String contentType) {
			ContentType = contentType;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
		
		
}
