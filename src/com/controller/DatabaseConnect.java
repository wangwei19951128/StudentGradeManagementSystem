package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
	private String loginSql = "SELECT username, password, role, name FROM user WHERE username = ?";
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

	public void addClass(String name) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(addClassSql);
		// 设置sql语句中的values值
		presta.setInt(1, queryClassNumber() + 1);
		presta.setString(2, name);
		// 执行SQL语句，实现数据添加
		presta.execute();
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
