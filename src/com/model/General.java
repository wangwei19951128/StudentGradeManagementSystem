package com.model;

public class General {
	private int id;
	private String name;
	private int classnum;
	private float classscore;
	private float quascore;
	public General(int i, String string, int  cn, float cs, float qc) {
		setId(i);
		name = string;
		classnum = cn;
		classscore = cs;
		quascore = qc;
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassnum() {
		return classnum;
	}
	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}
	public float getClassscore() {
		return classscore;
	}
	public void setClassscore(float classscore) {
		this.classscore = classscore;
	}
	public float getQuascore() {
		return quascore;
	}
	public void setQuascore(float quascore) {
		this.quascore = quascore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
