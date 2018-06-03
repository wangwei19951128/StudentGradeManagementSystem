package com.model;

public class StudentGrade {

	private Person student;
	
	private int id;

	/*
	 * practical_training;// 实战化开训
	 * organization_architecture_and_maintenance_processes;// 航空兵机务部队组织架构和机务工作流程
	 * special_regulations_education;// 航空机务法规专项教育 
	 * flight_security;// 飞行保障和典型定检工作
	 * basic_maintenance_skills;// 基本维护技能
	 * dismantling_and_insurance_of_machinery_parts;// 机件的拆装及保险
	 * the_installation_of_wheel;// 机轮安装 
	 * disassemble_the_rear_section_of_fuselage;//
	 * 机身后段的拆装 drag_parachute;// 副油箱减速伞的安装与投放 
	 * undercarriage;// 起落架减速板联合收放检查 
	 * brake;// 刹车压力油门操纵系统检查与调整
	 * flat_tail_control_system;// 平尾操纵系统检查与调整 
	 * flight_check;// 飞行检查
	 * air_force_internship;// 机务部队实习 
	 * internal_communication;// 内部交流
	 * checking_work;// 飞行保障及定检工作 
	 * intensive_training;// 强化训练 
	 * joint_examination;// 空军联考 
	 * drill;// 演练
	 */

	private float[][] grade = new float[19][6];
	
	private float[] moduleGrade=new float[4];
	
	private float totalGrade;

	public StudentGrade(Person student, int id) {
		super();
		this.student = student;
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
