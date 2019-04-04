package com.atguigu.spring.tx_xml;

public class BookShopServiceImpl implements BookShopService {

	
	
	private BookshopDao bookshopDao;
	public void setBookshopDao(BookshopDao bookshopDao) {
		this.bookshopDao = bookshopDao;
	}
	@Override
	public void purchase(String name, String istn) {
		/**获取书籍id以及价格**/
		int money=bookshopDao.findBookPriceByIstn(istn);
		/**更新库存**/
		bookshopDao.updateBookStore(istn);
		/**更新账号余额**/
		bookshopDao.updateUserAccount(name, money);
	}

}
