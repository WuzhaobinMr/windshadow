package com.windshadow.Pojo;

public class Sort_film {
    //电影类别关系表

    private int id;  //关系ID
    private int fid; //电影ID
    private int sid; //类别ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
