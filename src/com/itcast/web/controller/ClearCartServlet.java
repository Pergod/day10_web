package com.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.bean.Cart;
import com.itcast.service.BookService;
import com.itcast.service.impl.BookServiceImpl;

public class ClearCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart=(Cart) req.getSession(false).getAttribute("cart");
		BookService service=new BookServiceImpl();
		service.clearAll(cart);
		
		req.getRequestDispatcher("/WEB-INF/jsp/cartlist.jsp").forward(req, resp);
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
