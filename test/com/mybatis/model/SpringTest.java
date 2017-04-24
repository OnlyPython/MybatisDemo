package com.mybatis.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.inter.IUserOperation;

public class SpringTest {
	static ApplicationContext ctx;
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void test() {
		IUserOperation userMapper = (IUserOperation) ctx.getBean("userMapper");
		User user = userMapper.selectUserByID(1);
		assertEquals("zhangsan", user.getUserName());
	}

}
