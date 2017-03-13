package web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utils.IOUtils;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 如果提交表单的类型为multipart/form-data,在服务器端就不能采用传统方式获取数据
		// String username = request.getParameter("username");
		// System.out.println(username);

		/*InputStream in = request.getInputStream();
		int len = 0;
		byte buffer[] = new byte[1024];
		while ((len = in.read(buffer)) > 0) {
			System.out.println(new String(buffer));
		}*/
		
		response.setContentType("text/html;charset=UTF-8");
		try{
			//1.创建解析工厂
					DiskFileItemFactory factory = new DiskFileItemFactory();
					
			//2.创建解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//3.解析request
			List<FileItem> list = upload.parseRequest(request);
			
			//4.迭代list,拿到代表表单每个输入项的fileitem
			for(FileItem item:list){
				if(item.isFormField()){
					//当前拿到的是普通输入项
					String name = item.getFieldName();//得到输入框的name
					String value = item.getString();	//得到输入的值
					System.out.println(name+"="+value);
				}else{
					//当前item封装的是上传文件 
					
					//获取到文件名
					String filename = item.getName(); //C:\Documents and Settings\ThinkPad\桌面\a.txt   a.txt				}
					//浏览器的版本不一样得到的路径就可能不统一
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					
					InputStream in = item.getInputStream();
					String savepath=this.getServletContext().getRealPath("/WEB-INF/upload");
					FileOutputStream out = new FileOutputStream(savepath+"/"+filename);
					IOUtils.in2Out(in, out);
				}
			}
			response.getWriter().write("上传成功!!!");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
