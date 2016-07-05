package cn.sxt.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.sxt.bean.RecordBean;
import cn.sxt.dao.RecordDao;
import cn.sxt.dao.impl.RecordDaoImpl;
import cn.sxt.service.UserService;
import cn.sxt.service.impl.UserServiceImpl;
import cn.sxt.vo.Record;
import cn.sxt.vo.User;

public class RecordAction {
	private RecordBean rb;
	RecordDao rd = new RecordDaoImpl();
	private List<RecordBean>  list;
	private User user;
	
	public String list(){
		int userId=(Integer)	ActionContext.getContext().getSession().get("userId");
		//通过获得session中的用户id获得这个用户的信息
			UserService userService = new UserServiceImpl();
				user=	userService.getById(userId);
		
	list=	rd.list();
		return "list";
	}
	
	
	public String studentList(){
		int userId=(Integer)	ActionContext.getContext().getSession().get("userId");
		//通过获得session中的用户id获得这个用户的信息
			UserService userService = new UserServiceImpl();
				user=	userService.getById(userId);
		
	list=rd.StudentList(user.getId());
		return "studentList";
	}
	
	
	
	
	
	
	

	public RecordBean getRb() {
		return rb;
	}

	public void setRb(RecordBean rb) {
		this.rb = rb;
	}

	public RecordDao getRd() {
		return rd;
	}

	public void setRd(RecordDao rd) {
		this.rd = rd;
	}
	public List<RecordBean> getList() {
		return list;
	}
	public void setList(List<RecordBean> list) {
		this.list = list;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
