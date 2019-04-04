package com.atguigu.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	@Transactional
	@Override
	public void checkout(String name, List<String> istns) {
		// TODO Auto-generated method stub

		for (String istn : istns) {
			bookShopService.purchase(name, istn);
		}
	}

}
