package com.atguigu.spring.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		namedParameterJdbcTemplate=(NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}
	/*����Ϊ����������*/
	//@Test
    public void testNamedParameterJdbcTemplate (){
    	String sql="insert into user (name,pwd,email) values(:na,:pd,:em)";
    	Map<String, Object> paramMap=new HashMap<>();
    	paramMap.put("na","xiaoqi");
    	paramMap.put("em","@abc2");
    	paramMap.put("pd","i7");
    	
    	namedParameterJdbcTemplate.update(sql, paramMap);
    	 
    }
	/*ʹ�þ�������ʱ������ʹ��update(Sring sql,  SqlParameterSource paramSource);���в���
	 * SQL����������������һ��
	 * ʹ��SqlParameterSource��BeanPropertySqlParameterSource��Ϊʵ�������*/
	//@Test
    public void testNamedParameterJdbcTemplate2 (){
    	String sql="insert into department (Name) values(:name)";
    	Department department=new Department();
    	//department.setId(3);
    	department.setName("������");
    	SqlParameterSource paramSource=new BeanPropertySqlParameterSource(department);
    	namedParameterJdbcTemplate.update(sql, paramSource);
    	 
    }
	// ����һ��
	// @Test
	public void testUpdate() {
		String sql = "update stu set name=? where id=?";
		jdbcTemplate.update(sql, "wifepyt", 4);
	}

	// ��������
	// @Test
	public void testBatchUpdate() {
		String sql = "insert into student (name,age) value(?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] { "³��", "8" });
		batchArgs.add(new Object[] { "����", "9" });
		batchArgs.add(new Object[] { "����", "18" });
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

	// �����ݿ��ȡһ����¼��ʵ�ʵõ�һ������
	// @Test
	public void testQueryforObject() {
		String sql = "select id, name,age,deptid from employee where id= ?";
		// String sql =
		// "SELECT id, last_name lastName, email, dept_id as \"department.id\" FROM employees WHERE id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(
				Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);

		System.out.println(employee);
	}

	// �����ݿ��ȡ���м�¼��ʵ�ʵõ�һ������
	//@Test
	public void testQueryforList() {
		String sql = "select * from employee";
		RowMapper<Employee> rowmapper = new BeanPropertyRowMapper<>(
				Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowmapper);
		System.out.println(employees);
	}

	// �����ݿ��ȡ����ֵ������ͳ������
	//@Test
	public void testQueryForObject() {
       String sql="select count(id) from employee";
       long count=jdbcTemplate.queryForObject(sql, Long.class);
       System.out.println(count);
	}

	// @Test
	public void test() throws Exception {

		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
