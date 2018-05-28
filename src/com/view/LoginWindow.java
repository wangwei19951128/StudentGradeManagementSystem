package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u767B\u9646");
		label.setFont(new Font("微软雅黑", Font.BOLD, 50));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(247, 56, 131, 86);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(164, 160, 95, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6   \u7801");
		label_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(164, 194, 95, 30);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setToolTipText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		textField.setBounds(281, 164, 180, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setToolTipText("\u8BF7\u8F93\u5165\u5BC6\u7801");
		textField_1.setBounds(281, 199, 180, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u70B9\u51FB\u767B\u9646");
		button.setFont(new Font("微软雅黑 Light", Font.PLAIN, 30));
		button.setBounds(230, 261, 166, 38);
		contentPane.add(button);
	}
}
