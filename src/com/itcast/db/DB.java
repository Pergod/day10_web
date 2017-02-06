package com.itcast.db;

import java.util.LinkedHashMap;
import java.util.Map;

import com.itcast.bean.Book;

public class DB {
	private static Map<String, Book> map=new LinkedHashMap<String,Book>();
	
	static{
		map.put("1", new Book("1", "Java Web开发", "张", 34.9, "Javaweb开发入门"));
		map.put("2", new Book("2", "Spring开发", "江", 66.6, "Spring开发进阶"));
		map.put("3", new Book("3", "Struts2开发", "毕", 52.1, "Struts2学习必备"));
		map.put("4", new Book("4", "JavaScript开发", "胡", 21.9, "前端开发"));
		map.put("5", new Book("5", "AJAX开发", "高", 53.1, "前端进阶"));
		map.put("6", new Book("6", "设计模式", "张", 34, "程序员必备经典"));
	}
	
	public static Map<String, Book> getAll() {
		return map;
	}
}
