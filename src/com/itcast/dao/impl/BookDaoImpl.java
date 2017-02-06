package com.itcast.dao.impl;

import java.util.Map;

import com.itcast.bean.Book;
import com.itcast.dao.BookDao;
import com.itcast.db.DB;

public class BookDaoImpl implements BookDao{
	
	@Override
	public Map<String, Book> SelectAll() {
		return DB.getAll();
	}
	
	@Override
	public Book SelectById(String id) {
		return DB.getAll().get(id);
	}
}
