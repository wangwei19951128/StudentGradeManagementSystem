package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.main.Main;
import com.model.CourseScore;

public class CourseScoreInfoSearchWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseScoreInfoSearchWindow frame = new CourseScoreInfoSearchWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CourseScoreInfoSearchWindow() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 29, 104, 99);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  个人成绩：");
		lblNewLabel.setBounds(0, 0, 76, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" 姓名");
		lblNewLabel_1.setBounds(0, 26, 39, 21);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel(" 学号");
		label.setBounds(0, 47, 39, 21);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(37, 31, 57, 16);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(37, 50, 57, 18);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(e -> {
			//数据库查询验证
			PersonalScoreInfoWindow frame;
			try {
				frame = new 	PersonalScoreInfoWindow();
				frame.setVisible(true);
				this.dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		btnNewButton.setBounds(10, 78, 84, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 29, 405, 306);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Vector<CourseScore> model=Main.databaseConnection.queryCourseScoreInfo();
		Object tsdata[][] = new Object[model.size()][7];
		for(int i=0;i<model.size();i++) {
			CourseScore cst = model.get(i);
			tsdata[i][0] = cst.getId();
			tsdata[i][1] = cst.getUsername();
			tsdata[i][2] = cst.getEa();
			tsdata[i][3] = cst.getBs();
			tsdata[i][4] = cst.getFi();
			tsdata[i][5] = cst.getCp();
			tsdata[i][6] = cst.getTg();
 					
		}
		table.setModel(new DefaultTableModel(
			tsdata,
			new String[] {
				"\u5E8F\u53F7", "\u59D3\u540D", "\u673A\u52A1\u7D20\u517B", "\u57FA\u672C\u6280\u80FD", "\u90E8\u961F\u5B9E\u4E60", "\u7EFC\u5408\u6F14\u7EC3", "\u8BFE\u7A0B\u8BC4\u5206"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(48);
		table.getColumnModel().getColumn(2).setPreferredWidth(59);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(61);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		scrollPane.setViewportView(table);
	}
}
