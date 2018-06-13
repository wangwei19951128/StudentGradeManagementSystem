package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.main.Main;
import com.model.Person;

public class AdminStudentInfoModifyWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7990143994175382000L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the dialog.
	 */
	public AdminStudentInfoModifyWindow() {
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
			JLabel label = new JLabel("修改学生信息");
			label.setFont(new Font("微软雅黑", Font.BOLD, 50));
			label.setBounds(785, 221, 314, 78);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("姓名");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(752, 497, 116, 38);
			contentPanel.add(label);
		}
		
		textField = new JTextField();
		textField.setToolTipText("请输入修改后的名称");
		textField.setBounds(924, 510, 149, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel label = new JLabel("用户名");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(773, 412, 95, 41);
			contentPanel.add(label);
		}
		{
			textField_1 = new JTextField();
			textField_1.setToolTipText("输入要修改学生的用户名");
			textField_1.setBounds(924, 426, 149, 21);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
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
					Person student=new Person();
					student.setUsername(textField_1.getText());
					student.setName(textField.getText());
					try {
						Main.databaseConnection.modifyPersonInfo(student);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "修改学生信息失败！", "错误", JOptionPane.ERROR_MESSAGE);
					}
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
