package cn.sxt.dao;

import java.util.List;

import cn.sxt.bean.RecordBean;
import cn.sxt.vo.Record;

public interface RecordDao {
	public int update(Record record);
	public List<RecordBean> list();
	public int delete(int id);
	public int add(Record record);
	public Record getById(int id);
	//��ȡ�û��ĸ����鼮
	public List<RecordBean> getMyBookList(int userId);
	//��ȡ�û����˽����¼
	public List<RecordBean> StudentList(int userId);
	
}
