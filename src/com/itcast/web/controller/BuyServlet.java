package com.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.bean.Book;
import com.itcast.bean.Cart;
import com.itcast.service.BookService;
import com.itcast.service.impl.BookServiceImpl;

public class BuyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		BookService service=new BookServiceImpl();
		Book book=service.getBookById(id);
		
		//得到用户的购物车
		Cart cart=(Cart) req.getSession().getAttribute("cart");
		if (cart==null) {
			cart=new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		
		//将书加到用户的购物车中,完成购买
		cart.add(book);
		resp.sendRedirect(req.getContextPath()+"/servlet/cart");
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
