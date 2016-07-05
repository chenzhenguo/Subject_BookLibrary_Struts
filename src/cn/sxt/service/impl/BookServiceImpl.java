package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.BookDao;
import cn.sxt.dao.impl.BookDaoImpl;
import cn.sxt.service.BookService;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Book;
import cn.sxt.vo.Record;

public class BookServiceImpl implements BookService{
		BookDao bd = new BookDaoImpl();
	@Override
	public int update(Book book) {
		return bd.update(book);
		
	}
	
	public int borrow(Record r){
		return bd.borrow(r);
	}

	@Override
	public List<Book> list(PageUtil pu,Book bk) {
		
		return bd.list(pu, bk);
	}

	@Override
	public int delete(int id) {
		
		return bd.delete(id);
	}

	@Override
	public int add(Book book) {

		return bd.add(book);
	}
	@Override
	public Book getById(int id) {
		return  bd.getById(id);
	
	}
		
}
