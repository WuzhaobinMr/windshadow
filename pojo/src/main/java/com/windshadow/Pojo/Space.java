package com.windshadow.Pojo;

import java.util.Date;

public class Space {
    //场次表

    private int id;//场次编号
    private Date date;//放映日期
    private Date time;//放映时间
    private Double ticketprice;//票价
    private Film fid;//放映电影
    private Hall hall;//放映大厅

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Double ticketprice) {
        this.ticketprice = ticketprice;
    }

    public Film getFid() {
        return fid;
    }

    public void setFid(Film fid) {
        this.fid = fid;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
