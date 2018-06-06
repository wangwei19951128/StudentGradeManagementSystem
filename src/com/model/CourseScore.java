package com.model;

public class CourseScore {
	private int id;
	private String username;
	private float ea;
	private float bs;
	private float fi;
	private float cp;
	private float tg;
	public CourseScore(int  id1,String un1,float ea1,float bs1,float fi1,float cp1,float tg1) {
		id = id1;
		username = un1;
		setEa(ea1);
		bs = bs1;
		fi = fi1;
		cp = cp1;
		tg = tg1;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getBs() {
		return bs;
	}
	public void setBs(float bs) {
		this.bs = bs;
	}
	public float getFi() {
		return fi;
	}
	public void setFi(float fi) {
		this.fi = fi;
	}
	public float getCp() {
		return cp;
	}
	public void setCp(float cp) {
		this.cp = cp;
	}
	public float getTg() {
		return tg;
	}
	public void setTg(float tg) {
		this.tg = tg;
	}
	public float getEa() {
		return ea;
	}
	public void setEa(float ea) {
		this.ea = ea;
	}

}
