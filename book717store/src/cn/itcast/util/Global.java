package cn.itcast.util;

public class Global {
		/**与数据库有关的常量***********************************************************************/
			public final static String ERROR_CONNECTION_EXCEPTION="获取数据库连接失败";
			public final static String ERROR_CLOSERESULT_EXCEPTION="关闭结果集异常";
			public final static String ERROR_CLOSESTATEMENT_EXCEPTION="关闭Statement对象异常";
			public final static String ERROR_CLOSECONNECTION_EXCEPTION="关闭连接异常";
			public final static String ERROR_BEGINTRANACTION_EXCEPTION="开始事务异常";
			public final static String ERROR_COMMITBEGINTRANACTION_EXCEPTION="提交事务异常";
			public final static String ERROR_ROLLBACKTRANACTION_EXCEPTION="回滚事务异常";
	
		/**与数据库dao层有关的常量****************************************************************/
			public final static String DAO＿CATEGORY_ADD_EXCEPTION="图书种类添加失败";
	
		/**与业务层有关的常量***********************************************************************/
			
			/**与控制层有关的常量*************************************************************************/
			public final static String CONTROLLER_CATEGORY_ADD_EXCEPTION="图书种类添加成功";
}
