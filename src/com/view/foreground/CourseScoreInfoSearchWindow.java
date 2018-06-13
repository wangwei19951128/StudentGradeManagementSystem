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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.main.Main;
import com.model.CourseScore;
import com.view.LoginWindow;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		setBounds(100, 100, 1900, 1000);
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
		panel.setBounds(10, 29, 262, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("个人成绩");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 242, 70);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" 姓名");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 78, 84, 62);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel(" 学号");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 150, 84, 62);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(104, 94, 148, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 166, 148, 31);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.addActionListener(e -> {
			//数据库查询验证
			PersonalScoreInfoWindow frame;
			String tname = textField_1.getText();
			String name1 = textField.getText();
			try {
				frame = new PersonalScoreInfoWindow(tname,name1);
				if(frame.searchP()) {
					frame.exeTFrame();
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
		btnNewButton.setBounds(10, 212, 242, 31);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(282, 29, 1592, 922);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setRowHeight(25);
		Vector<CourseScore> model=Main.databaseConnection.queryCourseScoreInfo();
		Object tsdata[][] = new Object[model.size()][7];
		for(int i=0;i<model.size();i++) {
			CourseScore cst = model.get(i);
			tsdata[i][0] = cst.getId();
			tsdata[i][1] = cst.getUsername();
			tsdata[i][2] = (int)cst.getEa();
			tsdata[i][3] = (int)cst.getBs();
			tsdata[i][4] = (int)cst.getFi();
			tsdata[i][5] = (int)cst.getCp();
			tsdata[i][6] = (int)cst.getTg();
 					
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
