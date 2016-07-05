package cn.sxt.service.impl;

import java.util.List;

import cn.sxt.dao.CategoryDao;
import cn.sxt.dao.impl.CategoryDaoImpl;
import cn.sxt.service.CategoryService;
import cn.sxt.vo.Category;

public class CategoryServiceImpl implements CategoryService{
		CategoryDao bd = new CategoryDaoImpl();
	@Override
	public int update(Category category) {
		return bd.update(category);
	}
	@Override
	public List<Category> list() {
		
		return bd.list();
	}

	@Override
	public int delete(int id) {
		
		return bd.delete(id);
	}

	@Override
	public int add(Category category) {

		return bd.add(category);
	}

	
	@Override
	public Category getById(int id) {
		return  bd.getById(id);
	}
		
}
