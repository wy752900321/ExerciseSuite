package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import cn.itcast.dao.BaseDao;
import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Category;
import cn.itcast.exception.DaoException;
import cn.itcast.util.QueryResult;

public class BookDaoImpl extends BaseDao implements BookDao {

	public void saveBook(Connection conn, Book book) {
		if(book==null){
			throw new DaoException("您要保存的图书信息不能为空");
		}
		if(book.getCategory()==null){
			throw new DaoException("您要保存的图书信息所关联的种类不能为空");
		}
		//设置错误提示信息
		String errorMsg = "保存图书信息失败";
		//组织sql语句 
		String sql = "insert into book(id,name,price,author,image,description,category_id) values(?,?,?,?,?,?,?)";
		//设置sql语句需要的参数
		Object[] params = {
				book.getId(),book.getName(),book.getPrice(),book.getAuthor(),book.getImage(),
				book.getDescription(),book.getCategory().getId()
		};
		//调用父类的方法
		super.update(conn,sql,params,errorMsg);
	}
//	public List<Book> findAllBooks(Connection conn) {
//	List<Book> list=null;
//    //设置错误提示信息
//	String errorMsg="查询图书信息失败";
//	//组织sql语句
//	String sql="SELECT id, name, price, author, image, description, category_id FROM  book";
//	list=super.findObjectsByCondition(conn, sql, null, Book.class, errorMsg);
//	
//	return list;
//}
	
	@SuppressWarnings("unchecked")
	public List<Book> findAllBooks(Connection conn) {
		/***********************************************************************************/
		ResultSetHandler resultSetHandler = new ResultSetHandler(){
				public Object handle(ResultSet rs) throws SQLException {
					List<Book>  newlist=new ArrayList<Book>();
					/*
					 * 	String sql=" SELECT b.id, b.name, b.price, b.author, b.image, b.description,"+
				           " b.category_id,c.id,c.name,c.description"+
				           " FROM  book b,category c WHERE b.category_id=c.id";
					 */
					while(rs.next()){
						Book book = new Book();
						book.setId(rs.getString(1));
						book.setName(rs.getString(2));
						book.setPrice(rs.getDouble(3));
						book.setAuthor(rs.getString(4));
						book.setDescription(rs.getString(5));
						book.setImage(rs.getString(6));
						
						Category category = new Category();
						category.setId(rs.getString(8));
						category.setName(rs.getString(9));
						category.setDescription(rs.getString(10));
						
						book.setCategory(category);
						newlist.add(book);
					}
					return newlist;
				}
		};
/***********************************************************************************************************/
		List<Book> list ;
		String errorMsg = "查询图书信息失败";
		try{
			list=null;
			//设置错误提示信息
			
			//组织sql语句 
			String sql = "select b.id,b.name,b.price,b.author,b.image,b.description," +
					"b,category_id,c.id,c.name,c.description " +
					"from book b,category c where b.category_id=c.id";
			QueryRunner query = new QueryRunner();
			list=(List)query.query(conn, sql,resultSetHandler);
		}catch(SQLException e){
			e.printStackTrace();
			throw new DaoException(errorMsg,e);
		}
		return list;
	}
	
	
	public void deleteBookById(Connection conn, String id) {
		
	}

	public Book findBookById(Connection conn, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryResult<Book> findPageBooksByCondition(Connection conn,
			Integer beginIndex, Integer maxSize, String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateBook(Connection conn, Book book) {
		

	}

	
	
	
}
