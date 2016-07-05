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
	
	
//����Ա�����鼮�б�
	public String list(){
		
		
		//��������б�ʱpage book ����Ϊ��  Ҫ������Ӧ�Ķ���ʱ
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
		page.setTotalCount(	bd.totalCount(book)); //�����ҳ��
			
		int countPage = bd.totalCount(book)%page.getPageSize()>0?bd.totalCount(book)/page.getPageSize()+1:bd.totalCount(book)/page.getPageSize();
		if(page.getCurrentPage()> countPage){
			page.setCurrentPage(countPage);
		}
		
		
		list=bookService.list(page,book);//����page ��book���������� �б�����

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
	//ͨ�����session�е��û�id�������û�����Ϣ
		Object userId=	session.get("userId");
		int id = (Integer) userId;
		UserService userService = new UserServiceImpl();
			user=	userService.getById(id);
		return "index";
	}
	//����ǌW���Ñ������D�W���Ñ�����
	public String  studentIndex(){
		Map<String,Object>  session=	ActionContext.getContext().getSession();
		
		UserService us= new UserServiceImpl();
		//ͨ�����session�е��û�id�������û�����Ϣ
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

//��ʼ����
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

//��ͨ�û������б�

	public String BookBorrowlist(){
		
		
		//��������б�ʱpage book ����Ϊ��  Ҫ������Ӧ�Ķ���ʱ
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
		page.setTotalCount(	bd.totalCount(book)); //�����ҳ��
			
		int countPage = bd.totalCount(book)%page.getPageSize()>0?bd.totalCount(book)/page.getPageSize()+1:bd.totalCount(book)/page.getPageSize();
		if(page.getCurrentPage()> countPage){
			page.setCurrentPage(countPage);
		}
		
		
		list=bookService.list(page,book);//����page ��book���������� �б�����

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
