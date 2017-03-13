package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;
import com.tarena.util.DbPoolUtil;

/**
 * 商品显示的信息处理
 * 
 * @author soft01
 * 
 */
public class ProductDAOJdbcImpl extends BaseAction implements ProductDAO,
		Serializable {
	private static final long serialVersionUID = -7080452519628045049L;

	// 查询新书
	private static final String findNewProduct = "select dp.* from "
			+ "d_product dp join d_book db on (dp.id=db.id) where "
			+ "has_deleted=0 order by add_time desc limit ?,?";
	// 查询热卖
	private static final String findHotProduct = "select dp.*,"
			+ "sum(di.product_num) nums from d_item di join d_product "
			+ "dp on(di.product_id=dp.id) join d_book db on (dp.id=db.id) "
			+ "group by dp.id order by nums desc limit 4";
	// 查询新书热卖
	private static final String findNewHotProduct = "select dp.*,"
			+ "sum(di.product_num) nums from d_product dp join d_item "
			+ "di on(dp.id=di.product_id) join d_book db on (dp.id=db.id) "
			+ "where dp.add_time>? group by dp.id order by nums desc limit 8";
	// 通过id找商品
	private static final String findProductById = "select * from d_product "
			+ "where id=?";

	/**
	 * 查询前n个最新上架商品
	 * 
	 * @param size
	 *            获取前n个
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewProduct(int size) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findNewProduct);
		// 4.设置参数
		stat.setInt(1, 0);
		stat.setInt(2, size);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		// 7.赋值
		List<Product> list = new ArrayList<Product>();
		while (set.next()) {
			Product pro = new Product();
			pro.setId(set.getInt("id"));
			pro.setProductName(set.getString("product_name"));
			pro.setDangPrice(set.getDouble("dang_price"));
			pro.setFixedPrice(set.getDouble("fixed_price"));
			pro.setDescription(set.getString("description"));
			pro.setAddTime(set.getLong("add_time"));
			pro.setProductPic(set.getString("product_pic"));
			pro.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				pro.setHasDeleted(false);
			} else {
				pro.setHasDeleted(true);
			}
			list.add(pro);
		}
		return list;
	}

	/**
	 * 查询前n个热卖图书
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> findHotProduct() throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句，并返回主键值
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findHotProduct, PreparedStatement.RETURN_GENERATED_KEYS);
		// 4.执行语句对象
		// 5.返回结果集
		ResultSet set = stat.executeQuery();
		List<Product> list = new ArrayList<Product>();
		// 6.赋值
		while (set.next()) {
			Product pro = new Product();
			pro.setId(set.getInt("id"));
			pro.setProductName(set.getString("product_name"));
			pro.setDangPrice(set.getDouble("dang_price"));
			pro.setFixedPrice(set.getDouble("fixed_price"));
			pro.setDescription(set.getString("description"));
			pro.setAddTime(set.getLong("add_time"));
			pro.setProductPic(set.getString("product_pic"));
			pro.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				pro.setHasDeleted(false);
			} else {
				pro.setHasDeleted(true);
			}
			list.add(pro);
		}
		return list;
	}

	/**
	 * 查询前n个新书热卖图书
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Product> findNewHotProduct() throws Exception {
		// 设置三十天之前是什么时间
		long thirthDayBefore = System.currentTimeMillis() - 30 * 24 * 60 * 60
				* 1000L;
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findNewHotProduct);
		// 4.设置参数
		stat.setLong(1, thirthDayBefore);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		List<Product> list = new ArrayList<Product>();
		// 7.赋值
		while (set.next()) {
			Product pro = new Product();
			pro.setId(set.getInt("id"));
			pro.setProductName(set.getString("product_name"));
			pro.setDescription(set.getString("description"));
			pro.setAddTime(set.getLong("add_time"));
			pro.setFixedPrice(set.getDouble("fixed_price"));
			pro.setDangPrice(set.getDouble("dang_price"));
			pro.setKeywords(set.getString("keywords"));
			if (set.getInt("has_deleted") == 0) {
				pro.setHasDeleted(false);
			} else {
				pro.setHasDeleted(true);
			}
			pro.setProductPic(set.getString("product_pic"));
			list.add(pro);
		}
		return list;
	}

	/**
	 * 通过id查询一个商品
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public Product findProductById(int pid) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findProductById);
		// 4.设置参数
		stat.setInt(1, pid);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		set.next();
		Product pro = new Product();
		pro.setId(set.getInt("id"));
		pro.setProductName(set.getString("product_name"));
		pro.setDescription(set.getString("description"));
		pro.setAddTime(set.getLong("add_time"));
		pro.setFixedPrice(set.getDouble("fixed_price"));
		pro.setDangPrice(set.getDouble("dang_price"));
		pro.setKeywords(set.getString("keywords"));
		if (set.getInt("has_deleted") == 0) {
			pro.setHasDeleted(false);
		} else {
			pro.setHasDeleted(true);
		}
		pro.setProductPic(set.getString("product_pic"));
		return pro;
	}

	// public static void main(String[] args) throws Exception {
	// ProductDAOImpl daoImpl = new ProductDAOImpl();
	// Product pro = daoImpl.findProductById(2);
	// System.out.println(pro.getProductName());
	// }
}
