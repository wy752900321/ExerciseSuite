package web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.IOUtils;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//获得要下载的文件名
			String filename = request.getParameter("filename");
			//把从文件 中得到的文件（is08859-1编码），转换成UTF－8，保证中文名不乱码
			//文件 的上传下载是通过MIME协议传输的，是特殊编码。需要指定转换。
			filename = new String(filename.getBytes("iso8859-1"),"UTF-8");
			
			//得到文件的保存目录
			String filepath = this.getServletContext().getRealPath("/WEB-INF/upload")+"\\"+getFilePath(filename);
			
			//得到文件是否存在
			File file = new File(filepath+"\\"+filename);
			if(!file.exists()){
				request.setAttribute("message", "对不起，您要下载资源已被删除！！");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			//indexOf()：找不到返回-1，经典！
			String realname = filename.substring(filename.indexOf("_")+1);
			//如果显示给用户的下载对话框中是中文文件名的话，要经过url编码，作为一个消息头传给服务器，说浏览器选的 是下载操作
			response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(realname,"UTF-8"));
			
			FileInputStream in = new FileInputStream(file);
			//此out流不必关闭，它是response得到的，由服务器自己关闭，这就是重写IOUtils.in2Out2（in,out）的原因
			OutputStream out = response.getOutputStream();
			IOUtils.in2Out2(in,out);
			
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request,response);
}
	/**
	 * 	通过哈希表得到文件路径，在哈希表中文件是通过计算存储的。
	 * @param filename	文件名
	 * @return		文件路径
	 */
	public String getFilePath(String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf;
		int dir2 = (hashcode>>4)&0xf;
		return dir1+"\\"+dir2;
	}
}
