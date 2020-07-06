package fa.training.restful.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity @Table(name="Product") 
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private String name;
	private Double price;
	private String des;
	private String detail;
	private String image;
	private int instock;
	private String manufactor;
	private String code;
	private String category;
	public long getId() { return id;
	}
	public void setId(long id) {
	this.id = id;
	}
	public int getInstock() {  return instock;
	}
	public void setInstock(int instock) {
	this.instock = instock;
	}
	public String getCode() {  return code;
	}
	public void setCode(String code) {
	this.code = code;
	}
	public String getCategory() {  return category;
	}
	public void setCategory(String category) {
	this.category = category;
	}
	
	public String getManufactor() {  return manufactor;
	}
	public void setManufactor(String manufactor) {
	this.manufactor = manufactor;
	}
	
	public Double getPrice() { return price;
	
	}
	public void setPrice(Double price) { 
		this.price = price;
	} 
	public String getName() {
		return name;
	}
	public void setName(String name) 
	{
	this.name = name;
	}
	public String getDetail() {
	return detail;
	}
	public void setDetail(String detail) { 
		this.detail =  detail;
	} 
	public String getImage() {
		return image;
		}
	public void setImage(String image) { 
			this.image = image;
		} 
	public String getDes() {
		return des;
		}
	public void setDes(String des) { 
			this.des = des;
		} 
}