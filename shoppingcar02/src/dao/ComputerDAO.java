package dao;

import java.util.List;

import entity.Computer;

public interface ComputerDAO {
	public List<Computer> findAll() throws Exception;
	public Computer findById(long id) throws Exception;
}
