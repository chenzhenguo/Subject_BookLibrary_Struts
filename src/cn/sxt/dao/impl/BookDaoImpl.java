package cn.sxt.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.CacheControl;

import org.junit.Test;

import cn.sxt.dao.BookDao;
import cn.sxt.util.BaseDao;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Book;
import cn.sxt.vo.Category;
import cn.sxt.vo.Record;

public class BookDaoImpl extends BaseDao implements BookDao {
	Record r = new Record();

	@Override
	public int update(Book book) {

		String sql = "update b_book set name='"+book.getName()+"',price='"+book.getPrice()+"',author='"+book.getAuthor()+"',bookNum='"+book.getBookNum()+"',publish='"+book.getPublish()+"',pubDate='"+new  SimpleDateFormat("yyyy-MM-dd").format(book.getPubDate())+"',categoryId='"+book.getCategoryId()+"'where id="+book.getId();
		System.out.println(sql);
		return this.executeUpdate(sql);
	}
	
	
	//借书
	public int borrow(Record r){
		//获取当前时间
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(currentTime);
			String date2 =formatter.format(date);
		//判断书籍数量是否大于零
		
		String sql="select  bookNum  from b_book where id="+r.getBookId();

			ResultSet rs=	this.executeQuery(sql);
			try {
				if(rs.next()){
					int bookNum=	rs.getInt("bookNum");
					if(bookNum>0){
					sql="update b_book set bookNum = "+(bookNum-1) +" where id= "+r.getBookId();
					System.out.println(sql);
					int i=	this.executeUpdate(sql);
					sql="insert into b_record (bookId ,userId,date,status)values ("+r.getBookId()+","+r.getUserId()+",'"+date2+"',"+r.getStatus()+")";
					System.out.println(sql);
				i=	this.executeUpdate(sql);
				return i;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.close();
			}
		return -1;
	}
	
	//还书
	public int backBook(int bookId ,int userId){
		//获取当前时间
				long currentTime = System.currentTimeMillis();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date(currentTime);
				String date2 =formatter.format(date);
	String	sql="insert into b_record (bookId ,userId,date,status)values ("+bookId+","+userId+",'"+date2+"',"+1+")";
	System.out.println(sql);
	int i=	this.executeUpdate(sql);
	sql="update b_book set bookNum = 1 where id= "+bookId;
	this.executeUpdate(sql);
	
	if(i>0){
		System.out.println("还书成功");
	}else{
		System.out.println("还书失败");
	}
	return i;
	
	}
	
	
	

	@Override
	public List<Book> list(PageUtil pu,Book bk) {
	StringBuffer sql =new StringBuffer("select  b.id  id,b.name name , b.price price ,   b.bookNum bookNum , b.author author ,b.publish publish ,c.name categoryName  ,c.id categoryId  , b.pubdate pubdate  from b_book  b ,b_category c where b.categoryId=c.id ");
	if(bk.getAuthor()!=null&&bk.getAuthor().trim().length()>0){
		sql.append("and b.author='").append(bk.getAuthor()).append("'");
	}
	if(bk.getName()!=null&&bk.getName().trim().length()>0){
		sql.append(" and b.name='").append(bk.getName()).append("'");
		
	}
	if(bk.getBookNum()==1){
		sql.append(" and b.bookNum=1");
	}
	
	
	if(bk.getCategoryId()!=0){
		sql.append(" and b.categoryId=").append(bk.getCategoryId());
		
	}
	if(bk.getPublish()!=null&&bk.getPublish().trim().length()>0){
		sql.append(" and b.publish='").append(bk.getPublish()).append("'");
	}
	sql.append(" limit ").append((pu.getCurrentPage()-1)*pu.getPageSize()).append(",").append(pu.getPageSize());
	System.out.println(sql);
		
		
		List<Book> list = new ArrayList<Book>();
		ResultSet rs = this.executeQuery(sql.toString());
		try {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setBookNum(rs.getInt("bookNum"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setCategoryId(rs.getInt("categoryId"));
				book.setCategoryName(rs.getString("categoryName"));
		
				book.setPubDate(rs.getDate("pubDate"));
				list.add(book);
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
		String sql ="delete  from b_book where id="+id;
		return this.executeUpdate(sql);
	}

	@Override
	public int add(Book book) {
		String sql = "insert into  b_book ( name,price,author,categoryId,  bookNum,publish,pubDate) values('"
				+ book.getName()
				+ "',"
				+ book.getPrice()
				+ ",'"
				+ book.getAuthor() + "','" + book.getCategoryId()+ "','"+book.getBookNum()+ "','"+ book.getPublish() + "','"+ new  SimpleDateFormat("yyyy-MM-dd").format(book.getPubDate()) + "')";
		return this.executeUpdate(sql);
	}


	public Book getById(int id) {
		String sql ="select * from b_book where id="+id;
		ResultSet rs=this.executeQuery(sql);
		Book book = new Book();
	try {
		if(rs.next()){
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setPrice(rs.getDouble("price"));
			book.setAuthor(rs.getString("author"));
			book.setBookNum(rs.getInt("bookNum"));
			book.setPublish(rs.getString("publish"));
			book.setCategoryId(rs.getInt("categoryId"));
			book.setPubDate(rs.getDate("pubDate"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
	return  book;
	}


	@Override
	public int totalCount(Book bk) {
		StringBuffer sql =new StringBuffer("select count(id) cnt from b_book  b where  1=1 ");
		if(bk.getName()!=null&&bk.getName().trim().length()>0){
			sql.append(" and b.name= '").append(bk.getName()).append("'");
		}
		if(bk.getBookNum()!=0&&bk.getBookNum()==1){
			sql.append("and b.bookNum= 1");
		}
		
		if(bk.getAuthor()!=null&&bk.getAuthor().trim().length()>0){
			sql.append(" and b.author='").append(bk.getAuthor()).append("'");
		}
		if(bk.getCategoryId()!=0){
			sql.append(" and  b.categoryId=").append(bk.getCategoryId());
		}
		if(bk.getPublish()!=null&&bk.getAuthor().trim().length()>0){
			sql.append(" and b.publish='").append(bk.getPublish()).append("'");
		}
		System.out.println(sql);
		ResultSet rs= this.executeQuery(sql.toString());
		try {
			if(rs.next()){
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return 0;
	}
}
