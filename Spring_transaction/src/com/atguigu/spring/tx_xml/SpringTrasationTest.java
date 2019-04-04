package com.atguigu.spring.tx_xml;

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
		ctx=new ClassPathXmlApplicationContext("applicationContext_tx_xml.xml");
		bookshopDao=ctx.getBean(BookshopDao.class);
		bookShopService=ctx.getBean(BookShopService.class);
		cashier=ctx.getBean(Cashier.class);
	}
	@Test
	public void testcheckout(){
		cashier.checkout("zs", Arrays.asList("1001","1002"));
	}
	//@Test
	public void testFindBookPriceByIstn() {
		System.out.println(bookshopDao.findBookPriceByIstn("1001"));
	}
	//@Test
	public void testupdateBookStore(){
		bookshopDao.updateBookStore("1001");
	}
	//@Test
	public void testupdateUserAccount(){
		bookshopDao.updateUserAccount("zs", 10);
	}
	//@Test
	public void testBookShopService(){
		bookShopService.purchase("zs", "1001");
	}
}
