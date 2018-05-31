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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PersonalQualityScoreInfoSearchWindow extends JFrame {

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
					PersonalQualityScoreInfoSearchWindow frame = new PersonalQualityScoreInfoSearchWindow();
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
	public PersonalQualityScoreInfoSearchWindow() {
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 78, 84, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 29, 405, 306);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"111", null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u5E8F\u53F7", "\u59D3\u540D", "\u77E5\u8BC6\u6280\u80FD", "\u6307\u6325\u7BA1\u7406", "\u673A\u52A1\u7D20\u517B", "\u80FD\u529B\u7D20\u8D28\u8BC4\u5206"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(48);
		table.getColumnModel().getColumn(2).setPreferredWidth(59);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(87);
		scrollPane.setViewportView(table);
	}
}
