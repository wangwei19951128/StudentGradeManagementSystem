package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.main.Main;
import com.model.General;
import com.model.KeyValue;
import com.model.Person;
import com.view.LoginWindow;

public class ClassGeneralInfoWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector<General> model;
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
	 * @throws SQLException 
	 */
	public ClassGeneralInfoWindow() throws SQLException {
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
		setBounds(100, 100, 600, 400);
		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btn1 = new JButton("课程评分查询");
		btn1.addActionListener(e -> {
			CourseScoreInfoSearchWindow frame;
			try {
				frame = new CourseScoreInfoSearchWindow();
				frame.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
			QualityScoreInfoSearchWindow frame;
			try {
				frame = new QualityScoreInfoSearchWindow();
				frame.setVisible(true);
				this.dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				});
		JButton btn3 = new JButton("期班成绩分析");
		btn3.setBounds(10, 106, 136, 23);
		contentPane.add(btn3);
		btn3.addActionListener(e ->{
			ClassPerQualityInfoWindow frame;
			frame = new ClassPerQualityInfoWindow();
			frame.setVisible(true);
			this.dispose();
			
		});
		
		JButton button = new JButton("期班能力素质分析");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addActionListener(e->{
			ClassQualityInfoAnaWindow frame;
			try {
				frame = new ClassQualityInfoAnaWindow();
				frame.setVisible(true);
				this.dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		button.setBounds(10, 148, 136, 23);
		contentPane.add(button);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 10, 421, 341);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model=Main.databaseConnection.queryGeneralInfo();
		
		Object a[][] = new Object[model.size()][5];
		for(int i=0;i<model.size();i++) {
				General te =model.get(i);
				a[i][0]=te.getId();
				a[i][1] = te.getName();
				a[i][2] = te.getClassnum();
				a[i][3] = te.getClassscore();
				a[i][4] = te.getQuascore();
		}
		table.setModel(new DefaultTableModel(
			a,
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
