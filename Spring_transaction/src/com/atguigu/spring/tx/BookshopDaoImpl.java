package com.atguigu.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookshopDaoImpl implements BookshopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int findBookPriceByIstn(String istn) {
		// TODO Auto-generated method stub
		String sql = "SELECT book_price FROM book WHERE istn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, istn);
	}

	@Override
	public void updateBookStore(String istn) {
		// TODO Auto-generated method stub
		/**检查书的库存是否足够, 若不够, 则抛出异常**/
				String sql2 = "SELECT stock FROM book_stock WHERE istn = ?";
				int stock = jdbcTemplate.queryForObject(sql2, Integer.class, istn);
				if(stock == 0){
					throw new BookStockException("库存不足!");
				}
				
				String sql = "UPDATE book_stock SET stock = stock -1 WHERE istn = ?";
				jdbcTemplate.update(sql, istn);

	}

	@Override
	public void updateUserAccount(String name, int money) {
		// TODO Auto-generated method stub
		/**验证余额是否足够, 若不足, 则抛出异常**/
				String sql2 = "SELECT money FROM account WHERE name = ?";
				int balance = jdbcTemplate.queryForObject(sql2, Integer.class, name);
				if(balance < money){
					throw new UserAccountException("余额不足!");
				}
				
				String sql = "UPDATE account SET money = money - ? WHERE name = ?";
				jdbcTemplate.update(sql, money, name);

	}

}
