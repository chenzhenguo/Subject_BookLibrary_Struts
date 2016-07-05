package cn.sxt.action;


import java.util.List;
import java.util.Map;

import cn.sxt.dao.BookDao;
import cn.sxt.dao.impl.BookDaoImpl;
import cn.sxt.dao.impl.UserDaoImpl;
import cn.sxt.service.BookService;
import cn.sxt.service.CategoryService;
import cn.sxt.service.UserService;
import cn.sxt.service.impl.BookServiceImpl;
import cn.sxt.service.impl.CategoryServiceImpl;
import cn.sxt.service.impl.UserServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Book;
import cn.sxt.vo.Category;
import cn.sxt.vo.Record;
import cn.sxt.vo.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class BookAction {
	private  List<Book> list;
	private Book book;
	private BookService  bookService= new BookServiceImpl();
	private   Category category;
	private  List<Category>  categoryList;
	private Record  record; 
	private  User user;
	private PageUtil page;
	
	
//管理员界面书籍列表
	public String list(){
		
		
		//在最初的列表时page book 对象为空  要创建响应的对象时
		if(page==null){
			page = new PageUtil();
		}
		if(page.getCurrentPage()==0||page.getCurrentPage()<=0){
			page.setCurrentPage(1);
		}
		if(book==null){
			book = new Book();
		}
		
		System.out.println("book name"+book.getName());
		
		
		BookDao bd = new BookDaoImpl();
		page.setTotalCount(	bd.totalCount(book)); //获得总页数
			
		int countPage = bd.totalCount(book)%page.getPageSize()>0?bd.totalCount(book)/page.getPageSize()+1:bd.totalCount(book)/page.getPageSize();
		if(page.getCurrentPage()> countPage){
			page.setCurrentPage(countPage);
		}
		
		
		list=bookService.list(page,book);//根据page 和book的条件设置 列表内容

		categoryList = new CategoryServiceImpl().list();
		return  "list";
	}
	
	public String  toUpdate(){
		CategoryService category=  new CategoryServiceImpl();
		categoryList=category.list();

		book=bookService.getById(book.getId());
		return "update";	
	}
	public String  index(){
	Map<String,Object>  session=	ActionContext.getContext().getSession();
	
	UserService us= new UserServiceImpl();
	//通过获得session中的用户id获得这个用户的信息
		Object userId=	session.get("userId");
		int id = (Integer) userId;
		UserService userService = new UserServiceImpl();
			user=	userService.getById(id);
		return "index";
	}
	//如果是學生用戶，跳轉學生用戶界面
	public String  studentIndex(){
		Map<String,Object>  session=	ActionContext.getContext().getSession();
		
		UserService us= new UserServiceImpl();
		//通过获得session中的用户id获得这个用户的信息
		Object userId=	session.get("userId");
		int id = (Integer) userId;
		UserService userService = new UserServiceImpl();
		user=	userService.getById(id);
		System.out.println(user.getName());
		return " ";
	}
	
	
	
public String toAdd(){
	CategoryService category=  new CategoryServiceImpl();
	categoryList=category.list();
	return "toAdd";
}

//开始借书
public String bookBorrow(){
	BookService bs = new BookServiceImpl();
	if(record.getUserId()==0){
		return "borrowError";
	}
	
	
	
	System.out.println("start borrowing....");
	int i =bs.borrow(record);
	
	if(i>0){
		return "borrowSuccesss";
	}else{
		return "borrowError";
	}
	
}

//普通用户借书列表

	public String BookBorrowlist(){
		
		
		//在最初的列表时page book 对象为空  要创建响应的对象时
		if(page==null){
			page = new PageUtil();
		}
		if(page.getCurrentPage()==0||page.getCurrentPage()<=0){
			page.setCurrentPage(1);
		}
		if(book==null){
			book = new Book();
		}
		book.setBookNum(1);
		System.out.println("book name"+book.getName());
		
		
		BookDao bd = new BookDaoImpl();
		page.setTotalCount(	bd.totalCount(book)); //获得总页数
			
		int countPage = bd.totalCount(book)%page.getPageSize()>0?bd.totalCount(book)/page.getPageSize()+1:bd.totalCount(book)/page.getPageSize();
		if(page.getCurrentPage()> countPage){
			page.setCurrentPage(countPage);
		}
		
		
		list=bookService.list(page,book);//根据page 和book的条件设置 列表内容

		categoryList = new CategoryServiceImpl().list();
		return "BookBorrowlist";
	}
	


	public String delete(){ 
		
		if(bookService.delete(book.getId())>0){;
		return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public String update(){
		CategoryService category=  new CategoryServiceImpl();
		categoryList=category.list();
		
		
		
		if(bookService.update(book)>0){
			return Action.SUCCESS;
		};
		return Action.ERROR;
	}
	
	
	public String add(){
		
	if(	bookService.add(book)>0){
		return "success";
	};
		return "error";
	}
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
