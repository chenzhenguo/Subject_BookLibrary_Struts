package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.CacheControl;

import cn.sxt.dao.UserDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.User;
import cn.sxt.vo.Category;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int update(User user) {
		String sql = "update b_user set name='"+user.getName()+"' ,password='"+user.getPassword()+"', roldId="+user.getRoldId()+"  where id="+user.getId();
		System.out.println(sql);
		return this.executeUpdate(sql);
	}

	@Override
	public List<User> list() {
		String sql = "select * from b_user ";
		List<User> list = new ArrayList<User>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRoldId(rs.getInt("roldId"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}

		return list.size() > 0 ? list : null;
	}
	
	public boolean booleanUser(String name ,String password){
		try{
			
		String sql ="select  name   from b_user where name  like '"+name +"' and password like '" +password+"'";
		System.out.println(sql);
		ResultSet rs=	this.executeQuery(sql);
				if(rs.next()){
					rs.getString("name");
					return true;
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return false;
	}


	@Override
	public int delete(int id) {
		String sql ="delete  from b_user where id="+id;
		return this.executeUpdate(sql);
	}

	@Override
	public int add(User user) {
		String sql = "insert into  b_user ( name,password,roldId) values('"
				+ user.getName()+"','"+user.getPassword()+"' ,2 )";
		return this.executeUpdate(sql);
	}


	public User getById(int id) {
		String sql ="select * from b_user where id="+id;
		ResultSet rs=this.executeQuery(sql);
		System.out.println("user getById>>"+sql);
		User user = new User();
	try {
		if(rs.next()){
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setRoldId(rs.getInt("roldId"));
			System.out.println(user.getId()+user.getName()+"---"+user.getPassword());
			return  user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
	return  null;
	}

	@Override
	public boolean booleanName(String name) {
		try{
			String sql ="select  name from b_user where name  like '"+name +"'";
			ResultSet rs=	this.executeQuery(sql);
				return	rs.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.close();
			}
			return false;
	}

	@Override
	//通过用户名找用户id
	
	public int getIdByName(String name) {
		String sql = "select id from b_user where name like '"+name+"'";
		System.out.println(sql);
		ResultSet rs =this.executeQuery(sql);
		
		try {
			if(rs.next()){
			return	rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return -1;
	}

}
