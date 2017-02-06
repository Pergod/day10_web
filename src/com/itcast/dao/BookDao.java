package com.itcast.dao;

import java.util.Map;

import com.itcast.bean.Book;

public interface BookDao {

	Map<String, Book> SelectAll();

	Book SelectById(String id);

}