package com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.main.Main;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1900, 1000);
		
		getFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getFrame().addWindowListener(new WindowAdapter() {
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

		int windowWidth = frame.getWidth(); // 获得窗口宽
		int windowHeight = frame.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		getFrame().setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1884, 600);
		getFrame().getContentPane().add(panel);
						panel.setLayout(null);
				
						JLabel label = new JLabel("\u5916\u573A\u5B9E\u4E60\u8BC4\u4F30\u7CFB\u7EDF");
						label.setBounds(742, 300, 400, 67);
						panel.add(label);
						label.setFont(new Font("微软雅黑", Font.BOLD, 50));
						label.setHorizontalAlignment(SwingConstants.CENTER);
		
				JLabel lblXxxxxxxxxxxx = new JLabel("\u822A\u7A7A\u673A\u52A1\u9662\u6821");
				lblXxxxxxxxxxxx.setBounds(792, 209, 300, 67);
				panel.add(lblXxxxxxxxxxxx);
				lblXxxxxxxxxxxx.setFont(new Font("微软雅黑", Font.BOLD, 50));
				lblXxxxxxxxxxxx.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 599, 1884, 362);
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setVgap(70);
		getFrame().getContentPane().add(panel_5);

		Box verticalBox_1 = Box.createVerticalBox();
		panel_5.add(verticalBox_1);

		JPanel panel_6 = new JPanel();
		verticalBox_1.add(panel_6);

		Component verticalGlue_2 = Box.createVerticalGlue();
		panel_6.add(verticalGlue_2);

		JPanel panel_7 = new JPanel();
		verticalBox_1.add(panel_7);

		JButton btnNewButton = new JButton("点击登陆");
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 30));
		btnNewButton.addActionListener(e -> {
			new LoginWindow();
			frame.dispose();
		});
		panel_7.add(btnNewButton);

		JPanel panel_9 = new JPanel();
		verticalBox_1.add(panel_9);

		Component verticalGlue_3 = Box.createVerticalGlue();
		panel_9.add(verticalGlue_3);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
