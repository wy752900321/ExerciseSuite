package test;

import java.util.List;

import dao.ComputerDAO;
import dao.impl.ComputerDAOJdbcImpl;
import entity.Computer;

public class TestDAO {
	public static void main(String[] args) throws Exception {
		ComputerDAO daoC = new ComputerDAOJdbcImpl();
		/*≤È’“»´≤ø*/
		List<Computer> computers = daoC.findAll();
		System.out.println(computers.size());
		//
		System.out.println(daoC.findById(1));
	}
}
