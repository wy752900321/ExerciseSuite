package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.BookDAO;
import com.tarena.dao.SortDAO;
import com.tarena.entity.Book;
import com.tarena.util.DAOFactory;
import com.tarena.util.DbPoolUtil;

/**
 * 专为排序而准备的DAO对象
 * 
 * @author soft01
 * 
 */
public class SortDAOJdbcImpl implements SortDAO, Serializable {
	private static final long serialVersionUID = 5451454187654662279L;

	/**
	 * book_list页面的排序
	 * 
	 * @param cid
	 *            类别id
	 * @param page
	 *            分页数
	 * @param size
	 *            每页大小
	 * @param rule
	 *            排序规则
	 * @return 返回一个书的集合
	 * @throws Exception
	 */
	public List<Book> order(int cid, int page, int size, int rule)
			throws Exception {
		// 创建语句对象
		PreparedStatement stat;
		String str = null;
		// 通过类别id找到全部书
		String byCatId = "select dp.*,db.* from d_category_product dcp"
				+ " join d_product dp on (dcp.product_id=dp.id)"
				+ " join d_book db on(dp.id=db.id) where"
				+ " dcp.cat_id=? limit ?,?";
		if (rule == 1) {
			// 按类别排序
			// 1.创建连接
			// 2.创建语句对象
			// 3.接收sql语句
			stat = DbPoolUtil.getConnection().prepareStatement(byCatId);
			// 4.设置参数
			stat.setInt(1, cid);
			int begin = (page - 1) * size;
			stat.setInt(2, begin);
			stat.setInt(3, size);
		} else if (rule == 2) {
			// 按上架时间降序
			str = "select dp.*,db.* from d_product dp join d_book db"
					+ " on (dp.id=db.id) order by dp.add_time desc limit ?,?";
			// 1.创建连接
			// 2.创建语句对象
			// 3.接收sql语句
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.设置参数
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		} else if (rule == 3) {
			// 按上架时间升序
			str = "select dp.*,db.* from d_product dp join d_book db"
					+ " on (dp.id=db.id) order by dp.add_time limit ?,?";
			// 1.创建连接
			// 2.创建语句对象
			// 3.接收sql语句
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.设置参数
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		} else if (rule == 4) {
			// 按现价降序
			str = "select dp.*,db.* from d_product dp join d_book db"
					+ " on (dp.id=db.id) order by dp.dang_price desc limit ?,?";
			// 1.创建连接
			// 2.创建语句对象
			// 3.接收sql语句
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.设置参数
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		} else if (rule == 5) {
			// 按现价升序
			str = "select dp.*,db.* from d_product dp join d_book db"
					+ " on (dp.id=db.id) order by dp.dang_price limit ?,?";
			// 1.创建连接
			// 2.创建语句对象
			// 3.接收sql语句
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.设置参数
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		} else {
			// 按销量降序
			str = "select dp.*,db.*,di.*,sum(di.product_num) nums from"
					+ " d_item di join d_product dp on(di.product_id=dp.id)"
					+ " join d_book db on (dp.id=db.id) group by dp.id order"
					+ " by nums desc limit ?,?";
			// 1.创建连接
			// 2.创建语句对象
			// 3.接收sql语句
			stat = DbPoolUtil.getConnection().prepareStatement(str);
			// 4.设置参数
			int begin = (page - 1) * size;
			stat.setInt(1, begin);
			stat.setInt(2, size);
		}
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		List<Book> list = new ArrayList<Book>();
		BookDAO bookDAO = (BookDAO) DAOFactory.getInstance("BookDAO");
		// 7.给book赋值
		while (set.next()) {
			Book book = new Book();
			// 设置d_product表属性值
			book.setBookNum(bookDAO.findTotalNumById(set.getInt("id")));
			book.setId(set.getInt("id"));
			book.setProductName(set.getString("product_name"));
			book.setDescription(set.getString("description"));
			book.setAddTime(set.getLong("add_time"));
			book.setFixedPrice(set.getDouble("fixed_price"));
			book.setDangPrice(set.getDouble("dang_price"));
			book.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				book.setHasDeleted(false);
			} else {
				book.setHasDeleted(true);
			}
			book.setProductPic(set.getString("product_pic"));
			// 设置d_book表属性值
			book.setAuthor(set.getString("author"));
			book.setPublishing(set.getString("publishing"));
			book.setPublishTime(set.getLong("publish_time"));
			book.setWordNumber(set.getString("word_number"));
			book.setWhichEdtion(set.getString("which_edtion"));
			book.setTotalPage(set.getString("total_page"));
			book.setPrintTime(set.getInt("print_time"));
			book.setPrintNumber(set.getString("print_number"));
			book.setIsbn(set.getString("isbn"));
			book.setAuthorSummary(set.getString("author_summary"));
			book.setCatalogue(set.getString("catalogue"));
			// 设置book表其他属性值
			list.add(book);
		}
		return list;
	}

	// public static void main(String[] args) throws Exception {
	// SortDAO sortDAO = (SortDAO) DAOFactory.getInstance("SortDAO");
	// List<Book> list = sortDAO.order(9, 1, 10, 6);
	// for (Book book : list) {
	// System.out.println(book.getDangPrice());
	// }
	// }
}
