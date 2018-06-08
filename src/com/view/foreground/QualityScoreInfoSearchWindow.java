package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
import com.model.CourseScore;
import com.model.StudentGrade;
import com.model.StudentQualityGrade;
import com.view.LoginWindow;

public class QualityScoreInfoSearchWindow extends JFrame {

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
					QualityScoreInfoSearchWindow frame = new QualityScoreInfoSearchWindow();
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
	public QualityScoreInfoSearchWindow() throws SQLException {
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
		btnNewButton.addActionListener(e->{
			//验证成功
			String uname = textField.getText();
			String tname = textField_1.getText();
			PersonalQualityScoreInfoSearchWindow frame;
			frame = new PersonalQualityScoreInfoSearchWindow(tname,uname);
			try {
				if(frame.searchP()) {
					frame.exePersonalQualityScore();
					frame.setVisible(true);
					this.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "查询失败 ", "查询结果 ", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		});
		btnNewButton.setBounds(10, 78, 84, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 29, 450, 322);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Vector<StudentQualityGrade> model=Main.databaseConnection.queryQualityScoreInfo();
		Object tsdata[][] = new Object[model.size()][6];
		for(int i=0;i<model.size();i++) {
			StudentQualityGrade cst = model.get(i);
			tsdata[i][0] = i;
			tsdata[i][1] = cst.getStudent().getName();
			tsdata[i][2] = cst.getModuleGrade()[0];
			tsdata[i][3] = cst.getModuleGrade()[1];
			tsdata[i][4] = cst.getModuleGrade()[2];
			tsdata[i][5] = cst.getTotalGrade();
 					
		}
		table.setModel(new DefaultTableModel(
			tsdata,
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
