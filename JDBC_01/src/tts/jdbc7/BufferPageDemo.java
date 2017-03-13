package tts.jdbc7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
  基于缓存的分页策略
 		1）一次性把数据全部取出来放在缓存中，根据用户要看的页数(page)和每页记录数(pageSize),
 					计算把哪些数据输出显示。
 		2）假设每页10条(pageSize=10)
 				第1页：1－10
 				第二页：11－20
 				。。。
 				第n页：［起点］(n-1)*pageSize+1------>[终点]起点+pageSize-1
 		3)特点：
 			只访问数据库一次，第一次取数比较慢，以后每页都从缓存中取，比较快
 			比较适合小数据量，如果数据量大，对内存压力比较大
 			一次性将数据库数据读入结果集，每次查看指定的页时，要求结果集的指针能够
 		跳到指定的行，即指针能够跳到整个结果集的任一位置。
 */
public class BufferPageDemo {
		public static void main(String[] args) {
			//从第3页开始，打印10条记录
			getPage(10,"3");
//			getPage(10,3);//21－30
		}
		/**
		 * 打印指定页的数据，用mytemp_xxx表做测试
		 * begin:在结果集中第page页的记录起点
		 * 	begin=(page-1)pageSize+1;
		 * @param pageSize	每页多少记录
		 * @param page		第几页
		 */
		public static void getPage(int pageSize,String strPage){
			int page=1;
			
			//防止用户输入不合法字符作为页数，强制转到第一页
			try{
				page= Integer.parseInt(strPage);
			}catch(NumberFormatException e){
				page=1;
			}
			//防止用户输入页数超过最大值
			int totalPage=getTotalPage(pageSize);//获取总页数
			if(page>totalPage){
				//当用户输入超出最大页数，打印最后一页
				page = totalPage;
			}
			//防止用户输入负数,转到第一页
			if(page<1){
				page=1;
			}
			//在结果集中，第page页的记录起点
			int begin = (page-1)*pageSize+1;
			
			String sql = "select * from mytemp_xxx";
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			
			try{
				//约定结果集的类型和并发性
				stmt = conn.createStatement(
						//1)设置类型为可滚动的结果集(可跳步的	)
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						//2)设置并发性为其它用户只读
						ResultSet.CONCUR_READ_ONLY
				);
				//结果集为可滚动的，可进行分页操作
				rs = stmt.executeQuery(sql);
				
				//指针跳到结果集中的起点begin
				rs.absolute(begin);
				//循环pageSize次，取数据并打印
				for(int i=0;i<pageSize;i++){
					System.out.println(rs.getInt("id"));
					if(!rs.next()){
						break;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(rs);
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
		}
		/**
		 * 获得表得到总页数TotalPage
		 * 根据每页的记录数，计算共多少页
		 * @param pageSize 每页多少条
		 * @return			总页数
		 */
		private static int getTotalPage(int pageSize){
			int totalTableCount=0;//总记录数共105条
			totalTableCount = getTotalTableCount();
			int totalPage = 0;
			int mode = totalTableCount%pageSize;
			if(mode==0){//刚好除尽了
				totalPage=totalTableCount/pageSize;
			}else{//没有除尽，加1页
				totalPage = totalTableCount/pageSize+1;
			}
			return totalPage;
		}
		/**
		 * 	获得表的总记录数TotalTableCount
		 * @return		表的总记录数
		 */
		private static int getTotalTableCount(){
			int count = 0;
			String sql = "select count(*) num from mytemp_xxx";
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt  = null;
			ResultSet rs = null;
			try{
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				rs.next();
				count = rs.getInt("num");//取得结果集的第1 列
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
			return count;
		}
		
}
/*		public static void getPage(int pageSize,int page){

			//在结果集中，第page页的记录起点
			int begin=(page-1)*pageSize+1;
			String sql = "select* from mytemp_xxx";
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			try{
				//约定结果集的类型和并发性
				stmt = conn.createStatement(
						//1）设置类型为可滚动的结果集（可跳步的）
				ResultSet.TYPE_SCROLL_INSENSITIVE,
						//2)设置并发性为其他用户只读
				ResultSet.CONCUR_READ_ONLY
				);
				//结果集为可滚动的，可进行分页操作
				rs = stmt.executeQuery(sql);
				*//**注：演示1 只是测试结果集中指针的位置，真正对于分页生效的演示2的内容*//*
				演示1
				//1)定位到绝对位置 
				rs.absolute(85);//85
				System.out.println(rs.getInt("id"));
				//2)定位到绝对位置
				rs.relative(5);//90
				System.out.println(rs.getInt("id"));
				//3)下一条
				rs.next();//91
				System.out.println(rs.getInt("id"));
				//4)前一条
				rs.previous();//90
				System.out.println(rs.getInt("id"));
				//5) 异常：结果集耗尽
				rs.absolute(106);//共105条数据
//				System.out.println(rs.getInt("id"));
				System.out.println("#########################");
				
				演示 2
				//指针跳到结果集中的起点begin
				rs.absolute(begin);
				//循环pageSize次，取数据并打印
				for(int i=0;i<pageSize;i++){
					System.out.println(rs.getInt("id"));
					if(!rs.next()){
						break;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				ConnectionUtils.close(rs);
				ConnectionUtils.close(stmt);
				ConnectionUtils.close(conn);
			}
		}*/

