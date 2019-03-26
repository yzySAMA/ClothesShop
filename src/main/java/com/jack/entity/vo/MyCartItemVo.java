package com.jack.entity.vo;

public class MyCartItemVo {
	private String pimage;
	private String pname;
	private Double price;
	private String count;
	private String subtotal;

	@Override
	public String toString() {
		return "MyCartItemVo [pimage=" + pimage + ", pname=" + pname + ", price=" + price + ", count=" + count
				+ ", subtotal=" + subtotal + "]";
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	
}
