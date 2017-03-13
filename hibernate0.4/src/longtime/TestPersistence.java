package longtime;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestPersistence {
	public void testiterator(){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Foo");
		
		//方式一：不延缓加载（使用较多）
		List<Foo> fooList = query.list();
		
		//方式2：延缓记载
		Iterator<Foo> fooIt = query.iterate();
		//select t_id from t_foo;
		
		while(fooIt.hasNext()){
			Foo foo = fooIt.next();
			//select* from t_foo where t_id=?
			System.out.println(foo.getValue());
		}
	}
}
