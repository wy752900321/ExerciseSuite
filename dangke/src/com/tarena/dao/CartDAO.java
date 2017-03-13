package com.tarena.dao;

import com.tarena.entity.Product;

public interface CartDAO {

	Product findProductById(int pid) throws Exception;
	
}
