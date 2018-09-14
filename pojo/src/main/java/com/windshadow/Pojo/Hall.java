package com.windshadow.Pojo;

public class Hall {

    //放映大厅表

    private int id;//放映大厅编号

    private String name;//放映大厅名称

    private int pid;//座位实体类

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
