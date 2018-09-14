package com.windshadow.Pojo;

public class People_film {
    //电影人物参与关系表

    private int id; //关系ID
    private int fid; //电影ID
    private int pid; //人物ID

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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
