package com.model;

public class StudentQualityGrade {
	private Person student;
private int id;
	/*
	 * practice_results;// 实习成绩
	 * professional_foundation;// 专业基础
	 * ability_to_teach;// 代教能力
	 * competition_contest;// 竞赛比武
	 * organizational_skills;// 组织能力
	 * resilience;// 应变能力
	 * management_ability;// 管理能力
	 * coordination;// 协调能力
	 * the_spirit_of_service;// 机务精神
	 * maintenance_style;// 维护作风
	 * discipline;// 实习纪律
	 * actual_awareness;// 实战感知
	 */
	private float[][] grade = new float[12][4];
	
	private float[] moduleGrade=new float[3];
	
	private float totalGrade;

	public StudentQualityGrade(Person student,int id) {
		super();
		this.student=student;
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGrade(float[][] grade) {
		this.grade = grade;
	}

	public void setGrade(int row, int col, float value) {
		grade[row][col] = value;
	}

	public float[][] getGrade() {
		return grade;
	}

	public Person getStudent() {
		return student;
	}

	public void setStudent(Person student) {
		this.student = student;
	}

	public float[] getModuleGrade() {
		return moduleGrade;
	}
	
	public void setModuleGrade(int number, float value) {
		this.moduleGrade[number] = value;
	}

	public void setModuleGrade(float[] moduleGrade) {
		this.moduleGrade = moduleGrade;
	}

	public float getTotalGrade() {
		return totalGrade;
	}

	public void setTotalGrade(float totalGrade) {
		this.totalGrade = totalGrade;
	}
}
