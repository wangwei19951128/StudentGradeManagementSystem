package com.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminStudentQualityGradeWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5861882015230074990L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminStudentQualityGradeWindow dialog = new AdminStudentQualityGradeWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminStudentQualityGradeWindow() {
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 884, 528);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("录入素质评分");
			label.setFont(new Font("微软雅黑", Font.BOLD, 50));
			label.setBounds(285, 58, 314, 78);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("用户名");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(0, 88, 95, 41);
			contentPanel.add(label);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setToolTipText("请选择班级");
			comboBox.setBounds(126, 98, 149, 21);
			contentPanel.add(comboBox);
		}
		
		JLabel label = new JLabel("模块");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 169, 116, 15);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("指标");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(114, 169, 158, 15);
		contentPanel.add(label_1);
		{
			JLabel label_2 = new JLabel("第一课时");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(285, 169, 116, 15);
			contentPanel.add(label_2);
		}
		{
			JLabel label_2 = new JLabel("第二课时");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(425, 169, 124, 15);
			contentPanel.add(label_2);
		}
		{
			JLabel label_2 = new JLabel("第三课时");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(573, 169, 136, 15);
			contentPanel.add(label_2);
		}
		
		JLabel label_2 = new JLabel("分数");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(737, 169, 109, 15);
		contentPanel.add(label_2);
		{
			JLabel label_3 = new JLabel("知识技能");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(31, 245, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("实习成绩");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 201, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("专业素养");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 227, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("代教能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 254, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel lblNewLabel = new JLabel("竞赛比武");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(166, 282, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel label_3 = new JLabel("组织能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 316, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("应变能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 341, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("管理能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 366, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("协调能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 391, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("机务精神");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 426, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("维护作风");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 451, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("实习纪律");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 476, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("实战感知");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(166, 501, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("指挥管理");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(31, 355, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("机务素养");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(31, 465, 54, 15);
			contentPanel.add(label_3);
		}
		
		textField_2 = new JTextField();
		textField_2.setBounds(310, 198, 66, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(454, 198, 66, 21);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(608, 198, 66, 21);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(310, 224, 66, 21);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(454, 224, 66, 21);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(608, 224, 66, 21);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(310, 251, 66, 21);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(454, 251, 66, 21);
		contentPanel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(608, 251, 66, 21);
		contentPanel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(310, 279, 66, 21);
		contentPanel.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(454, 279, 66, 21);
		contentPanel.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(608, 279, 66, 21);
		contentPanel.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(758, 242, 66, 21);
		contentPanel.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(310, 313, 66, 21);
		contentPanel.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(454, 313, 66, 21);
		contentPanel.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(608, 313, 66, 21);
		contentPanel.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(310, 338, 66, 21);
		contentPanel.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(454, 338, 66, 21);
		contentPanel.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBounds(608, 338, 66, 21);
		contentPanel.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setBounds(310, 363, 66, 21);
		contentPanel.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(454, 363, 66, 21);
		contentPanel.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(608, 363, 66, 21);
		contentPanel.add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setBounds(310, 388, 66, 21);
		contentPanel.add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setBounds(454, 388, 66, 21);
		contentPanel.add(textField_25);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setBounds(608, 388, 66, 21);
		contentPanel.add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setBounds(758, 352, 66, 21);
		contentPanel.add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setBounds(310, 423, 66, 21);
		contentPanel.add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setBounds(454, 423, 66, 21);
		contentPanel.add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setBounds(608, 423, 66, 21);
		contentPanel.add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setBounds(310, 448, 66, 21);
		contentPanel.add(textField_31);
		textField_31.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.setBounds(454, 448, 66, 21);
		contentPanel.add(textField_32);
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setBounds(608, 448, 66, 21);
		contentPanel.add(textField_33);
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setBounds(310, 473, 66, 21);
		contentPanel.add(textField_34);
		textField_34.setColumns(10);
		
		textField_35 = new JTextField();
		textField_35.setBounds(454, 473, 66, 21);
		contentPanel.add(textField_35);
		textField_35.setColumns(10);
		
		textField_36 = new JTextField();
		textField_36.setBounds(608, 473, 66, 21);
		contentPanel.add(textField_36);
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setBounds(310, 498, 66, 21);
		contentPanel.add(textField_37);
		textField_37.setColumns(10);
		
		textField_38 = new JTextField();
		textField_38.setBounds(454, 498, 66, 21);
		contentPanel.add(textField_38);
		textField_38.setColumns(10);
		
		textField_39 = new JTextField();
		textField_39.setBounds(608, 498, 66, 21);
		contentPanel.add(textField_39);
		textField_39.setColumns(10);
		
		textField_40 = new JTextField();
		textField_40.setBounds(758, 462, 66, 21);
		contentPanel.add(textField_40);
		textField_40.setColumns(10);
		
		label_4 = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------");
		label_4.setBounds(0, 185, 884, 15);
		contentPanel.add(label_4);
		
		label_5 = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------");
		label_5.setBounds(0, 300, 884, 15);
		contentPanel.add(label_5);
		
		label_6 = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------");
		label_6.setBounds(0, 410, 884, 15);
		contentPanel.add(label_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 528, 884, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("确认");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
