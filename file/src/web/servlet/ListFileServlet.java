package web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//列出系统所有的下载文件
@SuppressWarnings("serial")
public class ListFileServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/WEB-INF/upload");
		
		Map map = new HashMap();
		listfile(new File(path),map);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/listfile.jsp").forward(request, response);
		
	}
	
	@SuppressWarnings("unchecked")
	public void listfile(File file,Map map){
		if(file.isFile()){
			String uuidName = file.getName();
			String realname = uuidName.substring(uuidName.indexOf("_")+1); //"iewoiewsdfjf_阿_凡达.avi"
			map.put(uuidName, realname);
		}else{
			File files[] = file.listFiles();
			for(File f:files){
				listfile(f,map);
			}
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
