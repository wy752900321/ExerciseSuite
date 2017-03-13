package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Picture;
import util.HibernateUtil;
import dao.PictureDAO;

public class PictureDAOHibernateImpl implements PictureDAO {

	public List<Picture> findByUserId(Long id) {
		// FIXME Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from Picture p where p.userId=:userId");
		query.setLong("userId", id);
		List list = query.list();
		session.close();
		return list;
	}

	public void save(Picture picture) {
		// FIXME Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(picture);
		tx.commit();
		session.close();
	}

}
