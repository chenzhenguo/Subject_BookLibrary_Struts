package cn.sxt.util;



public class PageUtil {
	//每页显示记录数
	private int pageSize= Constants.PAGE_SIZE;
	//总记录数
	private int totalCount;
	//总页数
	private int totalPage;
	//当前页
	private int currentPage;
	
	public int getPageSize(){
		 return this.pageSize=pageSize;
	}
	
	public   void setPageSize(int pageSize){
		this.pageSize =pageSize;
			
	}
	public int getTotalCount(){
		return totalCount;
	}
	public void setTotalCount(int totalCount){
		this.totalCount=totalCount;
	}
	public int getTotalPage(){
		totalPage=totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
		return totalPage;
	}
	public int getCurrentPage(){
		return currentPage;
	}
	public void setCurrentPage(int currentPage){
		this.currentPage=currentPage;
	}
}
