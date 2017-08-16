package cn.babasport.pojo;

import java.io.Serializable;
import java.sql.Date;
/**
 * 测试实体类
 * @author Administrator
 *
 */
public class TestTb implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; //编号
	private String name; //姓名
	private Date birthday; //生日
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
