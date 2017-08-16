package cn.babasport.pojo;

import java.io.Serializable;
/**
 * 商品品牌
 * @author Administrator
 *
 */
public class Brand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//品牌id
	private Long id;
	//品牌的名称
	private String name;
	//如偏url
	private String imgUrl;
	//品牌描述
	private String description;
	//排序,越大越靠前
	private Integer sort;

	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	
	//是否可用,0不可用,1可用
	private Integer isDisplay;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", imgUrl=" + imgUrl + ", description=" + description
				+ ", isDisplay=" + isDisplay + "]";
	}
	
	
}
