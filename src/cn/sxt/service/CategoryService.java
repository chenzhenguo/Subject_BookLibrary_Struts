package cn.sxt.service;

import java.util.List;

import cn.sxt.vo.Book;
import cn.sxt.vo.Category;
import cn.sxt.vo.User;

public interface CategoryService {
	public int update(Category category);
	public List<Category> list();
	public int delete(int id);
	public int add(Category category);
	public Category getById(int id);
	
	
	
}
