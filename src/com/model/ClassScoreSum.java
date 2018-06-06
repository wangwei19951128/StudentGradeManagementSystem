package com.model;

public class ClassScoreSum {
	private String cl;
	private float ks;
	private float cm;
	private float ma;
	
	public ClassScoreSum(String cl, float ks, float cm, float ma, float tg) {
		super();
		this.cl = cl;
		this.ks = ks;
		this.cm = cm;
		this.ma = ma;
		this.tg = tg;
	}
	public float getKs() {
		return ks;
	}
	public void setKs(float ks) {
		this.ks = ks;
	}
	public float getCm() {
		return cm;
	}
	public void setCm(float cm) {
		this.cm = cm;
	}
	public float getMa() {
		return ma;
	}
	public void setMa(float ma) {
		this.ma = ma;
	}
	public float getTg() {
		return tg;
	}
	public void setTg(float tg) {
		this.tg = tg;
	}
	private float tg;
	public String getCl() {
		return cl;
	}
	public void setCl(String cl) {
		this.cl = cl;
	}
}
