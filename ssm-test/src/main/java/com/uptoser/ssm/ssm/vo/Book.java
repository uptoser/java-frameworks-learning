package com.uptoser.ssm.ssm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;


@ApiModel
public class Book {

	@NotNull
	private String id;
	@NotBlank
	@Size(min=10,max=20)
	@Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message="手机号格式不正确")
	@ApiModelProperty(value = "状态码,0表示成功 其他表示失败")
	private String name;
	@Email
	@ApiModelProperty(value = "页数")
	private String pageCount;
	@Max(value=300,message="不能超300啊")
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pageCount=" + pageCount + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pageCount == null) ? 0 : pageCount.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pageCount == null) {
			if (other.pageCount != null)
				return false;
		} else if (!pageCount.equals(other.pageCount))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

}
