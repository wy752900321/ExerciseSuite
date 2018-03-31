package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import util.CookieUtil;

import bean.Cart;
import bean.CartItem;
import dao.ComputerDAO;
import dao.impl.ComputerDAOJdbcImpl;
import entity.Computer;

public class ActionServlet extends HttpServlet {

	private Logger log = Logger.getLogger(this.getClass());

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if (path.equals("/list")) {
			ComputerDAO dao = new ComputerDAOJdbcImpl();
			try {
				List<Computer> computers = dao.findAll();
				log.warn("ActionServlet->list.do->computers:    " + computers);
				request.setAttribute("computers", computers);
				request.getRequestDispatcher("computer_list.jsp").forward(
						request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (path.equals("/buy")) {
			// 获得用户所购买的商品的id
			long id = Long.parseLong(request.getParameter("id"));
			log.warn("ActionServlet->buy.do->id:  " + id);
			ComputerDAO dao = new ComputerDAOJdbcImpl();
			try {
				// 依据id,查询数据库，获得所购买的商品的信息
				Computer c = dao.findById(id);
				// 将Computer对象包装成CartItem对象
				CartItem item = new CartItem();
				item.setC(c);
				item.setQty(1);
				// 将商品条目对象添加到购物车(cart)
				// 首先从session中取cart对象
				HttpSession session = request.getSession();
				Cart cart = (Cart) session.getAttribute("cart");
				// 如果cart==null(即第一次点击购买)
				// 要创建一个cart对象，并且放到session里。
				if (cart == null) {
					// 如果session当中没有绑订cart,则创建cart对象，
					// 然后绑订到session上面。
					cart = new Cart();
					//版本2更改：尝试查找名叫cart的cookie，恢复之前购买的商品数据 
					cart.load(CookieUtil.findCookie("cart", request));
					session.setAttribute("cart", cart);
				}
				// 接下来，调用cart对象的add方法
				boolean flag = cart.add(item);
				if (!flag) {
					// 如果已经购买过该商品,则提示用户。
					request.setAttribute("buy_error_" + id, "已经购买过该商品");
					request.getRequestDispatcher("list.do").forward(request,
							response);
				} else {
					//没有买过，返回到商品列表
					//将cart中的数据以cookie的形式备份到客户端
					CookieUtil.addCookie("cart", cart.store(), response);
					response.sendRedirect("list.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (path.equals("/del")) {
			long id = Integer.parseInt(request.getParameter("id"));
			log.warn("ActionServlet->del.do->id:  " + id);
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			cart.delete(id);
			//版本二更改
			CookieUtil.addCookie("cart", cart.store(), response);
			response.sendRedirect("cart.jsp");
		} else if (path.equals("/clear")) {
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			log.warn("ActionServlet->clear.do->cart:  " + cart);
			cart.clear();
			//版本2更改
			CookieUtil.deleteCookie("cart", response);
			response.sendRedirect("cart.jsp");
		} else if (path.equals("/update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			log.warn("ActionServlet->update.do->id:  " + id);
			int qty = Integer.parseInt(request.getParameter("qty"));
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			cart.modify(id, qty);
			//版本二更改
			CookieUtil.addCookie("cart", cart.store(), response);
			response.sendRedirect("cart.jsp");
		}

	}

}
