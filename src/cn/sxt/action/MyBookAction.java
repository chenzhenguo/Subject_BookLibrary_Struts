package cn.sxt.action;

import java.util.List;
import java.util.Map;

import cn.sxt.bean.RecordBean;
import cn.sxt.dao.BookDao;
import cn.sxt.dao.RecordDao;
import cn.sxt.dao.impl.BookDaoImpl;
import cn.sxt.dao.impl.RecordDaoImpl;
import cn.sxt.service.UserService;
import cn.sxt.service.impl.UserServiceImpl;
import cn.sxt.vo.Book;
import cn.sxt.vo.User;

import com.opensymphony.xwork2.ActionContext;

public class MyBookAction {
	private  Book book;
	private User user;
	List<RecordBean>	list;
	
	//��ȡ�����û����鼮�б�
	public String list(){
		int userId=(Integer)	ActionContext.getContext().getSession().get("userId");
		//ͨ�����session�е��û�id�������û�����Ϣ
			UserService userService = new UserServiceImpl();
				user=	userService.getById(userId);
				
				RecordDao  rd = new RecordDaoImpl();
				list=	rd.getMyBookList(userId);
				return "list";
		}
	
	public String backBook(){
	BookDao bd = new BookDaoImpl();
	System.out.println("��ʼ����"+book.getId()+"--"+user.getId());
		if(	bd.backBook(book.getId(), user.getId())>0){
			return "success";
		}else{
			return "error";
		}
		
	}
	


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public User getUser() {
		return user;
	}
	


	public List<RecordBean> getList() {
		return list;
	}


	public void setList(List<RecordBean> list) {
		this.list = list;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
