package OneSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**如何保证获取同一个Session  
 *方法一(推荐) 同一个Sesison，重构HibernateUtil
 *方法二：修改hibernate.cfg.xml
 *			在配置文件中加入一句话，告诉Hibernate要
 *			使用ThreadLocal的方式获得sesion.
 *			在hibernate.cfg.xml中加入下面配置
 *<property name="current_session_context_class">thread</property>
 */
public class HibernateUtils {
	private static ThreadLocal<Session> tl = new ThreadLocal<Session>();
	private static Configuration conf;
	private static SessionFactory factory;
	
	static{
		conf = new Configuration();
		conf.configure();
		factory=conf.buildSessionFactory();
	}
	public static Session getSession(){
		//factory.getCurrentSession();
		Session session = tl.get();
		if(session==null){
			session=factory.openSession();
			tl.set(session);
		}
		return session;
	}
	public static void closeSession(){
		Session session = tl.get();
		if(session!=null){
			session.close();
			tl.set(null);
		}
	}
	/**
	 如上所示：我们可以再Dao中调用getSession()方法获取一个Session,
	 当页面显示数据结束后，在拦截中调用closeSession()关闭Session.
	 以后使用这个HibernateUtil即可
	 */
}
