package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.main.Main;
import com.model.KeyValue;

import javax.swing.JComboBox;

public class AdminClassInfoModifyWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5595552187339282354L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Vector<KeyValue> model;

	/**
	 * Create the dialog.
	 */
	public AdminClassInfoModifyWindow() {
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示

		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("修改班级信息");
			label.setFont(new Font("微软雅黑", Font.BOLD, 50));
			label.setBounds(135, 58, 314, 78);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("班级名称");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(146, 193, 116, 38);
			contentPanel.add(label);
		}

		textField = new JTextField();
		textField.setToolTipText("请输入修改后的班级名称");
		textField.setBounds(273, 202, 149, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel label = new JLabel("选择班级");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(147, 158, 115, 38);
			contentPanel.add(label);
		}

		try {
			model = Main.databaseConnection.queryClassInfo();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "初始化班级失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JComboBox<KeyValue> comboBox = new JComboBox<KeyValue>(model);
		comboBox.setToolTipText("请选择要修改的班级");
		comboBox.setBounds(273, 171, 149, 21);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确认");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(e -> {
					int id=((KeyValue)comboBox.getSelectedItem()).getId();
					String classname=textField.getText();
					try {
						Main.databaseConnection.modifyClassInfo(id, classname);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "修改班级信息失败！", "错误", JOptionPane.ERROR_MESSAGE);
					}
					this.dispose();
				});
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(e -> {
					this.dispose();
				});
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}
}
