package tts.jdbc7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*基于查询的分页策略
	1）每次只向数据库要求一页的数据量。
2）假设每页10条(pageSize=10)
	第1页：1－10
	第二页：11－20
	。。。
	第n页：［起点］(n-1)*pageSize+1------>[终点]起点+pageSize-1
3）特点：频繁的数据库访问。第次取数据的时间差不多
					比较适合大数据量
					对内存压力小
 */
/**
  		可行性方案：匿名视图（可行）
 				SQL>select * from (select id,rownum rn from mytemp_xxx)
 										where rn between 21 and 30;
 				----功能上等价于
 				SQL>create view myview
 							as
 							select id,rownum rn from mytemp_xxx;
 				SQL>select * from myview;
 */
public class SelectPageDemo {
		public static void main(String[] args) {
			getPage(10,8);//71--80
		}
		/**
		 * 根据每页记录数和要查看的页数，显示数据
		 * @param pageSize		每页多少条
		 * @param page		要看的是第几页
		 */
		public static void getPage(int pageSize,int page){
			int begin = (page-1)*pageSize+1;
			int end = begin+pageSize-1;
			String sql ="select id from (" +
					"select id,rownum rn from mytemp_xxx) " +
					"where rn between ? and ?";
	
		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectionUtils.close(rs);
			ConnectionUtils.close(stmt);
			ConnectionUtils.close(conn);
		}
	}
}
