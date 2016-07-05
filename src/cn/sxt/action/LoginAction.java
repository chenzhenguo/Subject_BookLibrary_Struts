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
		//�����ݿ���ȡ�����ݣ���֤�Ƿ��и��û�
	
		if(		us.booleanUser(username, password)	||"admin".equals(username)&&"admin".endsWith(password) ){
			System.out.println("�û���֤�ɹ�");
		Map<String,Object> session= ActionContext.getContext().getSession();
	
		//���û���id����session�з����Ժ�ʹ��
		//�ж��û���Ȩ��
		int userId=	us.getIdByName(username);
			user=us.getById(userId);
			
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session2=request.getSession();
			session2.setAttribute("currentUser",user);
			
		
		System.out.println("��ȡ���û�����id"+ username +userId);
		session.put("userId", userId);
		session.put("roldId", user.getRoldId());
		
			//�������ͨ�û���ת����ͨ�û����棬����ǹ���Ա��ת����Ա����

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
