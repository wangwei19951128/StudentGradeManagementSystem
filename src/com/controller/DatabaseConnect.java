package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.model.ClassPerScore;
import com.model.ClassScoreSum;
import com.model.CourseScore;
import com.model.General;
import com.model.KeyValue;
import com.model.KeyValueS;
import com.model.Person;
import com.model.StudentGrade;
import com.model.StudentQualityGrade;

public class DatabaseConnect {
	private static final String URL = "jdbc:mysql://49.140.86.196:3306/student_grade_management_system?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true";
	private static final String NAME = "root";
	private static final String PASSWORD = "123456qwe";
	private Connection conn = null;
	private PreparedStatement presta = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String queryGeneral ="SELECT user.name,class.classname,competency_module_grade.total_grade,total_grade.total_grade FROM user,user_class,competency_module_grade,total_grade,class WHERE user_class.username = competency_module_grade.username AND user_class.username = total_grade.username AND user_class.class = class.id AND user_class.username = user.username";
	private String queryCourseScore = "SELECT total_grade.id,user.name,total_grade.engineering_accomplishment,total_grade.basic_skills,total_grade.forces_internship,total_grade.comprehensive_practice,total_grade.total_grade from total_grade,user WHERE user.username=total_grade.username";
	private String queryQualityScore = "SELECT competency_module_grade.id,user.name,competency_module_grade.knowledge_skills,competency_module_grade.command_management,competency_module_grade.maintenance_accomplishment,competency_module_grade.total_grade from competency_module_grade,user WHERE competency_module_grade.username=user.username";
	private String queryClassScoreSum ="SELECT class.classname,AVG(competency_module_grade.knowledge_skills),AVG(competency_module_grade.maintenance_accomplishment),AVG(competency_module_grade.total_grade),AVG(competency_module_grade.command_management) FROM user_class , class,competency_module_grade WHERE user_class.username = competency_module_grade.username AND user_class.class = class.id GROUP BY class.id ";
	private String loginSql = "SELECT username, password, role, name FROM user WHERE username = ?";
	private String queryPersonCourse ="SELECT * from bac_grade WHERE username = ?";
	private String queryPersonCourse1 ="SELECT * from focus_on_teaching_grade WHERE username = ?";
	private String queryPersonCourse2 ="SELECT * from performance_in_practice_grade WHERE username = ?";
	private String queryPersonCourse3 ="SELECT * from competitive_grade WHERE username = ?";
	private String queryPersonCourse4 ="SELECT * from simulated_backbone_grade WHERE username = ?";
	private String queryPersonCourse5 ="SELECT * from course_grade WHERE username = ?";
	private String queryPersonCourse6 ="SELECT * from total_grade WHERE username = ?";
	private String queryPersonQuality ="SELECT * from first_class_of_competency WHERE username = ?";
	private String queryPersonQuality1 = "SELECT * from second_class_of_competency WHERE username = ?";
	private String queryPersonQuality2 = "SELECT * from third_class_of_competency WHERE username = ?";
	private String queryPersonQuality3 = "SELECT * from competency_courses_grade WHERE username = ?";
	private String queryPersonQuality4 = "SELECT * from competency_module_grade WHERE username = ?";
	private String queryLogin = "SELECT username from user WHERE username = ? AND name = ?";
	private String queryPersonNumber = "SELECT user_class.class,competency_module_grade.total_grade From user_class,competency_module_grade WHERE user_class.username = competency_module_grade.username AND user_class.class = ?";
	private String queryClassPerQuality = "SELECT AVG(course_grade.practical_training),AVG(course_grade.organization_architecture_and_maintenance_processes),AVG(course_grade.special_regulations_education),AVG(course_grade.flight_security),AVG(course_grade.basic_maintenance_skills),AVG(course_grade.dismantling_and_insurance_of_machinery_parts),AVG(course_grade.the_installation_of_wheel),AVG(course_grade.disassemble_the_rear_section_of_fuselage),AVG(course_grade.drag_parachute),AVG(course_grade.undercarriage),AVG(course_grade.brake),AVG(course_grade.flat_tail_control_system),AVG(course_grade.flight_check),AVG(course_grade.air_force_internship),AVG(course_grade.internal_communication),AVG(course_grade.checking_work),AVG(course_grade.intensive_training),AVG(course_grade.joint_examination),AVG(course_grade.drill),class.classname FROM course_grade,class,user_class WHERE course_grade.username = user_class.username AND user_class.class = class.id GROUP BY class.classname";
	private String queryClassSql = "SELECT id, classname FROM class";
	private String addClassSql = "INSERT INTO class(id, classname) VALUES (?,?)";
	private String modifyClassInfoSql = "UPDATE class SET classname = ? WHERE id = ?";
	private String queryStudentInfoSql = "SELECT * FROM user WHERE role = 0";
	private String addPersonSql = "INSERT INTO user(username, password, role, name) VALUES (?,?,?,?)";
	private String modifyPersonInfoSql = "UPDATE user SET name = ? WHERE username = ?";
	private String queryStudentClassSql = "SELECT id, username, class FROM user_class";
	private String addStudentClassInfoSql = "INSERT INTO user_class(id, username, class) VALUES (?,?,?)";
	private String queryStudentGradeInfoBacGradeSql = "SELECT * FROM bac_grade";
	private String addStudentGradeInfoBacGradeSql = "INSERT INTO bac_grade VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentGradeInfoFocusTeachingGradeSql = "INSERT INTO focus_on_teaching_grade VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentGradeInfoperPracticeGradeSql = "INSERT INTO performance_in_practice_grade VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentGradeInfoCompetitiveGradeSql = "INSERT INTO competitive_grade VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentGradeInfoSimulateBackboneGradeSql = "INSERT INTO simulated_backbone_grade VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentGradeInfoCourseGradeSql = "INSERT INTO course_grade VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentGradeInfoTotalGradeSql = "INSERT INTO total_grade VALUES (?,?,?,?,?,?,?)";
	private String queryStudentQualityGradeInfoFirstClassGradeSql = "SELECT * FROM first_class_of_competency";
	private String addStudentQualityGradeInfoFirstClassGradeSql = "INSERT INTO first_class_of_competency VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentQualityGradeInfoSecondClassGradeSql = "INSERT INTO second_class_of_competency VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentQualityGradeInfoThirdClassGradeSql = "INSERT INTO third_class_of_competency VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentQualityGradeInfoCourseClassGradeSql = "INSERT INTO competency_courses_grade VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String addStudentQualityGradeInfoTotalGradeSql = "INSERT INTO competency_module_grade VALUES (?,?,?,?,?,?)";
	private String modifyStudentClassInfoSql = "UPDATE user_class SET class = ? WHERE username = ?";
	private String modifyPasswordInfoSql = "UPDATE user SET password = ? WHERE username = ?";

