package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.main.Main;
import com.model.ClassScoreSum;
import com.model.KeyValue;
import com.model.StudentQualityGrade;
import com.view.LoginWindow;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ClassQualityInfoAnaWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector<KeyValue> model;

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
	 * 
	 * @throws SQLException
	 */
	public ClassQualityInfoAnaWindow() throws SQLException {
		try {
			model = Main.databaseConnection.ForequeryClassInfo();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "初始化班级失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JComboBox<KeyValue> comboBox = new JComboBox<KeyValue>(model);
		

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(ClassQualityInfoAnaWindow.this, "确定退出系统? ", "提示 ",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (option == JOptionPane.YES_OPTION)
					if (e.getWindow() == ClassQualityInfoAnaWindow.this) {
						try {
							Main.databaseConnection.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "断开数据库连接失败！", "错误", JOptionPane.ERROR_MESSAGE);
						}
						System.exit(0);
					} else {
						return;
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

		JLabel lblNewLabel = new JLabel("期班教学能力素质分析");
		lblNewLabel.setBounds(266, 10, 138, 15);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 564, 286);
		contentPane.add(scrollPane);

		table = new JTable();
		Vector<ClassScoreSum> model = Main.databaseConnection.queryClassScoreSumInfo();
		Object tsdata[][] = new Object[model.size()][5];
		for (int i = 0; i < model.size(); i++) {
			ClassScoreSum cst = model.get(i);
			tsdata[i][0] = cst.getCl();
			tsdata[i][1] = cst.getCm();
			tsdata[i][2] = cst.getKs();
			tsdata[i][3] = cst.getMa();
			tsdata[i][4] = cst.getTg();

		}
		table.setModel(new DefaultTableModel(tsdata, new String[] { "\u671F\u73ED", "\u77E5\u8BC6\u6280\u80FD",
				"\u6307\u6325\u7BA1\u7406", "\u673A\u52A1\u7D20\u517B", "\u80FD\u529B\u7D20\u8D28\u8BC4\u5206" }));
		table.getColumnModel().getColumn(4).setPreferredWidth(99);
		scrollPane.setViewportView(table);

		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(e->{
			this.dispose();
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
		});
		btnNewButton_1.setBounds(10, 6, 93, 23);
		contentPane.add(btnNewButton_1);
		/*
		 * table.addMouseListener(new java.awt.event.MouseAdapter(){
		 * 
		 * public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
		 * 
		 * //得到选中的行列的索引值
		 * 
		 * int r= table.getSelectedRow();
		 * 
		 * int c= table.getSelectedColumn();
		 * 
		 * //得到选中的单元格的值，表格中都是字符串
		 * 
		 * Object value= table.getValueAt(r, c);
		 * 
		 * String info=r+"行"+c+"列值 : "+value.toString();
		 * 
		 * javax.swing.JOptionPane.showMessageDialog(null,info);
		 * 
		 * }
		 * 
		 * });
		 */
		JButton button = new JButton("图表显示");
		String[] ca = new String[model.size()];
		for (int i = 0; i < model.size(); i++) {
			ca[i] = String.valueOf(tsdata[i][0]);
		}
		float[][] gd = new float[model.size()][4];
		for (int i = 0; i < model.size(); i++) {
			for (int j = 0; j < 4; j++) {
				gd[i][j] = Float.valueOf(String.valueOf((tsdata[i][j + 1])));
			}
		}
		button.addActionListener(e -> {
			Dialog ch = new CompetencyAnalysisHistogramChartWindow(gd, ca,
					new String[] { "知识技能", "指挥管理", "机务素养", "能力素质评分" });
			ch.setVisible(true);

		});
		button.setBounds(481, 331, 93, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("班级成绩分布");
		button_1.addActionListener(e -> {
			int classId = ((KeyValue) comboBox.getSelectedItem()).getId();
			try {
				int[] tcId = Main.databaseConnection.searchClassScore(classId);
				Dialog ch1 = new CompetencyAnalysisPieChartWindow(tcId, ((KeyValue) comboBox.getSelectedItem()).getName());
				ch1.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "查询班级成绩统计表格失败！", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// Dialog ch1 = new CompetencyAnalysisPieChartWindow(number, className)
		});
		button_1.setBounds(149, 331, 146, 23);
		contentPane.add(button_1);
		
		comboBox.setBounds(10, 331, 129, 21);
		contentPane.add(comboBox);
	}
}
