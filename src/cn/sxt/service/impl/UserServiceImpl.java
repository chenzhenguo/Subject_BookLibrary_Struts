package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.UserDao;
import cn.sxt.dao.impl.UserDaoImpl;
import cn.sxt.service.UserService;
import cn.sxt.vo.User;

public class UserServiceImpl implements UserService{
		UserDao bd = new UserDaoImpl();
	@Override
	public int update(User user) {
		return bd.update(user);
		
	}

	@Override
	public List<User> list() {
		
		return bd.list();
	}

	@Override
	public int delete(int id) {
		
		return bd.delete(id);
	}

	@Override
	public int add(User user) {

		return bd.add(user);
	}

	@Override
	public User getById(int id) {
		return  bd.getById(id);
	
	}

	@Override
	public boolean booleanUser(String name ,String password) {
		
		return bd.booleanUser(name, password);
	}

	@Override
	public boolean booleanName(String name) {
	
		return bd.booleanName(name);
	}

	@Override
	public int getIdByName(String name) {
		
		return bd.getIdByName(name);
	}
		
}
