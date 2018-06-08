package com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.main.Main;
import com.view.foreground.ClassGeneralInfoWindow;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4224112302296988707L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);

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

		
		JLabel label = new JLabel("\u767B\u9646");
		label.setFont(new Font("微软雅黑", Font.BOLD, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(231, 49, 131, 86);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(140, 152, 95, 28);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u5BC6   \u7801");
		label_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(140, 186, 95, 30);
		contentPane.add(label_2);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setToolTipText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		textField.setBounds(257, 156, 180, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setToolTipText("\u8BF7\u8F93\u5165\u5BC6\u7801");
		textField_1.setBounds(257, 191, 180, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton button = new JButton("\u70B9\u51FB\u767B\u9646");
		button.setFont(new Font("微软雅黑 Light", Font.PLAIN, 30));
		button.setBounds(214, 261, 166, 38);
		button.addActionListener(e -> {
			String username = textField.getText();
			String password = textField_1.getText();
			try {
				Main.person = Main.databaseConnection.login(username, password);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (Main.person.getRole() == 0) {
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
				// 学生前台界面
				// new AdminWindow();
				 this.dispose();
			} else if (Main.person.getRole() == 1) {
				new AdminWindow();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "登陆失败！", "错误", JOptionPane.ERROR_MESSAGE);
			}
		});
		contentPane.add(button);
		setVisible(true);
	}
}
