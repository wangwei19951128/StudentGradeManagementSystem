package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.main.Main;
import com.model.ClassScoreSum;
import com.model.StudentQualityGrade;

public class ClassQualityInfoAnaWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassQualityInfoAnaWindow frame = new ClassQualityInfoAnaWindow();
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
	public ClassQualityInfoAnaWindow() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("期班教学能力素质分析");
		lblNewLabel.setBounds(147, 10, 138, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 424, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Vector<ClassScoreSum> model=Main.databaseConnection.queryClassScoreSumInfo();
		Object tsdata[][] = new Object[model.size()][5];
		for(int i=0;i<model.size();i++) {
			ClassScoreSum cst = model.get(i);
			tsdata[i][0] = cst.getCl();
			tsdata[i][1] = cst.getCm();
			tsdata[i][2] = cst.getKs();
			tsdata[i][3] = cst.getMa();
			tsdata[i][4] = cst.getTg();
 					
		}
		table.setModel(new DefaultTableModel(
			tsdata,
			new String[] {
				"\u671F\u73ED", "\u77E5\u8BC6\u6280\u80FD", "\u6307\u6325\u7BA1\u7406", "\u673A\u52A1\u7D20\u517B", "\u80FD\u529B\u7D20\u8D28\u8BC4\u5206"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(99);
		scrollPane.setViewportView(table);
	}
}
