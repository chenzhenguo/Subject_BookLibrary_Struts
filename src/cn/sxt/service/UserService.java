package cn.sxt.service;

import java.util.List;

import cn.sxt.vo.Book;
import cn.sxt.vo.User;

public interface UserService {
	public int update(User user);
	public List<User> list();
	public int delete(int id);
	public int add(User user);
	public User getById(int id);
	//��֤�û���½�Ƿ��½�ɹ�
		public boolean  booleanUser(String name ,String password);
		//��֤�û����Ƿ��ظ�
		public boolean  booleanName(String name);
	
		public int getIdByName(String name);
	
}
