package cn.sxt.test;

import cn.sxt.dao.UserDao;
import cn.sxt.dao.impl.UserDaoImpl;
import cn.sxt.vo.User;

public class BorrowTest {
public static void main(String[] args) {
	
	
	UserDao ud= new UserDaoImpl();
	User u = new User ();
	int id=	ud.getIdByName("cc");
	System.out.println(id);
	
	

	

	
	
	
}

}
