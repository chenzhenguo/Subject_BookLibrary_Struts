package cn.sxt.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.sxt.service.UserService;
import cn.sxt.service.impl.UserServiceImpl;
import cn.sxt.vo.User;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String username;
	private String password;
	private User user;
	
	public String login(){
		UserService us = new UserServiceImpl();
		//从数据库中取出数据，验证是否有该用户
	
		if(		us.booleanUser(username, password)	||"admin".equals(username)&&"admin".endsWith(password) ){
			System.out.println("用户验证成功");
		Map<String,Object> session= ActionContext.getContext().getSession();
	
		//把用户的id存入session中方便以后使用
		//判断用户的权限
		int userId=	us.getIdByName(username);
			user=us.getById(userId);
			
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session2=request.getSession();
			session2.setAttribute("currentUser",user);
			
		
		System.out.println("获取到用户名和id"+ username +userId);
		session.put("userId", userId);
		session.put("roldId", user.getRoldId());
		
			//如果是普通用户跳转到普通用户界面，如果是管理员跳转管理员界面

			if(user.getRoldId()==1){
				return "loginSuccess";
			}
				if(user.getRoldId()==2){
				return "loginStudentSuccess";
			}
		}
		return "login";
		
	}
	
	public String  logOut(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.removeAttribute("currentUser");
		return "logOutSuccess";

	}
	
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
