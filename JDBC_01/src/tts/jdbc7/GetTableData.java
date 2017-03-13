package tts.jdbc7;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTableData {
		public static void main(String[] args) {
//			getData("emp");
			getData("users_ning");
		}
		public static void getData(String tablename){
			String sql = "select * from "+tablename	;
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			try{
				//数据库的元数据
				DatabaseMetaData dmd = conn.getMetaData();
				//数据库名
				System.out.println(dmd.getDatabaseProductName());
				//数据库版本号
				System.out.println(dmd.getDatabaseMajorVersion());
				//连接字符串
				System.out.println(dmd.getURL());
				//用户名
				System.out.println(dmd.getUserName());
				
				//演示2，结果集元数据
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();//获取结果集的元数据
				int columnCount = rsmd.getColumnCount();//获取列数
				
				for(int i=1;i<=columnCount;i++){
					System.out.println(rsmd.getColumnName(i)+" ");
				}
				System.out.println();
				System.out.println("-------------------------");
				while(rs.next()){
					//注意:JDBC的计数从1开始 
					for(int i=1;i<=columnCount;i++){
						String value = rs.getString(rsmd.getColumnName(i));
						System.out.println(value+"\t");
					}
					System.out.println();
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(rs);
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
		}
}
