package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Book;
import cn.sxt.vo.User;

public interface UserDao {
	public int update(User book);
	public List<User> list();
	public int delete(int id);
	public int add(User user);
	public User getById(int id);
	//验证用户登陆是否登陆成功
	public boolean  booleanUser(String name,String password);
	//验证用户名是否重复
	public boolean  booleanName(String name);
	public int getIdByName(String name);
	
}
