package com.atguigu.spring.tx_xml;

import org.springframework.jdbc.core.JdbcTemplate;

import com.atguigu.spring.tx.BookStockException;
import com.atguigu.spring.tx.UserAccountException;

public class BookshopDaoImpl implements BookshopDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void updateUserAccount(String username, int money) {
		String sql2 = "SELECT money FROM account WHERE name = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
		if(balance < money){
			throw new UserAccountException("余额不足!");
		}
		
		String sql = "UPDATE account SET money = money - ? WHERE name = ?";
		jdbcTemplate.update(sql, money, username);

	}

	@Override
	public int findBookPriceByIstn(String istn) {
		String sql = "SELECT book_price FROM book WHERE istn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, istn);
	}

	@Override
	public void updateBookStore(String istn) {
		// TODO Auto-generated method stub
		String sql2 = "SELECT stock FROM book_stock WHERE istn = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, istn);
		if(stock == 0){
			throw new BookStockException("库存不足!");
		}
		
		String sql = "UPDATE book_stock SET stock = stock -1 WHERE istn = ?";
		jdbcTemplate.update(sql, istn);

		
	}

}
