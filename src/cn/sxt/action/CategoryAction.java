package cn.sxt.action;

import java.util.List;

import cn.sxt.service.CategoryService;
import cn.sxt.service.impl.CategoryServiceImpl;
import cn.sxt.vo.Category;
import cn.sxt.vo.User;

public class CategoryAction {
	private Category category;
private List<Category> list;
	CategoryService cs= new CategoryServiceImpl();
	
	public String list(){

		list=	cs.list();
		return "list";
	}
	
	public String add(){
		
		if(cs.add(category)>0){
			
			return "success";
		}else{
			return "error";
		}
	}
	
	public String delete(){
		
		if(cs.delete(category.getId())>0){
			return"success";
		}else{
			return "error";
		}
		
	
	}
	
	public String toUpdate(){
		category=cs.getById(category.getId());
	
		return "update";
	}
	public String update(){
		if(cs.update(category)>0){
			return "success";
		}else{
			return"error";
		}
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public CategoryService getCs() {
		return cs;
	}

	public void setCs(CategoryService cs) {
		this.cs = cs;
	}
	
	
	

	
	
	
	

}
