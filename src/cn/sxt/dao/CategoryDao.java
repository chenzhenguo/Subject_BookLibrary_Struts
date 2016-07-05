package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Category;

public interface CategoryDao {
	public int update(Category category);
	public List<Category> list();
	public int delete(int id);
	public int add(Category category);
	public Category getById(int id);
	
}
