package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminTeacherInfoModifyWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6628286540925892148L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the dialog.
	 */
	public AdminTeacherInfoModifyWindow() {
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示
		
		{
			JLabel label = new JLabel("修改教师信息");
			label.setFont(new Font("微软雅黑", Font.BOLD, 50));
			label.setBounds(135, 58, 314, 78);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("姓名");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(147, 193, 116, 38);
			contentPanel.add(label);
		}

		textField = new JTextField();
		textField.setToolTipText("请输入修改后的名称");
		textField.setBounds(273, 202, 149, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel label = new JLabel("用户名");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(168, 146, 95, 41);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setToolTipText("输入要修改教师的用户名");
			textField_1.setBounds(273, 156, 149, 21);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel label = new JLabel("密码");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(192, 245, 71, 28);
			contentPanel.add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setToolTipText("请输入修改后的密码");
			textField_2.setBounds(273, 249, 149, 21);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确认");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(e->{
					this.dispose();
				});
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(e->{
					this.dispose();
				});
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}

}
