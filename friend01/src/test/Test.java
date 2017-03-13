package test;

import pojo.User;
import dao.DAOFactory;
import dao.UserDAO;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// FIXME Auto-generated method stub
		UserDAO dao = (UserDAO) DAOFactory.getDAOInstance(UserDAO.class);
		dao.save(new User("zs","test","zhangshan",20,true,"12345"));
	}

}
