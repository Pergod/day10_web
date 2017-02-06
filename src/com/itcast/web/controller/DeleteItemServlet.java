package com.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.bean.Cart;
import com.itcast.service.BookService;
import com.itcast.service.impl.BookServiceImpl;

public class DeleteItemServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		
		BookService service=new BookServiceImpl();
		Cart cart=(Cart) req.getSession(false).getAttribute("cart");
		service.deleteItem(id,cart);
		
		//É¾³ý³É¹¦
		req.getRequestDispatcher("/WEB-INF/jsp/cartlist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
