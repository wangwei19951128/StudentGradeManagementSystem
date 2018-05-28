package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7286004708162261631L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow frame = new AdminWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("录入班级信息");
		button.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button.setBounds(174, 103, 235, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("录入学生信息");
		button_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_1.setBounds(174, 168, 235, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("录入个人成绩");
		button_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_2.setBounds(174, 234, 235, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("录入素质评分");
		button_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_3.setBounds(174, 267, 235, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("修改学生信息");
		button_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_4.setBounds(174, 201, 235, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("修改班级信息");
		button_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_5.setBounds(174, 135, 235, 23);
		contentPane.add(button_5);
		
		JLabel label = new JLabel("后台管理");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.BOLD, 50));
		label.setBounds(189, 25, 205, 62);
		contentPane.add(label);
		
		JButton button_6 = new JButton("录入教师信息");
		button_6.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_6.setBounds(174, 300, 235, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("修改教师信息");
		button_7.setFont(new Font("微软雅黑 Light", Font.PLAIN, 20));
		button_7.setBounds(174, 333, 235, 23);
		contentPane.add(button_7);
	}
}
