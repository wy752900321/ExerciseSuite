package web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import exception.ExtException;

import utils.IOUtils;

@SuppressWarnings("serial")
public class UploadServlet2 extends HttpServlet {

	@SuppressWarnings("unchecked")
	private List exts = Arrays.asList("jpg", "gif", "png", "jsp", "txt", "java");

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		// request.setCharacterEncoding("UTF-8");//mime

		if (!ServletFileUpload.isMultipartContent(request)) {
			// 执照传统方式获取数据
			return;
		}

		try {
			// 1.创建解析工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));

			// 2.创建解析器
			ServletFileUpload upload = new ServletFileUpload(factory);

			// upload.setFileSizeMax(1024*1024);
			upload.setHeaderEncoding("UTF-8");// 设置传输头文件 的编码

			// 3.解析request
			List<FileItem> list = upload.parseRequest(request);

			// 4.迭代list，拿到代表表单每个输入项的fileitem
			for (FileItem item : list) {
				if (item.isFormField()) {
					// 当前拿到的是普通输入项
					String name = item.getFieldName();
					String value = item.getString("UTF-8");// 作用同下句，把得到的内容
															// 转成utf-8
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");
					System.out.println(name + "=" + value);
				} else {
					// 当前item封 装的是上传文件

					// 获取到文件名
					String filename = item.getName();// Settings\ThinkPad\桌面\a.txt
														// , a.txt
					if (filename == null || filename.trim().equals("")) {
						continue;
					}

					// 判断文件是否为允许上传的文件
					String ext = filename.substring(filename.lastIndexOf(".") + 1);// "jpg","gif","bmp","jsp","txt","java"
					if (!exts.contains(ext)) {
						// 经典处理， MVC。servlet最好转向一个jsp文件 ，在这里最好的办法是抛异常。
						// 异常类继承自Exception。是编译时异常，必须处理的，给用户友好提示需要。
						// 而RuntimeException是运行时，如果我们忘记处理，就不友好了
						// 原则:当我们需要看到的异常继承Exception，不需要看到的类继承自RuntimeExcepiton
						throw new ExtException("文件只能是：" + exts.toString());
					}

					filename = filename.substring(filename.lastIndexOf("\\") + 1); // 得到上传文件的名称
					String saveFilename = makeFileName(filename);// 为上传文件分配一个唯一的文件名

					String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
					savepath = makeSavePath(saveFilename, savepath);// 得到文件
																	// 的保存目录

					InputStream in = item.getInputStream();

					FileOutputStream out = new FileOutputStream(savepath + "/" + saveFilename);
					IOUtils.in2Out(in, out);
					item.delete();// 删除item对应的临时文件

				}
			}
			response.getWriter().write("上传成功 ！ ！");
		} catch (ExtException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;// 返回方法调用处
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			request.setAttribute("message", "文件不能超赤1M");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String makeSavePath(String filename, String uploadPath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf;
		int dir2 = (hashcode >> 4) & 0xf;

		String savepath = uploadPath + File.separator + dir1 + File.separator + dir2;

		File file = new File(savepath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return savepath;
	}

	public String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;// //sdfjlsjflsjflkjfds_1.html
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
