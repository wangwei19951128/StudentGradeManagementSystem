package com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.main.Main;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class AdminWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7286004708162261631L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminWindow() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1900, 1000);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "确定退出系统? ", "提示 ", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					try {
						Main.databaseConnection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "断开数据库连接失败！", "错误", JOptionPane.ERROR_MESSAGE);
					}
					System.exit(0);
				}
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示
		
		JButton button = new JButton("录入班级信息");
		button.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button.setBounds(824, 327, 235, 23);
		button.addActionListener(e->{
			JDialog dialog=new AdminClassInfoWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button);
		
		JButton button_1 = new JButton("录入学生信息");
		button_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_1.setBounds(824, 392, 235, 23);
		button_1.addActionListener(e->{
			JDialog dialog=new AdminStudentInfoWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("录入个人成绩");
		button_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_2.setBounds(824, 458, 235, 23);
		button_2.addActionListener(e->{
			JDialog dialog=new AdminStudentGradeWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("录入素质评分");
		button_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_3.setBounds(824, 491, 235, 23);
		button_3.addActionListener(e->{
			JDialog dialog=new AdminStudentQualityGradeWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("修改学生信息");
		button_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_4.setBounds(824, 425, 235, 23);
		button_4.addActionListener(e->{
			JDialog dialog=new AdminStudentInfoModifyWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("修改班级信息");
		button_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_5.setBounds(824, 359, 235, 23);
		button_5.addActionListener(e->{
			JDialog dialog=new AdminClassInfoModifyWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_5);
		
		JLabel label = new JLabel("后台管理");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.BOLD, 50));
		label.setBounds(839, 129, 205, 62);
		contentPane.add(label);
		
		JButton button_6 = new JButton("录入教师信息");
		button_6.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_6.setBounds(824, 524, 235, 23);
		contentPane.add(button_6);
		button_6.addActionListener(e->{
			JDialog dialog=new AdminTeacherInfoWindow();
			dialog.setVisible(true);
		});
		
		JButton button_7 = new JButton("修改教师信息");
		button_7.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_7.setBounds(824, 557, 235, 23);
		button_7.addActionListener(e->{
			JDialog dialog=new AdminTeacherInfoModifyWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_7);
		
		JLabel label_1 = new JLabel("欢迎您,"+Main.person.getName()+"!");
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		label_1.setBounds(1516, 25, 358, 39);
		contentPane.add(label_1);
		
		JButton button_8 = new JButton("分配班级");
		button_8.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_8.setBounds(824, 590, 235, 23);
		button_8.addActionListener(e->{
			JDialog dialog=new AdminStudentClassInfoWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("修改班级分配");
		button_9.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_9.setBounds(824, 623, 235, 23);
		button_9.addActionListener(e->{
			JDialog dialog=new AdminStudentClassInfoModifyWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("修改密码");
		button_10.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_10.setBounds(824, 656, 235, 23);
		button_10.addActionListener(e->{
			JDialog dialog=new AdminModifyPasswordWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("删除学生成绩");
		button_11.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_11.setBounds(824, 689, 235, 23);
		button_11.addActionListener(e->{
			JDialog dialog=new AdminDeleteGradeWindow();
			dialog.setVisible(true);
		});
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("重新登录系统");
		button_12.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_12.setBounds(824, 722, 235, 23);
		button_12.addActionListener(e -> {
			new LoginWindow();
			this.dispose();
		});
		contentPane.add(button_12);
		
		this.setVisible(true);
	}
}
