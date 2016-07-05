package cn.sxt.vo;

public class User {
	private Integer id;
	private  String name;
	private String password;
	private int roldId;
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoldId() {
		return roldId;
	}
	public void setRoldId(int roldId) {
		this.roldId = roldId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
