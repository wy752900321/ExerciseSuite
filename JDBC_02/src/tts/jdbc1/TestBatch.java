package tts.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 批处理
 */
public class TestBatch {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		//设置自动提交false(默认是true)
		con.setAutoCommit(false);
		
		PreparedStatement stmt = con
				.prepareStatement("insert into tts_foo(value"+"values(?)");
		long time = System.currentTimeMillis();
		
		try{
			
			for(int i=90000;i<90000+1000000;i++){
				stmt.setInt(1, i);
				stmt.addBatch();//将一组参数添加到此 PreparedStatement 对象的批处理命令中。 
				if(i%100000==0){
					stmt.executeBatch();//将一批命令提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。
				}
				//执行给定的 SQL 语句，并通知驱动程序在给定数组中指示的自动生成的键应该可用于获取。
				//此数组包含目标表中的列的索引，该目标表包含应该可获取的自动生成的键。
				//stmt.executeUpdate();
			}
			stmt.executeBatch();//如果执行过后的数据不足100000就调用这个方法执行
			
			con.commit();
			
			System.out.println(System.currentTimeMillis()-time);
		}catch(Exception e){
			e.printStackTrace();
			con.rollback();
		}
	}
}
