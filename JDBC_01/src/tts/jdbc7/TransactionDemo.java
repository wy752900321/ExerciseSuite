package tts.jdbc7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改员工1001的薪水为20000
 * 处理事务
 */
public class TransactionDemo {
	public static void main(String[] args) {
		try{
			updateSalary(1001,20000);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//修改员工表中某个员工的薪水为指定值，同时记录日志
	public static void updateSalary(int empno,double salary) 
																									throws SQLException {
			//String sql1 = "update emp_xxx set salary = "+salary+"where empno="+empno;
//			String sql2 = "insert into logs_xxx"+"values(" +
//																"	mysql_log_xxx.nextval"+"user,sysdate,'update salay')";
			Connection conn = ConnectionUtils.getConnection();
			String na = "lu";
			String sql2 = "insert into t_student(name) values(?)";
			PreparedStatement stmt =null;
			try{
				//1.把JDBC的自动提交关闭
				conn.setAutoCommit(false);
				stmt  = conn.prepareStatement(sql2);
				//2.执行sql
				stmt.setString(1, na);
				int n1 = stmt.executeUpdate();
				System.out.println("n1="+n1);
				na ="jia";
				stmt.setString(1, na);
				int n2 = stmt.executeUpdate();
				System.out.println("n2="+n2);
				//3如果都执行成功了，提交，否则回退
				if(n1==1&&n2==3){//n1=1:薪水被成功修改，n2=1：成功插入一条日志记录
					conn.commit();
				}else{
					conn.rollback();
				}
				//4恢复默认值
				conn.setAutoCommit(true);
			}catch(Exception e){
				System.out.println("SQL语句出现了异常！");
				conn.rollback();
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
	}
}
