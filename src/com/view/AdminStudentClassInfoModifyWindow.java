package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.main.Main;
import com.model.KeyValue;
import com.model.KeyValueS;

public class AdminStudentClassInfoModifyWindow extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8058536276325664016L;
	private final JPanel contentPanel = new JPanel();
	private Vector<KeyValue> model;
	private Vector<KeyValueS> modelS;

	/**
	 * Create the dialog.
	 */
	public AdminStudentClassInfoModifyWindow() {
		setBounds(100, 100, 1900, 1000);
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
			JLabel label = new JLabel("修改分配班级");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("微软雅黑", Font.BOLD, 50));
			label.setBounds(785, 245, 314, 78);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("选择班级");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(753, 495, 116, 38);
			contentPanel.add(label);
		}

		JLabel label = new JLabel("选择学生");
		label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(763, 404, 106, 37);
		contentPanel.add(label);

		try {
			modelS = Main.databaseConnection.queryStudentInfo();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "初始化学生失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JComboBox<KeyValueS> comboBox = new JComboBox<KeyValueS>(modelS);
		comboBox.setToolTipText("选择要修改的学生");
		comboBox.setBounds(907, 416, 188, 21);
		contentPanel.add(comboBox);

		try {
			model = Main.databaseConnection.queryClassInfo();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "初始化班级失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JComboBox<KeyValue> comboBox_1 = new JComboBox<KeyValue>(model);
		comboBox_1.setToolTipText("选择修改后的班级");
		comboBox_1.setBounds(907, 508, 188, 21);
		contentPanel.add(comboBox_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确认");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(e -> {
					String username = ((KeyValueS) comboBox.getSelectedItem()).getId();
					int classId = ((KeyValue) comboBox_1.getSelectedItem()).getId();
					try {
						Main.databaseConnection.modifyStudentClassInfo(username, classId);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "添加班级信息失败！", "错误", JOptionPane.ERROR_MESSAGE);
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
