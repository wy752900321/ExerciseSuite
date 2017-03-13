package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 分页查询的问题
 */
public class TestQuery {
	private static final String sql = "select value from " +
			"(select value,rownum n from tts_foo " +
			"where rownum<?) where n>=?";
	//带order by 的分页查询
/*	select ename
	from(select ename rownum n from 
			(select ename,sal
					from emp order by ename) where rownum<20)
	where n>=10*/
	
	//MYSQL的分页查询
	//第一个参数为开始取的记录标号(从0开始)
	//第二个参数为一共取的记录数
//	MySql数据库方法(a,b)，从第a个开始，取出b个
//	select ename from emp order by ename limit 10,10
	public static void main(String[] args) throws Exception{
		Connection con = ConnectionUtils.getConnection();
		//分布查询的问题
		PreparedStatement stmt = con.prepareStatement(sql);
		//读取第90000到90000+10之间的这十条记录
		stmt.setInt(1, 90000+10);
		stmt.setInt(2, 90000);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getInt(1));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
