package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Product;

public interface MoreOtherBooksDAO {

	List<Product> findHotProduct(int page, int hotNum) throws Exception;

	int findHotProductNumber() throws Exception;

}
