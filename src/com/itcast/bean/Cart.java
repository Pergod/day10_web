package com.itcast.bean;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 用户购物车
 */
public class Cart {
	//防止重复,CartItem代表该商品以及该商品出现的次数s
	private Map<String,CartItem> map=new LinkedHashMap<String,CartItem>();
	private double price;
	
	public void add(Book book) {
		CartItem item=map.get(book.getId());
		if (item==null) {
			item=new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);
		}else {
			item.setQuantity(item.getQuantity()+1);
		}
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public double getPrice() {
		double total=0.0;
		for (Map.Entry<String, CartItem> entry: map.entrySet()) {
			CartItem item=entry.getValue();
			total+=item.getPrice();
		}
		this.price=total;
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
