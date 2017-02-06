package com.itcast.service.impl;

import java.util.Map;

import com.itcast.bean.Book;
import com.itcast.bean.Cart;
import com.itcast.bean.CartItem;
import com.itcast.dao.BookDao;
import com.itcast.dao.impl.BookDaoImpl;
import com.itcast.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao dao=new BookDaoImpl();
	
	@Override
	public Map<String, Book> getAllBook() {
		return dao.SelectAll();
	}
	
	@Override
	public Book getBookById(String id) {
		return dao.SelectById(id);
	}

	@Override
	public void deleteItem(String id, Cart cart) {
		cart.getMap().remove(id);
	}

	@Override
	public void clearAll(Cart cart) {
		cart.getMap().clear();
	}

	@Override
	public void changeItemQuantity(Cart cart, String id, String quantity) {
		CartItem item=cart.getMap().get(id);
		item.setQuantity(Integer.parseInt(quantity));
	}
	
}
