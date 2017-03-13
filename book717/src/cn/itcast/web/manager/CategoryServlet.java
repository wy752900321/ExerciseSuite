package cn.itcast.web.manager;

import java.io.IOException;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import cn.itcast.domain.Category;
import cn.itcast.service.CategoryService;
import cn.itcast.util.Global;

@SuppressWarnings("serial")
public class CategoryServlet extends BaseServlet {

	private Logger log = Logger.getLogger(this.getClass());
	
	public void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String path = "/message.jsp";
		try{
			//获取表单的数据 
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			//封装表单的数据到Category
			Category category = new Category();
			category.setId(id);
			category.setName(name);
			category.setDescription(description);
			
			//实例化业务层CategoryService
			CategoryService categoryService = new CategoryService();
			
			//调用页业务的方法
			categoryService.updateCategory(category);
			
			request.setAttribute("message", "修改图书分类数据成功");
			path="/message.jsp";
		}catch(Exception e){
//			e.printStackTrace();
			log.warn("e  "+e);
			log.debug("e.getMessage()   "+e.getMessage());
			request.setAttribute("message", e.getMessage());
			path = "/message.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String path = "/message.jsp";
		try{
			String id = request.getParameter("id");
			if(StringUtils.isNotBlank(id)){
				//实例化业务层CategoryService
				CategoryService categoryService=new CategoryService();
				Category category = categoryService.findCategoryById(id);
				request.setAttribute("category", category);
			}
			path = "/manager/category/edit.jsp";
		}catch(Exception e){
			e.printStackTrace();
			log.warn("e = "+e);
			request.setAttribute("message", e.getMessage());
			path = "/message.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String path = "/message.jsp";
		try{
			//获取表单的数据
			String id = request.getParameter("id");
			
			//实例化业务层CategoryService
			CategoryService categoryService = new CategoryService();
			
			//调用页业务的方法
			categoryService.deleteCategoryById(id);
			request.setAttribute("message", "删除图书分类数据成功");
			path="/message.jsp";
		}catch(Exception e){
//			e.printStackTrace();
			log.warn("e   "+e);
			log.debug("e.getMessage()   "+e.getMessage());
			request.setAttribute("message", e.getMessage());
			path = "/message.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String path = "/manager/category/list.jsp";
			try{
				// 实例化业务层CategoryService
				CategoryService categoryService = new CategoryService();
				List<Category> categorys = categoryService.findAllCategorys();
				request.setAttribute("categorys", categorys);
			path = "/manager/category/list.jsp";
			}catch(Exception e){
				e.printStackTrace();
				log.warn("e=  "+e);
				request.setAttribute("message", e.getMessage());
				path = "/message.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "/message.jsp";
		try {
			// 获取表单的数据
			String name = request.getParameter("name");
			log.debug("name  " + name);// log4j记录日志
			String description = request.getParameter("description");
			log.debug("description  " + description);// log4j记录日志

			// 封装表单的数据到category
			Category category = new Category();
			category.setId(UUID.randomUUID().toString());
			category.setName(name);
			category.setDescription(description);

			// 实例化业务层CategoryService
			CategoryService categoryService = new CategoryService();

			// 调用页业务的方法categoryService.save(category)
			categoryService.saveCategory(category);

			request.setAttribute("message",
					Global.CONTROLLER_CATEGORY_ADD_EXCEPTION);
			path = "/message.jsp";

		} catch (Exception e) {
			// e.printStackTrace();
			log.warn("e   " + e);
			log.debug("e.getMessage()  " + e.getMessage());
			System.out.println("e.getMessage():" + e.getMessage());
			request.setAttribute("message", e.getMessage());
			path = "/message.jsp";

		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
