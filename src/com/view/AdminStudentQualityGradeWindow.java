package com.view;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.main.Main;
import com.model.KeyValueS;
import com.model.Person;
import com.model.StudentQualityGrade;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_14;
	private JTextField textField_27;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private Vector<KeyValueS> modelS;

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

		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示

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
		try {
			modelS = Main.databaseConnection.queryStudentInfo();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "初始化学生失败！", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JComboBox<KeyValueS> comboBox = new JComboBox<KeyValueS>(modelS);
		comboBox.setToolTipText("请选择班级");
		comboBox.setBounds(126, 98, 149, 21);
		contentPanel.add(comboBox);

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
			label_3.setBounds(0, 245, 116, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("实习成绩");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 201, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("专业素养");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 227, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("代教能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 254, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel lblNewLabel = new JLabel("竞赛比武");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(124, 282, 145, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel label_3 = new JLabel("组织能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 316, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("应变能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 341, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("管理能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 366, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("协调能力");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 391, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("机务精神");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 426, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("维护作风");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 451, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("实习纪律");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 476, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("实战感知");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(124, 501, 145, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("指挥管理");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(0, 355, 116, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("机务素养");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(0, 465, 116, 15);
			contentPanel.add(label_3);
		}

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(310, 198, 66, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(454, 198, 66, 21);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(608, 198, 66, 21);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBounds(310, 224, 66, 21);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBounds(454, 224, 66, 21);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setBounds(608, 224, 66, 21);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBounds(310, 251, 66, 21);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setBounds(454, 251, 66, 21);
		contentPanel.add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBounds(608, 251, 66, 21);
		contentPanel.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setBounds(310, 279, 66, 21);
		contentPanel.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setBounds(454, 279, 66, 21);
		contentPanel.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setBounds(608, 279, 66, 21);
		contentPanel.add(textField_13);
		textField_13.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setBounds(310, 313, 66, 21);
		contentPanel.add(textField_15);
		textField_15.setColumns(10);

		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setBounds(454, 313, 66, 21);
		contentPanel.add(textField_16);
		textField_16.setColumns(10);

		textField_17 = new JTextField();
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setBounds(608, 313, 66, 21);
		contentPanel.add(textField_17);
		textField_17.setColumns(10);

		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setBounds(310, 338, 66, 21);
		contentPanel.add(textField_18);
		textField_18.setColumns(10);

		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setBounds(454, 338, 66, 21);
		contentPanel.add(textField_19);
		textField_19.setColumns(10);

		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setBounds(608, 338, 66, 21);
		contentPanel.add(textField_20);
		textField_20.setColumns(10);

		textField_21 = new JTextField();
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setBounds(310, 363, 66, 21);
		contentPanel.add(textField_21);
		textField_21.setColumns(10);

		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setBounds(454, 363, 66, 21);
		contentPanel.add(textField_22);
		textField_22.setColumns(10);

		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setBounds(608, 363, 66, 21);
		contentPanel.add(textField_23);
		textField_23.setColumns(10);

		textField_24 = new JTextField();
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setBounds(310, 388, 66, 21);
		contentPanel.add(textField_24);
		textField_24.setColumns(10);

		textField_25 = new JTextField();
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setBounds(454, 388, 66, 21);
		contentPanel.add(textField_25);
		textField_25.setColumns(10);

		textField_26 = new JTextField();
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setBounds(608, 388, 66, 21);
		contentPanel.add(textField_26);
		textField_26.setColumns(10);

		textField_28 = new JTextField();
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setBounds(310, 423, 66, 21);
		contentPanel.add(textField_28);
		textField_28.setColumns(10);

		textField_29 = new JTextField();
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setBounds(454, 423, 66, 21);
		contentPanel.add(textField_29);
		textField_29.setColumns(10);

		textField_30 = new JTextField();
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		textField_30.setBounds(608, 423, 66, 21);
		contentPanel.add(textField_30);
		textField_30.setColumns(10);

		textField_31 = new JTextField();
		textField_31.setHorizontalAlignment(SwingConstants.CENTER);
		textField_31.setBounds(310, 448, 66, 21);
		contentPanel.add(textField_31);
		textField_31.setColumns(10);

		textField_32 = new JTextField();
		textField_32.setHorizontalAlignment(SwingConstants.CENTER);
		textField_32.setBounds(454, 448, 66, 21);
		contentPanel.add(textField_32);
		textField_32.setColumns(10);

		textField_33 = new JTextField();
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setBounds(608, 448, 66, 21);
		contentPanel.add(textField_33);
		textField_33.setColumns(10);

		textField_34 = new JTextField();
		textField_34.setHorizontalAlignment(SwingConstants.CENTER);
		textField_34.setBounds(310, 473, 66, 21);
		contentPanel.add(textField_34);
		textField_34.setColumns(10);

		textField_35 = new JTextField();
		textField_35.setHorizontalAlignment(SwingConstants.CENTER);
		textField_35.setBounds(454, 473, 66, 21);
		contentPanel.add(textField_35);
		textField_35.setColumns(10);

		textField_36 = new JTextField();
		textField_36.setHorizontalAlignment(SwingConstants.CENTER);
		textField_36.setBounds(608, 473, 66, 21);
		contentPanel.add(textField_36);
		textField_36.setColumns(10);

		textField_37 = new JTextField();
		textField_37.setHorizontalAlignment(SwingConstants.CENTER);
		textField_37.setBounds(310, 498, 66, 21);
		contentPanel.add(textField_37);
		textField_37.setColumns(10);

		textField_38 = new JTextField();
		textField_38.setHorizontalAlignment(SwingConstants.CENTER);
		textField_38.setBounds(454, 498, 66, 21);
		contentPanel.add(textField_38);
		textField_38.setColumns(10);

		textField_39 = new JTextField();
		textField_39.setHorizontalAlignment(SwingConstants.CENTER);
		textField_39.setBounds(608, 498, 66, 21);
		contentPanel.add(textField_39);
		textField_39.setColumns(10);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(758, 198, 66, 21);
		contentPanel.add(textField);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(758, 224, 66, 21);
		contentPanel.add(textField_1);

		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setColumns(10);
		textField_14.setBounds(758, 251, 66, 21);
		contentPanel.add(textField_14);

		textField_27 = new JTextField();
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setColumns(10);
		textField_27.setBounds(758, 279, 66, 21);
		contentPanel.add(textField_27);

		textField_40 = new JTextField();
		textField_40.setHorizontalAlignment(SwingConstants.CENTER);
		textField_40.setColumns(10);
		textField_40.setBounds(758, 313, 66, 21);
		contentPanel.add(textField_40);

		textField_41 = new JTextField();
		textField_41.setHorizontalAlignment(SwingConstants.CENTER);
		textField_41.setColumns(10);
		textField_41.setBounds(758, 338, 66, 21);
		contentPanel.add(textField_41);

		textField_42 = new JTextField();
		textField_42.setHorizontalAlignment(SwingConstants.CENTER);
		textField_42.setColumns(10);
		textField_42.setBounds(758, 363, 66, 21);
		contentPanel.add(textField_42);

		textField_43 = new JTextField();
		textField_43.setHorizontalAlignment(SwingConstants.CENTER);
		textField_43.setColumns(10);
		textField_43.setBounds(758, 388, 66, 21);
		contentPanel.add(textField_43);

		textField_44 = new JTextField();
		textField_44.setHorizontalAlignment(SwingConstants.CENTER);
		textField_44.setColumns(10);
		textField_44.setBounds(758, 423, 66, 21);
		contentPanel.add(textField_44);

		textField_45 = new JTextField();
		textField_45.setHorizontalAlignment(SwingConstants.CENTER);
		textField_45.setColumns(10);
		textField_45.setBounds(758, 448, 66, 21);
		contentPanel.add(textField_45);

		textField_46 = new JTextField();
		textField_46.setHorizontalAlignment(SwingConstants.CENTER);
		textField_46.setColumns(10);
		textField_46.setBounds(758, 473, 66, 21);
		contentPanel.add(textField_46);

		textField_47 = new JTextField();
		textField_47.setHorizontalAlignment(SwingConstants.CENTER);
		textField_47.setColumns(10);
		textField_47.setBounds(758, 498, 66, 21);
		contentPanel.add(textField_47);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 528, 884, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("确认");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(e -> {
					int qualityGradeSID;
					try {
						qualityGradeSID = Main.databaseConnection.queryStudentQualityGradeInfoNumber() + 1;
						Person student = new Person();
						student.setUsername(((KeyValueS) comboBox.getSelectedItem()).getId());
						StudentQualityGrade studentQualityGrade = new StudentQualityGrade(student, qualityGradeSID);
						studentQualityGrade.setGrade(0, 0, Float.parseFloat(textField_2.getText()));
						studentQualityGrade.setGrade(1, 0, Float.parseFloat(textField_5.getText()));
						studentQualityGrade.setGrade(2, 0, Float.parseFloat(textField_8.getText()));
						studentQualityGrade.setGrade(3, 0, Float.parseFloat(textField_11.getText()));
						studentQualityGrade.setGrade(4, 0, Float.parseFloat(textField_15.getText()));
						studentQualityGrade.setGrade(5, 0, Float.parseFloat(textField_18.getText()));
						studentQualityGrade.setGrade(6, 0, Float.parseFloat(textField_21.getText()));
						studentQualityGrade.setGrade(7, 0, Float.parseFloat(textField_24.getText()));
						studentQualityGrade.setGrade(8, 0, Float.parseFloat(textField_28.getText()));
						studentQualityGrade.setGrade(9, 0, Float.parseFloat(textField_31.getText()));
						studentQualityGrade.setGrade(10, 0, Float.parseFloat(textField_34.getText()));
						studentQualityGrade.setGrade(11, 0, Float.parseFloat(textField_37.getText()));

						studentQualityGrade.setGrade(0, 1, Float.parseFloat(textField_3.getText()));
						studentQualityGrade.setGrade(1, 1, Float.parseFloat(textField_6.getText()));
						studentQualityGrade.setGrade(2, 1, Float.parseFloat(textField_9.getText()));
						studentQualityGrade.setGrade(3, 1, Float.parseFloat(textField_12.getText()));
						studentQualityGrade.setGrade(4, 1, Float.parseFloat(textField_16.getText()));
						studentQualityGrade.setGrade(5, 1, Float.parseFloat(textField_19.getText()));
						studentQualityGrade.setGrade(6, 1, Float.parseFloat(textField_22.getText()));
						studentQualityGrade.setGrade(7, 1, Float.parseFloat(textField_25.getText()));
						studentQualityGrade.setGrade(8, 1, Float.parseFloat(textField_29.getText()));
						studentQualityGrade.setGrade(9, 1, Float.parseFloat(textField_32.getText()));
						studentQualityGrade.setGrade(10, 1, Float.parseFloat(textField_35.getText()));
						studentQualityGrade.setGrade(11, 1, Float.parseFloat(textField_38.getText()));

						studentQualityGrade.setGrade(0, 2, Float.parseFloat(textField_4.getText()));
						studentQualityGrade.setGrade(1, 2, Float.parseFloat(textField_7.getText()));
						studentQualityGrade.setGrade(2, 2, Float.parseFloat(textField_10.getText()));
						studentQualityGrade.setGrade(3, 2, Float.parseFloat(textField_13.getText()));
						studentQualityGrade.setGrade(4, 2, Float.parseFloat(textField_17.getText()));
						studentQualityGrade.setGrade(5, 2, Float.parseFloat(textField_20.getText()));
						studentQualityGrade.setGrade(6, 2, Float.parseFloat(textField_23.getText()));
						studentQualityGrade.setGrade(7, 2, Float.parseFloat(textField_26.getText()));
						studentQualityGrade.setGrade(8, 2, Float.parseFloat(textField_30.getText()));
						studentQualityGrade.setGrade(9, 2, Float.parseFloat(textField_33.getText()));
						studentQualityGrade.setGrade(10, 2, Float.parseFloat(textField_36.getText()));
						studentQualityGrade.setGrade(11, 2, Float.parseFloat(textField_39.getText()));

						studentQualityGrade.setGrade(0, 3, Float.parseFloat(textField.getText()));
						studentQualityGrade.setGrade(1, 3, Float.parseFloat(textField_1.getText()));
						studentQualityGrade.setGrade(2, 3, Float.parseFloat(textField_14.getText()));
						studentQualityGrade.setGrade(3, 3, Float.parseFloat(textField_27.getText()));
						studentQualityGrade.setGrade(4, 3, Float.parseFloat(textField_40.getText()));
						studentQualityGrade.setGrade(5, 3, Float.parseFloat(textField_41.getText()));
						studentQualityGrade.setGrade(6, 3, Float.parseFloat(textField_42.getText()));
						studentQualityGrade.setGrade(7, 3, Float.parseFloat(textField_43.getText()));
						studentQualityGrade.setGrade(8, 3, Float.parseFloat(textField_44.getText()));
						studentQualityGrade.setGrade(9, 3, Float.parseFloat(textField_45.getText()));
						studentQualityGrade.setGrade(10, 3, Float.parseFloat(textField_46.getText()));
						studentQualityGrade.setGrade(11, 3, Float.parseFloat(textField_47.getText()));

						float moduleGrade0 = (Float.parseFloat(textField_14.getText())
								+ Float.parseFloat(textField_27.getText()) + Float.parseFloat(textField_1.getText())
								+ Float.parseFloat(textField.getText())) / 4;
						studentQualityGrade.setModuleGrade(0, moduleGrade0);
						float moduleGrade1 = (Float.parseFloat(textField_40.getText())
								+ Float.parseFloat(textField_41.getText()) + Float.parseFloat(textField_42.getText())
								+ Float.parseFloat(textField_43.getText())) / 4;
						studentQualityGrade.setModuleGrade(1, moduleGrade1);
						float moduleGrade2 = (Float.parseFloat(textField_44.getText())
								+ Float.parseFloat(textField_45.getText()) + Float.parseFloat(textField_46.getText())
								+ Float.parseFloat(textField_47.getText())) / 4;
						studentQualityGrade.setModuleGrade(2, moduleGrade2);
						studentQualityGrade.setTotalGrade((moduleGrade0 + moduleGrade1 + moduleGrade2) / 3);
						Main.databaseConnection.addStudentQualityGradeInfo(studentQualityGrade);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
