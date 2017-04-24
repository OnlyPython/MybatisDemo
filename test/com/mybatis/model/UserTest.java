package com.mybatis.model;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.inter.IUserOperation;


public class UserTest {
	static SqlSessionFactory sqlSessionFactory;
	static Reader reader;
	
	static{
		try{
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	 public static void main(String[] args) {
		 SqlSession session = sqlSessionFactory.openSession();
		 IUserOperation userOperation = session.getMapper(IUserOperation.class);
		 List<User> userList = userOperation.selectUserList("zhangsan");
//		 User user = userOperation.selectUserByID(1);
		 User user = userList.get(0);
//		 User user = session.selectOne("com.mybatis.models.UserMapper.selectUserByID", 1);
		 System.out.println(user.getId());
		 System.out.println(user.getUserName());
		 System.out.println(user.getUserAge());
		 System.out.println(user.getUserAddress());
		 session.close();
	 }
	 
	@Test
	public void testSelect() {
		SqlSession session = sqlSessionFactory.openSession();
		IUserOperation userOperation = session.getMapper(IUserOperation.class);
		User user = userOperation.selectUserByID(1);
		assertEquals("zhangsan", user.getUserName());
		session.close();
	}
	
	@Test
	public void testSelectList() {
		SqlSession session = sqlSessionFactory.openSession();
		IUserOperation userOperation = session.getMapper(IUserOperation.class);
		List<User> userList = userOperation.selectUserList("zhang%");
		assertEquals("zhangsan", userList.get(0).getUserName());
		session.close();
	}
	
	@Test
	public void testAdd() {
		User user = new User();
		user.setUserName("lisi");
		user.setUserAge(25);
		user.setUserAddress("Shanghai");
		SqlSession session = sqlSessionFactory.openSession();
		IUserOperation userOperation = session.getMapper(IUserOperation.class);
		userOperation.addUser(user);
		session.commit();
		session.close();
	}
	
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(3);
		user.setUserName("wangwu");
		user.setUserAge(25);
		user.setUserAddress("Dalian");
		SqlSession session = sqlSessionFactory.openSession();
		IUserOperation userOperation = session.getMapper(IUserOperation.class);
		userOperation.updateUser(user);
		session.commit();
		session.close();
	}
	
	@Test
	public void testDelete() {
		SqlSession session = sqlSessionFactory.openSession();
		IUserOperation userOperation = session.getMapper(IUserOperation.class);
		userOperation.deleteUser(5);
		session.commit();
		session.close();
	}
	
	@Test
	public void testSelectUserArticle() {
		SqlSession session = sqlSessionFactory.openSession();
		IUserOperation userOperation = session.getMapper(IUserOperation.class);
		List<Article> userArticlers = userOperation.getUserArticlers(1);
		for(Article article: userArticlers){
			System.out.println("文章作者：" + article.getUser().getUserName());
			System.out.println("文章作者地址：" + article.getUser().getUserAddress());
		}
		session.close();
	}
}
