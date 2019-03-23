package com.jack.entity;

public class Scitem {
    private String scitemid;

    private String count;

    private String subtotal;

    private String pid;

    private String scid;

    public String getScitemid() {
        return scitemid;
    }

    public void setScitemid(String scitemid) {
        this.scitemid = scitemid == null ? null : scitemid.trim();
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal == null ? null : subtotal.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid == null ? null : scid.trim();
    }
}