package com.jack.entity;

public class Product {
    private String pid;

    private String pname;

    private Double price;

    private String pimage;

    private String pdesc;

    private Integer pnumber;

    private String cid;
    
    

    public Product() {
		super();
	}

	public Product(String pid, String pname, Double price, String pimage, String pdesc, Integer pnumber, String cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.pimage = pimage;
		this.pdesc = pdesc;
		this.pnumber = pnumber;
		this.cid = cid;
	}

	public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage == null ? null : pimage.trim();
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", pimage=" + pimage + ", pdesc="
				+ pdesc + ", pnumber=" + pnumber + ", cid=" + cid + "]";
	}
    
}