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
		
		//�õ��û��Ĺ��ﳵ
		Cart cart=(Cart) req.getSession().getAttribute("cart");
		if (cart==null) {
			cart=new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		
		//����ӵ��û��Ĺ��ﳵ��,��ɹ���
		cart.add(book);
		resp.sendRedirect(req.getContextPath()+"/servlet/cart");
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
