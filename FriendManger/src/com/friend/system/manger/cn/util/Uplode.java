package com.friend.system.manger.cn.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.friend.system.manger.cn.bean.User;

public class Uplode {
	private static DiskFileItemFactory diskFileItemFactory;
	private static ServletFileUpload servletFileUpload;
	private static List<FileItem> items;
	static {
		diskFileItemFactory = new DiskFileItemFactory();
		servletFileUpload = new ServletFileUpload(diskFileItemFactory);
	}

	public static String[] getOrdinaryFileds(HttpServletRequest request)
			throws UnsupportedEncodingException {
		items = getItems(request);
		String[] datas = {};
		for (int i = 0; i < items.size(); i++) {
			FileItem fileItem = items.get(i);
			if (fileItem.isFormField()) {
				String name = fileItem.getString("utf-8");
				datas = Arrays.copyOf(datas, datas.length + 1);
				datas[datas.length - 1] = name;
			}
		}
		return datas;
	}

	@SuppressWarnings("unchecked")
	private static List<FileItem> getItems(HttpServletRequest request) {
		List<FileItem> items = null;
		try {
			items = servletFileUpload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public static String getImage(HttpServletRequest request, HttpServlet userAction)
			throws IOException {
		ServletContext servletContext = userAction.getServletContext();
		String path = servletContext.getRealPath("upload");
		User user = (User)request.getSession().getAttribute("user");
		String in = "";
		for (int i = 0; i < items.size(); i++) {
			FileItem fileItrm = items.get(i);
			if (fileItrm.isFormField()) {
				continue;
			}
			String name =getFieldName(fileItrm);
			File file = new File(path, user.getId()+"");
			file.mkdir();
			file = new File(path+"/"+user.getId(), name);
			try {
				fileItrm.write(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			in = name;
		}
		return in;
	}
	private static String getFieldName(FileItem fileItrm) {
		long time = System.currentTimeMillis();
		return time+fileItrm.getFieldName();
	}

	public static void delete(HttpServletRequest request, String img, HttpServlet userOwn) {
		ServletContext servletContext = userOwn.getServletContext();
		User user = (User)request.getSession().getAttribute("user");
		String path = servletContext.getRealPath("upload/"+user.getId());
		File file = new File(path, img);
		file.delete();
	}
}
