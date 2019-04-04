package com.atguigu.spring.tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTrasationTest {

	private ApplicationContext ctx;
	private BookshopDao bookshopDao;
	private BookShopService bookShopService;
	private Cashier cashier;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		bookshopDao=ctx.getBean(BookshopDao.class);
		bookShopService=ctx.getBean(BookShopService.class);
		cashier=ctx.getBean(Cashier.class);
	}
	
	/**事务传播行为 一次性买1001,1002两本书**/
	@Test
	public void testcheckout(){
		cashier.checkout("zs", Arrays.asList("1001","1002"));
	}
	//@Test
	/**单元测试根据编号获取书籍单价**/
	public void testFindBookPriceByIstn() {
		System.out.println(bookshopDao.findBookPriceByIstn("1001"));
	}
	
	/**单元测试书籍库存减1**/
	//@Test
	public void testupdateBookStore(){
		bookshopDao.updateBookStore("1001");
	}
	
	/**单元测试更新账户余额**/
	//@Test
	public void testupdateUserAccount(){
		bookshopDao.updateUserAccount("zs", 100);
	}
	//@Test
	/**用户zs购买一本编号为"1001"的书籍**/
	public void testBookShopService(){
		bookShopService.purchase("zs", "1001");
	}
}
