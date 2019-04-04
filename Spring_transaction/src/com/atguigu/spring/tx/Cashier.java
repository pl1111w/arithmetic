package com.atguigu.spring.tx;

import java.util.List;

public interface Cashier {

	public void checkout(String name,List<String> istns);
}
