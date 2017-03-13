package org.colin.dang.dao;

import java.util.List;

import org.colin.dang.pojo.Book;

public interface RecommendDAO {
 public List<Book> findRecommend(int size);
}
