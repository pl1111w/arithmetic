package com.atguigu.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	
	@Autowired
	private BookshopDao bookshopDao;
	/***添加事物注解 传播行为,隔离级别,回滚属性,只读属性, 超时,**/
	/*@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED,readOnly=true,
			noRollbackFor= {BookStockException.class},
			timeout=3)*/
	@Transactional
	@Override
	public void purchase(String name, String istn) {
		
		/*Thread thread = new Thread();
		try {
			thread.sleep(5000);
			System.out.println("事务过期了！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// TODO Auto-generated method stub
		/**获取书籍id以及价格**/
		int money=bookshopDao.findBookPriceByIstn(istn);
		/**更新库存**/
		bookshopDao.updateBookStore(istn);
		/**更新账号余额**/
		bookshopDao.updateUserAccount(name, money);
	}

}
