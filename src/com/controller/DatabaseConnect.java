package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.model.KeyValue;
import com.model.Person;

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
	private String addPersonSql = "INSERT INTO user(username, password, role, name) VALUES (?,?,?,?)";

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
		if(rs.next()&&password.equals(rs.getString(2))) {
			person.setUsername(username);
			person.setPassword(password);
			person.setRole(rs.getInt(3));
			person.setName(rs.getString(4));
		}
		return person;
	}

	public int queryClassNumber() throws SQLException {
		stmt = conn.createStatement();
		rs=stmt.executeQuery(queryClassSql);
		rs.last();
		return rs.getRow();
	}
	
	public void addClass(String name) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(addClassSql);
		// 设置sql语句中的values值
		presta.setInt(1, queryClassNumber()+1);
		presta.setString(2, name);
		// 执行SQL语句，实现数据添加
		presta.execute();
	}
	
	public Vector<KeyValue> queryClassInfo() throws SQLException {
		stmt = conn.createStatement();
		rs=stmt.executeQuery(queryClassSql);
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
	
	public void addStudent(Person student) throws SQLException {
		// 预处理sql语句
		presta = conn.prepareStatement(addPersonSql);
		// 设置sql语句中的values值
		presta.setString(1, student.getUsername());
		// presta.setString(2, student.user);
		// presta.setString(3, student.password);
		// presta.setInt(4, student.age);
		// 执行SQL语句，实现数据添加
		presta.execute();
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
