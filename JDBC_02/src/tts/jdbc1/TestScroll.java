package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestScroll {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		//分页查询的问题
//		preparedStatement stmt = con.prepareStatement("select * from tts_foo");
		
		//创建可滚动的结果集
		//CallableStatement prepareCall(String sql):创建一个 CallableStatement 对象来调用数据库存储过程。
		PreparedStatement stmt = con.prepareCall("select* from tts_foo",
				//	TYPE_SCROLL_INSENSITIVE
		        //  该常量指示可滚动但通常不受 ResultSet 底层数据更改影响的 ResultSet 对象的类型。
				//CONCUR_READ_ONLY:该常量指示不可以更新的 ResultSet 对象的并发模式。
				ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//按照默认情况获得的结果集
		//只能next!!!
		ResultSet rs = stmt.executeQuery();
		//rs.next();//游标向后
		//rs.previous();//游标向前
		rs.absolute(100);//游标绝对定位
		System.out.println(rs.getInt(1));
		
		rs.close();
		stmt.close();
		con.close();
	}
}
