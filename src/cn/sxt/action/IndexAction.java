package cn.sxt.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import net.sf.json.JSONArray;
import cn.sxt.service.BookService;
import cn.sxt.service.impl.BookServiceImpl;
import cn.sxt.vo.Book;

public class IndexAction {
	 private int uuid;
	 private String address;
	 private List<Book> list;

	public String returnList(){
		
		BookService bs= new BookServiceImpl();

		return "bookList";
	}
	
	
	

}
