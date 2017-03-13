package cn.itcast.web.manager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import cn.itcast.domain.Book;
import cn.itcast.domain.Category;
import cn.itcast.service.BookService;
import cn.itcast.service.CategoryService;

public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 2193518706071173359L;
	private Logger log = Logger.getLogger(this.getClass());
	
	public void save(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String path ="/message.jsp";
		/*
		 * Map<String,String> params=new HashMap<String, String>(); 
		 * * Map<FieldName,fieldValue>  params.put(FieldName,fieldValue) 
		 * <td><input type="text" name="author" style="width: 200px" value="张孝祥"></td>
		 * params.put("author","张孝祥") params.put("price","12")
		 * 
		 * Book book=new Book(); book.setAuthor(params.get("author"))
		 * book.setAuthor(request.getParameter("author"))
		 */
			Map<String,String> params = new HashMap<String,String>();
			try{
				boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
				if(isMultipartContent){
					//文件上传
					DiskFileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(factory);
					List<FileItem> items = upload.parseRequest(request);
					Iterator<FileItem> it = items.iterator();
					while(it.hasNext()){
						FileItem item = it.next();
						if(item.isFormField()){//表单或
							String FiledName =item.getFieldName();
							String fieldValue = item.getString("utf-8");
							params.put(FiledName, fieldValue);
						}else{
							//文本域<input type="file" name="image" style="width:200px">
							String FieldName = item.getFieldName();
							//D：\book_photo\java.gif
							String fileNamePath = item.getName();
							
							//获取文件 的名称
							String fileName = fileNamePath.substring(fileNamePath.lastIndexOf("\\")+1);
							System.out.println("fileName"+fileName);
							
							String realPath = this.getServletContext().getRealPath("/images");
							File newfile = new File(realPath,fileName);
							
							item.write(newfile);
							params.put(FieldName, fileName);
						}
					}
					//封装数据到Book
					Book book = new Book();
					Category category = new Category();
					
					book.setId(UUID.randomUUID().toString());
					book.setName(params.get("name"));
					if(StringUtils.isNotBlank(params.get("price"))){
						book.setPrice(Double.parseDouble(params.get("price")));
					}
					book.setAuthor(params.get("author"));
					book.setImage(params.get("image"));
					book.setDescription(params.get("description"));
					category.setId(params.get("category_id"));
					book.setCategory(category);
					
					BookService bookService = new BookService();
					bookService.saveBook(book);
					request.setAttribute("message", "图书信息保存成功");
					path = "/message.jsp";
				}
			}catch(Exception e){
				e.printStackTrace();
				log.warn(e);
				request.setAttribute("message", e.getMessage());
				path = "/message.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		
	}
	/**
	 * 显示图书信息添加页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.warn("BookServlet->add:.................");
		String path = "/manager/book/add.jsp";
		try{
			CategoryService categoryService = new CategoryService();
			List<Category> categorys = categoryService.findAllCategorys();
			request.setAttribute("categorys", categorys);
			path = "/manager/book/add.jsp";
		}catch(Exception e){
			e.printStackTrace();
			log.warn(e);
			request.setAttribute("message", e.getMessage());
			path ="/message.jsp";
		}
		request.getRequestDispatcher("/manager/book/add.jsp").forward(request, response);
	}

}
