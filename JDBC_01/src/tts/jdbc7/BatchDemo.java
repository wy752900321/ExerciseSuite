package tts.jdbc7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * 批处理练习
 */
public class BatchDemo {
		public static void main(String[] args) {
			executeSql();
		}
		public static void executeSql(){
			String sql = "insert into mytemp_xxx(id) values(?)";
			Connection conn = ConnectionUtils.getConnection();
			PreparedStatement stmt = null;
			try{
				//关闭自动默认提交
				conn.setAutoCommit(false);
				stmt=conn.prepareStatement(sql);
				for(int i=1;i<=105;i++){
					stmt.setInt(1, i);
					//1.把sql语句加入批处理
					stmt.addBatch();
					//2，每10条记录处理一次避免处理中的sql语句太多 
					if(i%10==0){
						//3。执行
						stmt.executeBatch();
						//4。清除
						stmt.clearBatch();
					}
				}
				//执行最后的5句sql
				stmt.executeBatch();
				conn.commit();
			}catch(SQLException e){
				try{
					conn.rollback();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
		}
}
