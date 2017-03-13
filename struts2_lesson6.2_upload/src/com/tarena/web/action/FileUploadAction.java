package com.tarena.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class FileUploadAction extends BaseAction {

	private File file;

	private String fileFileName;// 获取文件真实名字

	private String fileContentType;

	private String imagePath;

	public String doUpload() throws Exception {
		return "doUpload";
	}

	public String toUpload() throws Exception {
		// System.out.println(file.getName());
		// System.out.println(file.length());
		// System.out.println(fileFileName);
		// System.out.println(fileContentType);

		 imagePath = "imagesUpload/" + fileFileName;
		System.out.println("imagePath:" + imagePath);
		String realImagePath = ServletActionContext.getServletContext()
				.getRealPath(imagePath);
		System.out.println("realImagePath:" + realImagePath);
	
		
		// 上传
		if (uploadFile(realImagePath)) {
			return "toUpload";
		}
		return Action.INPUT;
	}

	// 上传
	private boolean uploadFile(String realImagePath) {
		boolean bool = false;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(new FileOutputStream(realImagePath));
			int len = -1;
			while ((len = bis.read()) != -1) {
				bos.write(len);
				bos.flush();
			}
			bool = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			closeIo(bis, bos);
		}
		return bool;
	}

	// 关闭流
	private void closeIo(BufferedInputStream bis, BufferedOutputStream bos) {
		try {
			if (bis != null) {
				bis.close();
			}
			if (bos != null) {
				bos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
