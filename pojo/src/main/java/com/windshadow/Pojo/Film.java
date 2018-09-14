package com.windshadow.Pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Film {
	//电影表
	public Film()
	{
		super();
	}


	private int id; //电影编号
	private String name;//电影名称
	private String intro;//电影简介
	private String language;//语言
	private int min;//片长(分钟)
	private Date date;//放映日期
	private double monye;//价格
	private String hoto;//海报
	private String status;//电影状态
	private int aid;//电影地区编号
	private String office;//电影票房
	private double grade;//电影评分

	private String area;//新增临时变量--地区
	private int ad;//新增临时变量--地区编号

	public int getAd() {
		return ad;
	}

	public void setAd(int ad) {
		this.ad = ad;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMonye() {
		return monye;
	}

	public void setMonye(double monye) {
		this.monye = monye;
	}

	public String getHoto() {
		return hoto;
	}

	public void setHoto(String hoto) {
		this.hoto = hoto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}
	
	
