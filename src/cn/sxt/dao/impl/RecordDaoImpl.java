package cn.sxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.CacheControl;

import cn.sxt.bean.RecordBean;
import cn.sxt.dao.BookDao;
import cn.sxt.dao.RecordDao;
import cn.sxt.util.BaseDao;
import cn.sxt.vo.Book;
import cn.sxt.vo.Category;
import cn.sxt.vo.Record;

public class RecordDaoImpl extends BaseDao implements RecordDao {
	
	@Override
	public int update(Record record) {
		String sql = "update b_record set bookId='"+record.getBookId()+"',userId='"+record.getUserId()+"',status='"+record.getStatus()+"',date='"+record.getDate()+"'where id="+record.getId();
		System.out.println(sql);
		return this.executeUpdate(sql);
	}
	
	
	//获取我的书包列表
	public List<RecordBean> getMyBookList(int userId){
		String sql=" SELECT   b.id bookId , u.name userName,    b.name bookName  ,  b.price price  ,    b.author author    ,  r.date date   from    b_record r ,b_book b  ,b_user u    where  r.userId =  " +userId+" and r.bookId =b.id and  r.userId =u.id  GROUP BY bookId HAVING count(*) =1 ";
		System.out.println(sql);
		List<RecordBean> list= new ArrayList();
		ResultSet rs=	this.executeQuery(sql);
		try {
			while(rs.next()){
				RecordBean rb= new RecordBean();
				rb.setBookId(rs.getInt("bookId"));
				rb.setBookName(rs.getString("bookName"));
				rb.setUserName(rs.getString("userName"));
				rb.setPrice(rs.getDouble("price"));
				rb.setAuthor(rs.getString("author"));
				rb.setDate(rs.getDate("date"));
					list.add(rb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return list.size()>0?list:null;
		
	}
	
	
	
	
	
	
	

	@Override
	public List<RecordBean> list() {
		String sql = "select   r.id , b.name  bookname, u.name  username, r.status, r.date   from     b_record r ,b_book  b,b_user  u where r.bookId=b.id and u.id= r.userId ";
		List<RecordBean> list = new ArrayList<RecordBean>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				RecordBean rb = new RecordBean();
				rb.setId(rs.getInt("id"));
				rb.setBookName(rs.getString("bookName"));
				rb.setUserName(rs.getString("userName"));
				rb.setStatus(rs.getInt("status"));
				rb.setDate(rs.getDate("date"));
				list.add(rb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list.size() > 0 ? list : null;
	}
	
	//获取学生个人借书记录
	public List<RecordBean> StudentList(int userId) {
		String sql = "select   r.id , b.name  bookname, u.name  username, r.status, r.date   from     b_record r ,b_book  b,b_user  u where r.bookId=b.id and u.id= r.userId  and u.id ="+userId;
		List<RecordBean> list = new ArrayList<RecordBean>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				RecordBean rb = new RecordBean();
				rb.setId(rs.getInt("id"));
				rb.setBookName(rs.getString("bookName"));
				rb.setUserName(rs.getString("userName"));
				rb.setStatus(rs.getInt("status"));
				rb.setDate(rs.getDate("date"));
				list.add(rb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list.size() > 0 ? list : null;
	}

	
	
	
	
	
	@Override
	public int delete(int id) {
		String sql ="delete  from b_record where id="+id;
		return this.executeUpdate(sql);
	}

	@Override
	public int add(Record record) {
		String sql = "insert into  b_record ( bookId,userId,status,date) values("+record.getBookId()+","+record.getUserId()+","+record.getStatus()+","+record.getDate()+")";		
		return this.executeUpdate(sql);
	}


	public Record getById(int id) {
		String sql ="select * from b_record where id="+id;
		ResultSet rs=this.executeQuery(sql);
		Record rb = new Record();
	try {
		if(rs.next()){
			
			rb.setId(rs.getInt("idb."));
			rb.setBookId(rs.getInt("bookId"));
			rb.setStatus(rs.getInt("status"));
			rb.setUserId(rs.getInt("userId"));
			rb.setDate(rs.getDate("date"));
			}
		return rb;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
	return null;
	}

}
