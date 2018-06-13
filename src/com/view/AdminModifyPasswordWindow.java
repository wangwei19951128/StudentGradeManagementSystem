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

public class AdminModifyPasswordWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1956936033864880470L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminModifyPasswordWindow dialog = new AdminModifyPasswordWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminModifyPasswordWindow() {
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
			JLabel label = new JLabel("修改教师密码");
			label.setFont(new Font("微软雅黑", Font.BOLD, 50));
			label.setBounds(785, 227, 314, 78);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("新密码");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(746, 435, 116, 38);
			contentPanel.add(label);
		}
		
		textField = new JTextField();
		textField.setToolTipText("请输入修改后的密码");
		textField.setBounds(906, 448, 193, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确认");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(e->{
					Main.person.setPassword(textField.getText());
					try {
						Main.databaseConnection.modifyPasswordInfo(Main.person);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "修改密码失败！", "错误", JOptionPane.ERROR_MESSAGE);
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
