package com.jack.entity;

public class Shopcart {
    private String scid;

    private String uid;

    private String scitemid;

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid == null ? null : scid.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getScitemid() {
        return scitemid;
    }

    public void setScitemid(String scitemid) {
        this.scitemid = scitemid == null ? null : scitemid.trim();
    }
}