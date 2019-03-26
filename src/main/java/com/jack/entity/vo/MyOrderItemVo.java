package com.jack.entity.vo;

public class MyOrderItemVo {
		//商品图片
		private String pimage;
		//商品名
		private String pname;
		//商品数量
		private int count;
		//商品价格
		private double price;
		//小计
		private double subtotal;
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
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(double subtotal) {
			this.subtotal = subtotal;
		}
		@Override
		public String toString() {
			return "MyOrderItemVo [pimage=" + pimage + ", pname=" + pname + ", count=" + count + ", price=" + price
					+ ", subtotal=" + subtotal + "]";
		}
		
		
}
