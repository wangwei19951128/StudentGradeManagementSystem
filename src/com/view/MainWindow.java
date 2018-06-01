package com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class MainWindow {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 900, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int windowWidth = frame.getWidth(); // 获得窗口宽
		int windowHeight = frame.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		getFrame().setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示

		JPanel panel = new JPanel();
		getFrame().getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));

		Box verticalBox = Box.createVerticalBox();
		panel.add(verticalBox);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(25);
		verticalBox.add(panel_3);

		Component verticalGlue = Box.createVerticalGlue();
		panel_3.add(verticalGlue);

		JPanel panel_1 = new JPanel();
		verticalBox.add(panel_1);

		JLabel lblXxxxxxxxxxxx = new JLabel("\u822A\u7A7A\u673A\u52A1\u9662\u6821");
		lblXxxxxxxxxxxx.setFont(new Font("微软雅黑", Font.BOLD, 50));
		lblXxxxxxxxxxxx.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblXxxxxxxxxxxx);

		JPanel panel_2 = new JPanel();
		verticalBox.add(panel_2);

		JLabel label = new JLabel("\u5916\u573A\u5B9E\u4E60\u8BC4\u4F30\u7CFB\u7EDF");
		label.setFont(new Font("微软雅黑", Font.BOLD, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label);

		JPanel panel_4 = new JPanel();
		verticalBox.add(panel_4);

		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_4.add(verticalGlue_1);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setVgap(70);
		getFrame().getContentPane().add(panel_5, BorderLayout.CENTER);

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
