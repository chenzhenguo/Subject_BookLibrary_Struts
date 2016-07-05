package cn.sxt.dao;

import java.util.List;

import cn.sxt.util.PageUtil;
import cn.sxt.vo.Book;
import cn.sxt.vo.Record;

public interface BookDao {
	public int update(Book book);
	public List<Book> list(PageUtil pu,Book bk);
	public int delete(int id);
	public int add(Book book);
	public Book getById(int id);
	public int borrow(Record r);
	public int totalCount(Book bk);
	public int backBook(int bookId ,int userId);
	
}
