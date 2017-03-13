package com.tarena.dao.jdbcimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.CategoryDAO;
import com.tarena.entity.Category;
import com.tarena.util.DbPoolUtil;

/**
 * d_category的信息处理
 * 
 * @author soft01
 * 
 */
public class CategoryDAOJdbcImpl extends BaseAction implements CategoryDAO {
	private static final long serialVersionUID = 7223501434109216229L;
	// 按照turn找出商品并排序
	private static final String findAll = "select * from d_category order by turn";
	// 查询出类别信息，并且包含产品数量
	// 需要结合d_category_product表
	private static final String findByParentId = "select * from d_category "
			+ "where parent_id=? order by turn";
	// 查询商品数量
	private static final String findBookNumber = "select count(*) from "
			+ "d_category dc join d_category_product dcp on (dc.id="
			+ "dcp.cat_id) join d_product dp on (dcp.product_id=dp.id) "
			+ "join d_book db on (dp.id=db.id) where dc.id=?";
	// 通过类别id找出全部信息
	private static final String findByCatId = "select * from d_category "
			+ "dc join d_category_product dcp on (dcp.cat_id=dc.id) "
			+ "where dc.id=?";
	// 通过id找名字
	private static final String findNameByCatId = "select name from "
			+ "d_category where id=?";

	/**
	 * 按照turn找出商品并排序
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAll() throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findAll);
		// 4.执行语句对象
		// 5.返回结果集
		ResultSet set = stat.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while (set.next()) {
			// 6.赋值
			Category cat = new Category();
			cat.setId(set.getInt("id"));
			cat.setName(set.getString("name"));
			cat.setParentId(set.getInt("parent_id"));
			cat.setPnum(findBookNumber(set.getInt(1)));// 设置统计出产品数量
			list.add(cat);
		}
		return list;
	}

	/**
	 * 通过父类别id找商品并按照turn排序
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public List<Category> findByParentId(int pid) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findByParentId);
		// 4.设置参数
		stat.setInt(1, pid);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while (set.next()) {
			// 7.赋值
			Category cat = new Category();
			cat.setId(set.getInt("id"));
			cat.setTurn(set.getInt("turn"));
			cat.setEnName(set.getString("en_name"));
			cat.setName(set.getString("name"));
			cat.setDescription(set.getString("description"));
			cat.setParentId(set.getInt("parent_id"));
			// 设置其他属性值
			cat.setPnum(findBookNumber(set.getInt(1)));// 设置统计出产品数量
			list.add(cat);
		}
		return list;
	}

	/**
	 * 查询商品数量
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public int findCountByCatId(int cid) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findByCatId);
		// 4.设置参数
		stat.setInt(1, cid);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		List<Category> list = new ArrayList<Category>();
		while (set.next()) {
			// 7.赋值
			Category cat = new Category();
			cat.setId(set.getInt("id"));
			cat.setTurn(set.getInt("turn"));
			cat.setEnName(set.getString("en_name"));
			cat.setName(set.getString("name"));
			cat.setDescription(set.getString("description"));
			cat.setParentId(set.getInt("parent_id"));
			// 设置其他属性值
			cat.setPnum(findBookNumber(cid));// 设置统计出产品数量
			list.add(cat);
		}
		return list.size();
	}

	/**
	 * 某个类别的商量的数量
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public int findBookNumber(int cid) throws Exception {
		int bookNum = 0;
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findBookNumber);
		// 4.设置参数
		stat.setInt(1, cid);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		while (set.next()) {
			bookNum = set.getInt(1);
		}
		return bookNum;
	}

	/**
	 * 通过类别id找到类别名
	 * 
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public String findNameByCatId(Integer cid) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findNameByCatId);
		// 4.设置参数
		stat.setInt(1, cid);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		String name = "";
		if (set.next()) {
			name = set.getString(1);
		}
		return name;
	}
}
