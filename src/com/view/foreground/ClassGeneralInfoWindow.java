package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.main.Main;
import com.model.Person;

public class ClassGeneralInfoWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassGeneralInfoWindow frame = new ClassGeneralInfoWindow();
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
	public ClassGeneralInfoWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btn1 = new JButton("课程评分查询");
		btn1.addActionListener(e -> {
			CourseScoreInfoSearchWindow frame = new CourseScoreInfoSearchWindow();
			frame.setVisible(true);
					this.dispose();
				});
		/*btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseScoreInfoSearchWindow frame = new CourseScoreInfoSearchWindow();
				frame.setVisible(true);
				
			}
		});*/
		btn1.setBounds(10, 26, 136, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("能力素质评分查询");
		btn2.setBounds(10, 66, 136, 23);
		contentPane.add(btn2);
		btn2.addActionListener(e -> {
			QualityScoreInfoSearchWindow frame = new QualityScoreInfoSearchWindow();
			frame.setVisible(true);
					this.dispose();
				});
		JButton btn3 = new JButton("期班教学情况分析");
		btn3.setBounds(10, 106, 136, 23);
		contentPane.add(btn3);
		btn3.addActionListener(e ->{
			ClassQualityInfoAnaWindow frame = new ClassQualityInfoAnaWindow();
			frame.setVisible(true);
			this.dispose();
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 10, 340, 309);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\u5E8F\u53F7", "\u59D3\u540D", "\u671F\u73ED", "\u8BFE\u7A0B\u8BC4\u5206", "\u80FD\u529B\u7D20\u8D28\u8BC4\u5206"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(46);
		table.getColumnModel().getColumn(2).setPreferredWidth(59);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(89);
		scrollPane.setViewportView(table);
	}
}
