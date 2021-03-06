package com.jack.entity.vo;

public class MyCartItemVo {
	private String pid;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	private String pimage;
	private String pname;
	private Double price;
	private String scitemid;
	private String count;
	private String subtotal;


	@Override
	public String toString() {
		return "MyCartItemVo [pid=" + pid + ", pimage=" + pimage + ", pname=" + pname + ", price=" + price
				+ ", scitemid=" + scitemid + ", count=" + count + ", subtotal=" + subtotal + "]";
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
	public String getScitemid() {
		return scitemid;
	}
	public void setScitemid(String scitemid) {
		this.scitemid = scitemid;
	}
	
}
