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
			// ����û����������Ʒ��id
			long id = Long.parseLong(request.getParameter("id"));
			log.warn("ActionServlet->buy.do->id:  " + id);
			ComputerDAO dao = new ComputerDAOJdbcImpl();
			try {
				// ����id,��ѯ���ݿ⣬������������Ʒ����Ϣ
				Computer c = dao.findById(id);
				// ��Computer�����װ��CartItem����
				CartItem item = new CartItem();
				item.setC(c);
				item.setQty(1);
				// ����Ʒ��Ŀ������ӵ����ﳵ(cart)
				// ���ȴ�session��ȡcart����
				HttpSession session = request.getSession();
				Cart cart = (Cart) session.getAttribute("cart");
				// ���cart==null(����һ�ε������)
				// Ҫ����һ��cart���󣬲��ҷŵ�session�
				if (cart == null) {
					// ���session����û�а�cart,�򴴽�cart����
					// Ȼ��󶩵�session���档
					cart = new Cart();
					//�汾2���ģ����Բ�������cart��cookie���ָ�֮ǰ�������Ʒ���� 
					cart.load(CookieUtil.findCookie("cart", request));
					session.setAttribute("cart", cart);
				}
				// ������������cart�����add����
				boolean flag = cart.add(item);
				if (!flag) {
					// ����Ѿ����������Ʒ,����ʾ�û���
					request.setAttribute("buy_error_" + id, "�Ѿ����������Ʒ");
					request.getRequestDispatcher("list.do").forward(request,
							response);
				} else {
					//û����������ص���Ʒ�б�
					//��cart�е�������cookie����ʽ���ݵ��ͻ���
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
			//�汾������
			CookieUtil.addCookie("cart", cart.store(), response);
			response.sendRedirect("cart.jsp");
		} else if (path.equals("/clear")) {
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			log.warn("ActionServlet->clear.do->cart:  " + cart);
			cart.clear();
			//�汾2����
			CookieUtil.deleteCookie("cart", response);
			response.sendRedirect("cart.jsp");
		} else if (path.equals("/update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			log.warn("ActionServlet->update.do->id:  " + id);
			int qty = Integer.parseInt(request.getParameter("qty"));
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			cart.modify(id, qty);
			//�汾������
			CookieUtil.addCookie("cart", cart.store(), response);
			response.sendRedirect("cart.jsp");
		}

	}

}
