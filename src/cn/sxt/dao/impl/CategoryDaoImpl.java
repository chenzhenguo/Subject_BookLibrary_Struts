package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.CacheControl;

import cn.sxt.dao.CategoryDao;
import cn.sxt.dao.CategoryDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Category;
import cn.sxt.vo.Category;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public int update(Category category) {
		String sql = "update b_category set name='"+category.getName()+"'where id="+category.getId();
		System.out.println(sql);
		return this.executeUpdate(sql);
	}

	@Override
	public List<Category> list() {
		String sql = "select * from b_category ";
		List<Category> list = new ArrayList<Category>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}

		System.out.println("category size>>"+list.size());
		return list.size() > 0 ? list : null;
	}

	@Override
	public int delete(int id) {
		String sql ="delete  from b_category where id="+id;
		return this.executeUpdate(sql);
	}

	@Override
	public int add(Category category) {
		String sql = "insert into  b_category ( name) values('"
				+ category.getName()+"')";
		return this.executeUpdate(sql);
	}


	public Category getById(int id) {
		String sql ="select * from b_category where id="+id;
		ResultSet rs=this.executeQuery(sql);
		Category category = new Category();
		
	try {
		if(rs.next()){
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
	return  category;
	}

}
