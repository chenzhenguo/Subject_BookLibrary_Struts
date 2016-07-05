package cn.sxt.action;

import java.util.List;

import cn.sxt.service.UserService;
import cn.sxt.service.impl.UserServiceImpl;
import cn.sxt.vo.User;

public class UserAction {
	private User user;
private List<User> list;
	UserService us= new UserServiceImpl();
	
	public String list(){
		list=	us.list();
		return "list";
	}
	public String add(){
		
		if(us.add(user)>0){
			
			return "success";
		}else{
			return "error";
		}
	}
	
	public String delete(){
		
		if(us.delete(user.getId())>0){
			return"success";
		}else{
			return "error";
		}
		
	
	}
	
	public String toUpdate(){
		user=us.getById(user.getId());
	
		return "update";
	}
	public String update(){
		if(us.update(user)>0){
			return "success";
		}else{
			return"error";
		}
	}
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	
	

}
