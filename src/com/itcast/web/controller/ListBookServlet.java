package com.itcast.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.bean.Book;
import com.itcast.service.BookService;
import com.itcast.service.impl.BookServiceImpl;

public class ListBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService service=new BookServiceImpl();
		Map<String, Book> allBooks=service.getAllBook();
		req.setAttribute("books", allBooks);
		req.getRequestDispatcher("/WEB-INF/jsp/booklist.jsp").forward(req, resp);;
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
