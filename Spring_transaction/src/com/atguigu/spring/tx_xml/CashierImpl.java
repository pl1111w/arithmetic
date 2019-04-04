package com.atguigu.spring.tx_xml;

import java.util.List;

public class CashierImpl implements Cashier {
	private BookShopService bookShopService;
    public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	@Override
	public void checkout(String name, List<String> istns) {
		// TODO Auto-generated method stub

		for (String istn : istns) {
			bookShopService.purchase(name, istn);
		}
	}

}
