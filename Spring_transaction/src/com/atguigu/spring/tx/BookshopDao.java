package com.atguigu.spring.tx;

public interface BookshopDao {

	/**获取书籍的单价**/
	public int findBookPriceByIstn(String istn);
	
	/**更新书的库存**/
	public void updateBookStore(String istn);
	
	/**更新用户账号余额**/
	public void updateUserAccount(String name,int money);
		
}
