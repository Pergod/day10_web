package com.itcast.db;

import java.util.LinkedHashMap;
import java.util.Map;

import com.itcast.bean.Book;

public class DB {
	private static Map<String, Book> map=new LinkedHashMap<String,Book>();
	
	static{
		map.put("1", new Book("1", "Java Web����", "��", 34.9, "Javaweb��������"));
		map.put("2", new Book("2", "Spring����", "��", 66.6, "Spring��������"));
		map.put("3", new Book("3", "Struts2����", "��", 52.1, "Struts2ѧϰ�ر�"));
		map.put("4", new Book("4", "JavaScript����", "��", 21.9, "ǰ�˿���"));
		map.put("5", new Book("5", "AJAX����", "��", 53.1, "ǰ�˽���"));
		map.put("6", new Book("6", "���ģʽ", "��", 34, "����Ա�ر�����"));
	}
	
	public static Map<String, Book> getAll() {
		return map;
	}
}
