package com.itcast.service;

import java.util.Map;

import com.itcast.bean.Book;
import com.itcast.bean.Cart;

public interface BookService {

	Map<String, Book> getAllBook();

	Book getBookById(String id);

	void deleteItem(String id, Cart cart);

	void clearAll(Cart cart);

	void changeItemQuantity(Cart cart, String id, String quantity);

}