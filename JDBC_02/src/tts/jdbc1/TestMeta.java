package tts.jdbc1;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TestMeta {
	//获得原数据
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement stmt = 
			con.prepareStatement("select * from emp");
		ResultSet rs = stmt.executeQuery();//    在此 PreparedStatement 对象中执行 SQL 查询，并返回该查询生成的 ResultSet 对象。
		
		//获取元数据(各个列的信息)
		//ResultSetMetaData getMetaData() throws SQLException
        //获取此 ResultSet 对象的列的编号、类型和属性。
		ResultSetMetaData rsmd = rs.getMetaData();
			
		//返回此 ResultSet 对象中的列数。
		for(int i=1;i<rsmd.getColumnCount();i++){
			//返回指定列的名称
			System.out.println(rsmd.getColumnName(i)+"");
			//返回指定列的类型的名称
			System.out.println(rsmd.getColumnTypeName(i));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