	public DatabaseConnect() {
		super();
	}
	public int[] searchClassScore(int clsid) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		presta = conn.prepareStatement(queryPersonNumber);
		presta.setInt(1, clsid);
		rs =presta.executeQuery();
		int[] num = new int[5];
		while(rs.next()) {
			if(rs.getFloat(2)>=90) {
				num[0]++;
			}else if(rs.getFloat(2)>=80) {
				num[1]++;
			}else if(rs.getFloat(2)>=70) {
				num[2]++;
			}else if(rs.getFloat(2)>=60) {
				num[3]++;
			}else{
				num[4]++;
			}
		}
		return num; 
	}
	public boolean searchDC(String tn,String un) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		presta = conn.prepareStatement(queryLogin);
		// 设置sql语句中的values值
		System.out.println(tn);
		
		presta.setString(1, tn);
		presta.setString(2, un);
		System.out.println(presta);
		rs = presta.executeQuery();
		
		if(rs.next()) {
			
			return true;
		}else {
			return false;
		}
		
	}
	public Person login(String username, String password) throws SQLException, ClassNotFoundException {
		Person person = new Person();
		// 1.加载驱动程序
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		// 预处理sql语句
		presta = conn.prepareStatement(loginSql);
		// 设置sql语句中的values值
		presta.setString(1, username);
		rs = presta.executeQuery();
		if (rs.next() && password.equals(rs.getString(2))) {
			person.setUsername(username);
			person.setPassword(password);
			person.setRole(rs.getInt(3));
			person.setName(rs.getString(4));
		}
		return person;
	}

	public int queryClassNumber() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryClassSql);
		rs.last();
		return rs.getRow();
	}
	public Vector<ClassPerScore> queryClassPerInfo() throws SQLException{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryClassPerQuality);
		Vector<ClassPerScore> model = new Vector<ClassPerScore>();
		while(rs.next()) {
			ClassPerScore item = new ClassPerScore();
			float[] rt = new float[19];
			for(int i =0;i<19;i++) {
				rt[i] = rs.getFloat(i+1);
			}
			item.setGrade(rt);
			item.setClname(rs.getString(20));
			model.add(item);
		}
		return model;
	}
	public StudentQualityGrade queryPersonalQualityInfo(String uname) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		presta = conn.prepareStatement(queryPersonQuality);
		presta.setString(1, uname);
		rs = presta.executeQuery();
		Person pt  = new Person();
		pt.setName(uname);
		StudentQualityGrade trs = new StudentQualityGrade(pt,0);
		rs.next();
		for(int i=0;i<12;i++) {
			trs.getGrade()[i][0]=rs.getFloat(i+3);
		}
		PreparedStatement presta1 = conn.prepareStatement(queryPersonQuality1);
		presta1.setString(1, uname);
		rs = presta1.executeQuery();
		rs.next();
		for(int i = 0;i<12;i++) {
			trs.getGrade()[i][1] = rs.getFloat(i+3);
		}
		PreparedStatement presta2 = conn.prepareStatement(queryPersonQuality2);
		presta2.setString(1, uname);
		rs = presta2.executeQuery();
		rs.next();
		for(int i = 0;i<12;i++) {
			trs.getGrade()[i][2] = rs.getFloat(i+3);
		}
		PreparedStatement presta3 = conn.prepareStatement(queryPersonQuality3);
		presta3.setString(1, uname);
		rs = presta3.executeQuery();
		rs.next();
		for(int i = 0;i<12;i++) {
			trs.getGrade()[i][3] = rs.getFloat(i+3);
		}
		PreparedStatement presta4 = conn.prepareStatement(queryPersonQuality4);
		presta4.setString(1, uname);
		rs = presta4.executeQuery();
		rs.next();
		System.out.println(rs.getFloat(3));
		System.out.println(rs.getFloat(4));
		System.out.println(rs.getFloat(5));
		for(int i = 0;i<3;i++) {
			//trs.setModuleGrade(i,  rs.getFloat(i+3));
			trs.getModuleGrade()[i] = rs.getFloat(i+3);
		}
		trs.setTotalGrade(rs.getFloat(6));  
		return trs;
		
	}
	public StudentGrade queryPersonalScoreInfo(String uname) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		presta = conn.prepareStatement(queryPersonCourse);
		// 设置sql语句中的values值
		presta.setString(1, uname);
		rs = presta.executeQuery();
		Person pt  = new Person();
		pt.setName(uname);
		StudentGrade trs = new StudentGrade(pt,0);
		rs.next();
		for(int i =0;i<19;i++) {
			trs.getGrade()[i][0]=rs.getFloat(i+3);
		}
		PreparedStatement presta1 = conn.prepareStatement(queryPersonCourse1);
		presta1.setString(1, uname);
		rs = presta1.executeQuery();
		rs.next();
		for(int i = 0;i<19;i++) {
			trs.getGrade()[i][1] = rs.getFloat(i+3);
		}
		PreparedStatement presta2 = conn.prepareStatement(queryPersonCourse2);
		presta2.setString(1, uname);
		rs = presta2.executeQuery();
		rs.next();
		for(int i = 0;i<19;i++) {
			trs.getGrade()[i][2] = rs.getFloat(i+3);
		}
		PreparedStatement presta3 = conn.prepareStatement(queryPersonCourse3);
		presta3.setString(1, uname);
		rs = presta1.executeQuery();
		rs.next();
		for(int i = 0;i<19;i++) {
			trs.getGrade()[i][3] = rs.getFloat(i+3);
		}
		PreparedStatement presta4 = conn.prepareStatement(queryPersonCourse4);
		presta4.setString(1, uname);
		rs = presta1.executeQuery();
		rs.next();
		for(int i = 0;i<19;i++) {
			trs.getGrade()[i][4] = rs.getFloat(i+3);
		}
		PreparedStatement presta5 = conn.prepareStatement(queryPersonCourse5);
		presta5.setString(1, uname);
		rs = presta1.executeQuery();
		rs.next();
		for(int i = 0;i<19;i++) {
			trs.getGrade()[i][5] = rs.getFloat(i+3);
		}
		//trs.setGrade(null);
		return trs;
		
	}
	public Vector<ClassScoreSum> queryClassScoreSumInfo() throws SQLException{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryClassScoreSum);
		Vector<ClassScoreSum> model = new Vector<ClassScoreSum>();
		while(rs.next()) {
			ClassScoreSum Itemlocation = new ClassScoreSum(rs.getString(1),rs.getFloat(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5));
			model.add(Itemlocation);
		}
		return model;
		
	}
	public Vector<General> queryGeneralInfo() throws SQLException{
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryGeneral);
		Vector<General> model = new Vector<General>();
		int i=1;
		while(rs.next()) {
			General Itemlocation = new General(i,rs.getString(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4));
			model.add(Itemlocation);
			i++;
		}
		
		return model;
		
	}
	
	public Vector<CourseScore> queryCourseScoreInfo() throws SQLException{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryCourseScore);
		Vector<CourseScore> model = new Vector<CourseScore>();
		int i =1;
		while(rs.next()) {
			CourseScore Itemlocation = new CourseScore(i,rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7));
			model.add(Itemlocation);
			i++;
		}
	
		return model;
	}
	public Vector<StudentQualityGrade> queryQualityScoreInfo() throws SQLException{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryQualityScore);
		Vector<StudentQualityGrade> model = new Vector<StudentQualityGrade>();
		int i =1;
		while(rs.next()) {
			Person ta =new Person();
			ta.setName(rs.getString(2));
			StudentQualityGrade Itemlocation = new StudentQualityGrade(ta,0);
			Itemlocation.setModuleGrade(0,rs.getFloat(3));
			Itemlocation.setModuleGrade(1,rs.getFloat(4));
			Itemlocation.setModuleGrade(2,rs.getFloat(5));
			Itemlocation.setTotalGrade(rs.getFloat(6));
			model.add(Itemlocation);
			i++;
		}
		return model;
	}
	public void addClass(String name) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(addClassSql);
		// 设置sql语句中的values值
		presta.setInt(1, queryClassNumber() + 1);
		presta.setString(2, name);
		// 执行SQL语句，实现数据添加
		presta.execute();
	}
	public Vector<KeyValue> ForequeryClassInfo() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.获得数据库的连接
		conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryClassSql);
		Vector<KeyValue> model = new Vector<KeyValue>();
		while (rs.next()) {
			KeyValue Itemlocation = new KeyValue(rs.getInt("id"), rs.getString("classname"));
			model.addElement(Itemlocation);
		}
		return model;
	}

	public Vector<KeyValue> queryClassInfo() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryClassSql);
		Vector<KeyValue> model = new Vector<KeyValue>();
		while (rs.next()) {
			KeyValue Itemlocation = new KeyValue(rs.getInt("id"), rs.getString("classname"));
			model.addElement(Itemlocation);
		}
		return model;
	}

	public void modifyClassInfo(int id, String classname) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(modifyClassInfoSql);
		// 设置sql语句中的values值
		presta.setString(1, classname);
		presta.setInt(2, id);
		presta.executeUpdate();
	}

	public Vector<KeyValueS> queryStudentInfo() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryStudentInfoSql);
		Vector<KeyValueS> model = new Vector<KeyValueS>();
		while (rs.next()) {
			KeyValueS Itemlocation = new KeyValueS(rs.getString("username"), rs.getString("name"));
			model.addElement(Itemlocation);
		}
		return model;
	}

	public void addPerson(Person student) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(addPersonSql);
		// 设置sql语句中的values值
		presta.setString(1, student.getUsername());
		presta.setString(2, student.getPassword());
		presta.setInt(3, student.getRole());
		presta.setString(4, student.getName());
		// 执行SQL语句，实现数据添加
		presta.execute();
	}

	public void modifyPersonInfo(Person student) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(modifyPersonInfoSql);
		// 设置sql语句中的values值
		presta.setString(1, student.getName());
		presta.setString(2, student.getUsername());
		presta.executeUpdate();
	}

	public int queryStudentClassNumber() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryStudentClassSql);
		rs.last();
		return rs.getRow();
	}

	public void addStudentClassInfo(String username, int classid) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(addStudentClassInfoSql);
		// 设置sql语句中的values值
		presta.setInt(1, queryStudentClassNumber() + 1);
		presta.setString(2, username);
		presta.setInt(3, classid);
		presta.execute();
	}

	public void modifyStudentClassInfo(String username, int classid) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(modifyStudentClassInfoSql);
		// 设置sql语句中的values值
		presta.setInt(1, classid);
		presta.setString(2, username);
		presta.executeUpdate();
	}

	public int queryStudentGradeInfoNumber() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryStudentGradeInfoBacGradeSql);
		rs.last();
		return rs.getRow();
	}

	public void addStudentGradeInfo(StudentGrade studentGrade) throws SQLException {
		conn.setAutoCommit(false); // 需要用到事务，不能让他自动提交，需要手动提交
		PreparedStatement pst = conn.prepareStatement(addStudentGradeInfoBacGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst1 = conn.prepareStatement(addStudentGradeInfoFocusTeachingGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst2 = conn.prepareStatement(addStudentGradeInfoperPracticeGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst3 = conn.prepareStatement(addStudentGradeInfoCompetitiveGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst4 = conn.prepareStatement(addStudentGradeInfoSimulateBackboneGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst5 = conn.prepareStatement(addStudentGradeInfoCourseGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst6 = conn.prepareStatement(addStudentGradeInfoTotalGradeSql); // INSERT_SQL表示对另一张表的插入记录
		pst.setInt(1, studentGrade.getId());
		pst.setString(2, studentGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 19; i++) {
			pst.setFloat(i + 3, studentGrade.getGrade()[i][0]);
		}
		pst.addBatch();
		pst1.setInt(1, studentGrade.getId());
		pst1.setString(2, studentGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 19; i++) {
			pst1.setFloat(i + 3, studentGrade.getGrade()[i][1]);
		}
		pst1.addBatch();
		pst2.setInt(1, studentGrade.getId());
		pst2.setString(2, studentGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 19; i++) {
			pst2.setFloat(i + 3, studentGrade.getGrade()[i][2]);
		}
		pst2.addBatch();
		pst3.setInt(1, studentGrade.getId());
		pst3.setString(2, studentGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 19; i++) {
			pst3.setFloat(i + 3, studentGrade.getGrade()[i][3]);
		}
		pst3.addBatch();
		pst4.setInt(1, studentGrade.getId());
		pst4.setString(2, studentGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 19; i++) {
			pst4.setFloat(i + 3, studentGrade.getGrade()[i][4]);
		}
		pst4.addBatch();
		pst5.setInt(1, studentGrade.getId());
		pst5.setString(2, studentGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 19; i++) {
			pst5.setFloat(i + 3, studentGrade.getGrade()[i][5]);
		}
		pst5.addBatch();
		pst6.setInt(1, studentGrade.getId());
		pst6.setString(2, studentGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 4; i++) {
			pst6.setFloat(i + 3, studentGrade.getModuleGrade()[i]);
		}
		pst6.setFloat(7, studentGrade.getTotalGrade());
		pst6.addBatch();

		int[] count = pst.executeBatch();
		int[] count1 = pst1.executeBatch();
		int[] count2 = pst2.executeBatch();
		int[] count3 = pst3.executeBatch();
		int[] count4 = pst4.executeBatch();
		int[] count5 = pst5.executeBatch();
		int[] count6 = pst6.executeBatch();
		conn.commit(); // 提交事务，这个非常重要
		for (int i : count) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				if(pst5!=null) {
					pst5.close();
				}
				if(pst6!=null) {
					pst6.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count1) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				if(pst5!=null) {
					pst5.close();
				}
				if(pst6!=null) {
					pst6.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count2) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				if(pst5!=null) {
					pst5.close();
				}
				if(pst6!=null) {
					pst6.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count3) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				if(pst5!=null) {
					pst5.close();
				}
				if(pst6!=null) {
					pst6.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count4) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				if(pst5!=null) {
					pst5.close();
				}
				if(pst6!=null) {
					pst6.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count5) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				if(pst5!=null) {
					pst5.close();
				}
				if(pst6!=null) {
					pst6.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count6) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				if(pst5!=null) {
					pst5.close();
				}
				if(pst6!=null) {
					pst6.close();
				}
				throw new SQLException();
			}
		}
	}
	
	public int queryStudentQualityGradeInfoNumber() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(queryStudentQualityGradeInfoFirstClassGradeSql);
		rs.last();
		return rs.getRow();
	}
	
	public void addStudentQualityGradeInfo(StudentQualityGrade studentQualityGrade) throws SQLException {
		conn.setAutoCommit(false); // 需要用到事务，不能让他自动提交，需要手动提交
		PreparedStatement pst = conn.prepareStatement(addStudentQualityGradeInfoFirstClassGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst1 = conn.prepareStatement(addStudentQualityGradeInfoSecondClassGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst2 = conn.prepareStatement(addStudentQualityGradeInfoThirdClassGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst3 = conn.prepareStatement(addStudentQualityGradeInfoCourseClassGradeSql); // INSERT_SQL表示对一张表的插入记录
		PreparedStatement pst4 = conn.prepareStatement(addStudentQualityGradeInfoTotalGradeSql); // INSERT_SQL表示对另一张表的插入记录
		pst.setInt(1, studentQualityGrade.getId());
		pst.setString(2, studentQualityGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 12; i++) {
			pst.setFloat(i + 3, studentQualityGrade.getGrade()[i][0]);
		}
		pst.addBatch();
		pst1.setInt(1, studentQualityGrade.getId());
		pst1.setString(2, studentQualityGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 12; i++) {
			pst1.setFloat(i + 3, studentQualityGrade.getGrade()[i][1]);
		}
		pst1.addBatch();
		pst2.setInt(1, studentQualityGrade.getId());
		pst2.setString(2, studentQualityGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 12; i++) {
			pst2.setFloat(i + 3, studentQualityGrade.getGrade()[i][2]);
		}
		pst2.addBatch();
		pst3.setInt(1, studentQualityGrade.getId());
		pst3.setString(2, studentQualityGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 12; i++) {
			pst3.setFloat(i + 3, studentQualityGrade.getGrade()[i][3]);
		}
		pst3.addBatch();
		pst4.setInt(1, studentQualityGrade.getId());
		pst4.setString(2, studentQualityGrade.getStudent().getUsername());
		// 设置sql语句中的values值
		for (int i = 0; i < 3; i++) {
			pst4.setFloat(i + 3, studentQualityGrade.getModuleGrade()[i]);
		}
		pst4.setFloat(6, studentQualityGrade.getTotalGrade());
		pst4.addBatch();

		int[] count = pst.executeBatch();
		int[] count1 = pst1.executeBatch();
		int[] count2 = pst2.executeBatch();
		int[] count3 = pst3.executeBatch();
		int[] count4 = pst4.executeBatch();
		conn.commit(); // 提交事务，这个非常重要
		for (int i : count) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count1) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count2) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count3) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				throw new SQLException();
			}
		}
		for (int i : count4) {
			if (i == 0) {
				conn.rollback(); // 回滚，非常重要
				if(pst!=null) {
					pst.close();
				}
				if(pst1!=null) {
					pst1.close();
				}
				if(pst2!=null) {
					pst2.close();
				}
				if(pst3!=null) {
					pst3.close();
				}
				if(pst4!=null) {
					pst4.close();
				}
				throw new SQLException();
			}
		}
	}

	public void modifyPasswordInfo(Person person) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(modifyPasswordInfoSql);
		// 设置sql语句中的values值
		presta.setString(1, person.getPassword());
		presta.setString(2, person.getUsername());
		presta.executeUpdate();
	}

	public void close() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (presta != null) {
			presta.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
