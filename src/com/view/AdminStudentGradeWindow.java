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
import com.model.StudentGrade;

public class AdminStudentGradeWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4603417670656339494L;
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
	private JLabel label_7;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_69;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_74;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_80;
	private JTextField textField_81;
	private JTextField textField_82;
	private JTextField textField_83;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_14;
	private JTextField textField_84;
	private JTextField textField_85;
	private JTextField textField_86;
	private JTextField textField_87;
	private JTextField textField_88;
	private JTextField textField_89;
	private JTextField textField_90;
	private JTextField textField_91;
	private JTextField textField_92;
	private JTextField textField_94;
	private JTextField textField_95;
	private JTextField textField_96;
	private JTextField textField_97;
	private JTextField textField_98;
	private JTextField textField_99;
	private Vector<KeyValueS> modelS;

	/**
	 * Create the dialog.
	 */
	public AdminStudentGradeWindow() {
		setBounds(100, 100, 1900, 1000);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1884, 918);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示

		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("录入个人成绩");
			label.setFont(new Font("微软雅黑", Font.BOLD, 50));
			label.setBounds(785, 58, 314, 78);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("用户名");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
			label.setBounds(250, 88, 95, 41);
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
		comboBox.setToolTipText("请选择学生的用户名");
		comboBox.setBounds(391, 102, 149, 21);
		contentPanel.add(comboBox);

		JLabel label = new JLabel("模块");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(200, 200, 200, 15);
		contentPanel.add(label);

		JLabel label_1 = new JLabel("课程");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(400, 200, 400, 15);
		contentPanel.add(label_1);
		{
			JLabel label_2 = new JLabel("课前课后表现");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(800, 200, 150, 15);
			contentPanel.add(label_2);
		}
		{
			JLabel label_2 = new JLabel("集中授课表现");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(950, 200, 150, 15);
			contentPanel.add(label_2);
		}
		{
			JLabel label_2 = new JLabel("练习中表现");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(1100, 200, 150, 15);
			contentPanel.add(label_2);
		}
		{
			JLabel label_3 = new JLabel("机务素养");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(200, 250, 200, 150);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("实战化开训");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 250, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("航空兵机务部队组织架构和机务工作流程");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 280, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("航空机务法规专项教育");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 310, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel lblNewLabel = new JLabel("飞行保障和典型定检工作");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(400, 340, 400, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel label_3 = new JLabel("基本维护技能");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 370, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("机件的拆装及保险");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 400, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("歼7飞机机轮安装");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 430, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("机身后段的拆装");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 460, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("副油箱减速伞的安装与投放");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 490, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("联合收放检查");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 520, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("刹车压力油门操纵系统检查与调整");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 550, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("平尾操纵系统检查与调整");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(400, 580, 400, 30);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("基本技能");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(200, 400, 200, 240);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("部队实习");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(200, 640, 200, 90);
			contentPanel.add(label_3);
		}

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(840, 255, 66, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(990, 255, 66, 21);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(1145, 255, 66, 21);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBounds(840, 285, 66, 21);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBounds(990, 285, 66, 21);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setBounds(1145, 285, 66, 21);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBounds(840, 315, 66, 21);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setBounds(990, 315, 66, 21);
		contentPanel.add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBounds(1145, 315, 66, 21);
		contentPanel.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setBounds(840, 345, 66, 21);
		contentPanel.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setBounds(990, 345, 66, 21);
		contentPanel.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setBounds(1145, 345, 66, 21);
		contentPanel.add(textField_13);
		textField_13.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setBounds(840, 375, 66, 21);
		contentPanel.add(textField_15);
		textField_15.setColumns(10);

		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setBounds(990, 375, 66, 21);
		contentPanel.add(textField_16);
		textField_16.setColumns(10);

		textField_17 = new JTextField();
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setBounds(1145, 375, 66, 21);
		contentPanel.add(textField_17);
		textField_17.setColumns(10);

		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setBounds(840, 405, 66, 21);
		contentPanel.add(textField_18);
		textField_18.setColumns(10);

		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setBounds(990, 405, 66, 21);
		contentPanel.add(textField_19);
		textField_19.setColumns(10);

		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setBounds(1145, 405, 66, 21);
		contentPanel.add(textField_20);
		textField_20.setColumns(10);

		textField_21 = new JTextField();
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setBounds(840, 435, 66, 21);
		contentPanel.add(textField_21);
		textField_21.setColumns(10);

		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setBounds(990, 435, 66, 21);
		contentPanel.add(textField_22);
		textField_22.setColumns(10);

		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setBounds(1145, 435, 66, 21);
		contentPanel.add(textField_23);
		textField_23.setColumns(10);

		textField_24 = new JTextField();
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setBounds(840, 465, 66, 21);
		contentPanel.add(textField_24);
		textField_24.setColumns(10);

		textField_25 = new JTextField();
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setBounds(990, 465, 66, 21);
		contentPanel.add(textField_25);
		textField_25.setColumns(10);

		textField_26 = new JTextField();
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setBounds(1145, 465, 66, 21);
		contentPanel.add(textField_26);
		textField_26.setColumns(10);

		textField_28 = new JTextField();
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setBounds(840, 795, 66, 21);
		contentPanel.add(textField_28);
		textField_28.setColumns(10);

		textField_29 = new JTextField();
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setBounds(990, 495, 66, 21);
		contentPanel.add(textField_29);
		textField_29.setColumns(10);

		textField_30 = new JTextField();
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		textField_30.setBounds(1145, 495, 66, 21);
		contentPanel.add(textField_30);
		textField_30.setColumns(10);

		textField_31 = new JTextField();
		textField_31.setHorizontalAlignment(SwingConstants.CENTER);
		textField_31.setBounds(840, 495, 66, 21);
		contentPanel.add(textField_31);
		textField_31.setColumns(10);

		textField_32 = new JTextField();
		textField_32.setHorizontalAlignment(SwingConstants.CENTER);
		textField_32.setBounds(990, 525, 66, 21);
		contentPanel.add(textField_32);
		textField_32.setColumns(10);

		textField_33 = new JTextField();
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setBounds(1145, 525, 66, 21);
		contentPanel.add(textField_33);
		textField_33.setColumns(10);

		textField_34 = new JTextField();
		textField_34.setHorizontalAlignment(SwingConstants.CENTER);
		textField_34.setBounds(840, 525, 66, 21);
		contentPanel.add(textField_34);
		textField_34.setColumns(10);

		textField_35 = new JTextField();
		textField_35.setHorizontalAlignment(SwingConstants.CENTER);
		textField_35.setBounds(990, 555, 66, 21);
		contentPanel.add(textField_35);
		textField_35.setColumns(10);

		textField_36 = new JTextField();
		textField_36.setHorizontalAlignment(SwingConstants.CENTER);
		textField_36.setBounds(1145, 555, 66, 21);
		contentPanel.add(textField_36);
		textField_36.setColumns(10);

		textField_37 = new JTextField();
		textField_37.setHorizontalAlignment(SwingConstants.CENTER);
		textField_37.setBounds(840, 555, 66, 21);
		contentPanel.add(textField_37);
		textField_37.setColumns(10);

		textField_38 = new JTextField();
		textField_38.setHorizontalAlignment(SwingConstants.CENTER);
		textField_38.setBounds(990, 585, 66, 21);
		contentPanel.add(textField_38);
		textField_38.setColumns(10);

		textField_39 = new JTextField();
		textField_39.setHorizontalAlignment(SwingConstants.CENTER);
		textField_39.setBounds(1145, 585, 66, 21);
		contentPanel.add(textField_39);
		textField_39.setColumns(10);

		label_7 = new JLabel("比武竞赛表现");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(1250, 200, 150, 15);
		contentPanel.add(label_7);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(1290, 255, 66, 21);
		contentPanel.add(textField);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(1290, 285, 66, 21);
		contentPanel.add(textField_1);

		textField_41 = new JTextField();
		textField_41.setHorizontalAlignment(SwingConstants.CENTER);
		textField_41.setColumns(10);
		textField_41.setBounds(1290, 315, 66, 21);
		contentPanel.add(textField_41);

		textField_42 = new JTextField();
		textField_42.setHorizontalAlignment(SwingConstants.CENTER);
		textField_42.setColumns(10);
		textField_42.setBounds(1290, 345, 66, 21);
		contentPanel.add(textField_42);

		textField_43 = new JTextField();
		textField_43.setHorizontalAlignment(SwingConstants.CENTER);
		textField_43.setColumns(10);
		textField_43.setBounds(1290, 375, 66, 21);
		contentPanel.add(textField_43);

		textField_44 = new JTextField();
		textField_44.setHorizontalAlignment(SwingConstants.CENTER);
		textField_44.setColumns(10);
		textField_44.setBounds(1290, 405, 66, 21);
		contentPanel.add(textField_44);

		textField_45 = new JTextField();
		textField_45.setHorizontalAlignment(SwingConstants.CENTER);
		textField_45.setColumns(10);
		textField_45.setBounds(1290, 435, 66, 21);
		contentPanel.add(textField_45);

		textField_46 = new JTextField();
		textField_46.setHorizontalAlignment(SwingConstants.CENTER);
		textField_46.setColumns(10);
		textField_46.setBounds(1290, 465, 66, 21);
		contentPanel.add(textField_46);

		textField_47 = new JTextField();
		textField_47.setHorizontalAlignment(SwingConstants.CENTER);
		textField_47.setColumns(10);
		textField_47.setBounds(1290, 495, 66, 21);
		contentPanel.add(textField_47);

		textField_48 = new JTextField();
		textField_48.setHorizontalAlignment(SwingConstants.CENTER);
		textField_48.setColumns(10);
		textField_48.setBounds(1290, 525, 66, 21);
		contentPanel.add(textField_48);

		textField_49 = new JTextField();
		textField_49.setHorizontalAlignment(SwingConstants.CENTER);
		textField_49.setColumns(10);
		textField_49.setBounds(1290, 555, 66, 21);
		contentPanel.add(textField_49);

		textField_50 = new JTextField();
		textField_50.setHorizontalAlignment(SwingConstants.CENTER);
		textField_50.setColumns(10);
		textField_50.setBounds(1290, 585, 66, 21);
		contentPanel.add(textField_50);

		textField_51 = new JTextField();
		textField_51.setHorizontalAlignment(SwingConstants.CENTER);
		textField_51.setColumns(10);
		textField_51.setBounds(1440, 255, 66, 21);
		contentPanel.add(textField_51);

		textField_52 = new JTextField();
		textField_52.setHorizontalAlignment(SwingConstants.CENTER);
		textField_52.setColumns(10);
		textField_52.setBounds(1440, 285, 66, 21);
		contentPanel.add(textField_52);

		textField_53 = new JTextField();
		textField_53.setHorizontalAlignment(SwingConstants.CENTER);
		textField_53.setColumns(10);
		textField_53.setBounds(1440, 315, 66, 21);
		contentPanel.add(textField_53);

		textField_54 = new JTextField();
		textField_54.setHorizontalAlignment(SwingConstants.CENTER);
		textField_54.setColumns(10);
		textField_54.setBounds(1440, 345, 66, 21);
		contentPanel.add(textField_54);

		textField_55 = new JTextField();
		textField_55.setHorizontalAlignment(SwingConstants.CENTER);
		textField_55.setColumns(10);
		textField_55.setBounds(1440, 375, 66, 21);
		contentPanel.add(textField_55);

		textField_56 = new JTextField();
		textField_56.setHorizontalAlignment(SwingConstants.CENTER);
		textField_56.setColumns(10);
		textField_56.setBounds(1440, 405, 66, 21);
		contentPanel.add(textField_56);

		textField_57 = new JTextField();
		textField_57.setHorizontalAlignment(SwingConstants.CENTER);
		textField_57.setColumns(10);
		textField_57.setBounds(1440, 435, 66, 21);
		contentPanel.add(textField_57);

		textField_58 = new JTextField();
		textField_58.setHorizontalAlignment(SwingConstants.CENTER);
		textField_58.setColumns(10);
		textField_58.setBounds(1440, 465, 66, 21);
		contentPanel.add(textField_58);

		textField_59 = new JTextField();
		textField_59.setHorizontalAlignment(SwingConstants.CENTER);
		textField_59.setColumns(10);
		textField_59.setBounds(1440, 495, 66, 21);
		contentPanel.add(textField_59);

		textField_60 = new JTextField();
		textField_60.setHorizontalAlignment(SwingConstants.CENTER);
		textField_60.setColumns(10);
		textField_60.setBounds(1440, 525, 66, 21);
		contentPanel.add(textField_60);

		textField_61 = new JTextField();
		textField_61.setHorizontalAlignment(SwingConstants.CENTER);
		textField_61.setColumns(10);
		textField_61.setBounds(1440, 555, 66, 21);
		contentPanel.add(textField_61);

		textField_62 = new JTextField();
		textField_62.setHorizontalAlignment(SwingConstants.CENTER);
		textField_62.setColumns(10);
		textField_62.setBounds(1440, 585, 66, 21);
		contentPanel.add(textField_62);

		label_8 = new JLabel("模拟骨干表现");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(1400, 200, 150, 15);
		contentPanel.add(label_8);

		label_9 = new JLabel("飞行检查");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(400, 610, 400, 30);
		contentPanel.add(label_9);

		label_10 = new JLabel("机务部队实习");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(400, 640, 400, 30);
		contentPanel.add(label_10);

		label_11 = new JLabel("部队见习收获内部交流");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(400, 670, 400, 30);
		contentPanel.add(label_11);

		label_12 = new JLabel("机务部队飞行保障及定检工作");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(400, 700, 400, 30);
		contentPanel.add(label_12);

		label_13 = new JLabel("综合演练");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(200, 730, 200, 90);
		contentPanel.add(label_13);

		textField_63 = new JTextField();
		textField_63.setHorizontalAlignment(SwingConstants.CENTER);
		textField_63.setColumns(10);
		textField_63.setBounds(840, 585, 66, 21);
		contentPanel.add(textField_63);

		textField_64 = new JTextField();
		textField_64.setHorizontalAlignment(SwingConstants.CENTER);
		textField_64.setColumns(10);
		textField_64.setBounds(990, 615, 66, 21);
		contentPanel.add(textField_64);

		textField_65 = new JTextField();
		textField_65.setHorizontalAlignment(SwingConstants.CENTER);
		textField_65.setColumns(10);
		textField_65.setBounds(1145, 615, 66, 21);
		contentPanel.add(textField_65);

		textField_66 = new JTextField();
		textField_66.setHorizontalAlignment(SwingConstants.CENTER);
		textField_66.setColumns(10);
		textField_66.setBounds(840, 615, 66, 21);
		contentPanel.add(textField_66);

		textField_67 = new JTextField();
		textField_67.setHorizontalAlignment(SwingConstants.CENTER);
		textField_67.setColumns(10);
		textField_67.setBounds(990, 645, 66, 21);
		contentPanel.add(textField_67);

		textField_68 = new JTextField();
		textField_68.setHorizontalAlignment(SwingConstants.CENTER);
		textField_68.setColumns(10);
		textField_68.setBounds(1145, 645, 66, 21);
		contentPanel.add(textField_68);

		textField_69 = new JTextField();
		textField_69.setHorizontalAlignment(SwingConstants.CENTER);
		textField_69.setColumns(10);
		textField_69.setBounds(840, 645, 66, 21);
		contentPanel.add(textField_69);

		textField_70 = new JTextField();
		textField_70.setHorizontalAlignment(SwingConstants.CENTER);
		textField_70.setColumns(10);
		textField_70.setBounds(990, 675, 66, 21);
		contentPanel.add(textField_70);

		textField_71 = new JTextField();
		textField_71.setHorizontalAlignment(SwingConstants.CENTER);
		textField_71.setColumns(10);
		textField_71.setBounds(1145, 675, 66, 21);
		contentPanel.add(textField_71);

		textField_72 = new JTextField();
		textField_72.setHorizontalAlignment(SwingConstants.CENTER);
		textField_72.setColumns(10);
		textField_72.setBounds(840, 675, 66, 21);
		contentPanel.add(textField_72);

		textField_73 = new JTextField();
		textField_73.setHorizontalAlignment(SwingConstants.CENTER);
		textField_73.setColumns(10);
		textField_73.setBounds(990, 705, 66, 21);
		contentPanel.add(textField_73);

		textField_74 = new JTextField();
		textField_74.setHorizontalAlignment(SwingConstants.CENTER);
		textField_74.setColumns(10);
		textField_74.setBounds(1145, 705, 66, 21);
		contentPanel.add(textField_74);

		textField_76 = new JTextField();
		textField_76.setHorizontalAlignment(SwingConstants.CENTER);
		textField_76.setColumns(10);
		textField_76.setBounds(1290, 615, 66, 21);
		contentPanel.add(textField_76);

		textField_77 = new JTextField();
		textField_77.setHorizontalAlignment(SwingConstants.CENTER);
		textField_77.setColumns(10);
		textField_77.setBounds(1290, 645, 66, 21);
		contentPanel.add(textField_77);

		textField_78 = new JTextField();
		textField_78.setHorizontalAlignment(SwingConstants.CENTER);
		textField_78.setColumns(10);
		textField_78.setBounds(1290, 675, 66, 21);
		contentPanel.add(textField_78);

		textField_79 = new JTextField();
		textField_79.setHorizontalAlignment(SwingConstants.CENTER);
		textField_79.setColumns(10);
		textField_79.setBounds(1290, 705, 66, 21);
		contentPanel.add(textField_79);

		textField_80 = new JTextField();
		textField_80.setHorizontalAlignment(SwingConstants.CENTER);
		textField_80.setColumns(10);
		textField_80.setBounds(1440, 615, 66, 21);
		contentPanel.add(textField_80);

		textField_81 = new JTextField();
		textField_81.setHorizontalAlignment(SwingConstants.CENTER);
		textField_81.setColumns(10);
		textField_81.setBounds(1440, 645, 66, 21);
		contentPanel.add(textField_81);

		textField_82 = new JTextField();
		textField_82.setHorizontalAlignment(SwingConstants.CENTER);
		textField_82.setColumns(10);
		textField_82.setBounds(1440, 675, 66, 21);
		contentPanel.add(textField_82);

		textField_83 = new JTextField();
		textField_83.setHorizontalAlignment(SwingConstants.CENTER);
		textField_83.setColumns(10);
		textField_83.setBounds(1440, 705, 66, 21);
		contentPanel.add(textField_83);

		label_5 = new JLabel("发行机实装试车强化训练");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(400, 730, 400, 30);
		contentPanel.add(label_5);

		label_6 = new JLabel("空军联考");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(400, 760, 400, 30);
		contentPanel.add(label_6);

		label_14 = new JLabel("综合展示");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(400, 790, 400, 30);
		contentPanel.add(label_14);

		textField_84 = new JTextField();
		textField_84.setHorizontalAlignment(SwingConstants.CENTER);
		textField_84.setColumns(10);
		textField_84.setBounds(840, 705, 66, 21);
		contentPanel.add(textField_84);

		textField_85 = new JTextField();
		textField_85.setHorizontalAlignment(SwingConstants.CENTER);
		textField_85.setColumns(10);
		textField_85.setBounds(990, 735, 66, 21);
		contentPanel.add(textField_85);

		textField_86 = new JTextField();
		textField_86.setHorizontalAlignment(SwingConstants.CENTER);
		textField_86.setColumns(10);
		textField_86.setBounds(1145, 735, 66, 21);
		contentPanel.add(textField_86);

		textField_87 = new JTextField();
		textField_87.setHorizontalAlignment(SwingConstants.CENTER);
		textField_87.setColumns(10);
		textField_87.setBounds(840, 735, 66, 21);
		contentPanel.add(textField_87);

		textField_88 = new JTextField();
		textField_88.setHorizontalAlignment(SwingConstants.CENTER);
		textField_88.setColumns(10);
		textField_88.setBounds(990, 765, 66, 21);
		contentPanel.add(textField_88);

		textField_89 = new JTextField();
		textField_89.setHorizontalAlignment(SwingConstants.CENTER);
		textField_89.setColumns(10);
		textField_89.setBounds(1145, 765, 66, 21);
		contentPanel.add(textField_89);

		textField_90 = new JTextField();
		textField_90.setHorizontalAlignment(SwingConstants.CENTER);
		textField_90.setColumns(10);
		textField_90.setBounds(840, 765, 66, 21);
		contentPanel.add(textField_90);

		textField_91 = new JTextField();
		textField_91.setHorizontalAlignment(SwingConstants.CENTER);
		textField_91.setColumns(10);
		textField_91.setBounds(990, 795, 66, 21);
		contentPanel.add(textField_91);

		textField_92 = new JTextField();
		textField_92.setHorizontalAlignment(SwingConstants.CENTER);
		textField_92.setColumns(10);
		textField_92.setBounds(1145, 795, 66, 21);
		contentPanel.add(textField_92);

		textField_94 = new JTextField();
		textField_94.setHorizontalAlignment(SwingConstants.CENTER);
		textField_94.setColumns(10);
		textField_94.setBounds(1290, 735, 66, 21);
		contentPanel.add(textField_94);

		textField_95 = new JTextField();
		textField_95.setHorizontalAlignment(SwingConstants.CENTER);
		textField_95.setColumns(10);
		textField_95.setBounds(1290, 765, 66, 21);
		contentPanel.add(textField_95);

		textField_96 = new JTextField();
		textField_96.setHorizontalAlignment(SwingConstants.CENTER);
		textField_96.setColumns(10);
		textField_96.setBounds(1290, 795, 66, 21);
		contentPanel.add(textField_96);

		textField_97 = new JTextField();
		textField_97.setHorizontalAlignment(SwingConstants.CENTER);
		textField_97.setColumns(10);
		textField_97.setBounds(1440, 735, 66, 21);
		contentPanel.add(textField_97);

		textField_98 = new JTextField();
		textField_98.setHorizontalAlignment(SwingConstants.CENTER);
		textField_98.setColumns(10);
		textField_98.setBounds(1440, 765, 66, 21);
		contentPanel.add(textField_98);

		textField_99 = new JTextField();
		textField_99.setHorizontalAlignment(SwingConstants.CENTER);
		textField_99.setColumns(10);
		textField_99.setBounds(1440, 795, 66, 21);
		contentPanel.add(textField_99);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 928, 1884, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("确认");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(e -> {
					try {
						int bacGradeSID = Main.databaseConnection.queryStudentGradeInfoNumber() + 1;
						Person student = new Person();
						student.setUsername(((KeyValueS) comboBox.getSelectedItem()).getId());
						StudentGrade studentGrade = new StudentGrade(student, bacGradeSID);
						studentGrade.setGrade(0, 0, Float.parseFloat(textField_2.getText()));
						studentGrade.setGrade(1, 0, Float.parseFloat(textField_5.getText()));
						studentGrade.setGrade(2, 0, Float.parseFloat(textField_8.getText()));
						studentGrade.setGrade(3, 0, Float.parseFloat(textField_11.getText()));
						studentGrade.setGrade(4, 0, Float.parseFloat(textField_15.getText()));
						studentGrade.setGrade(5, 0, Float.parseFloat(textField_18.getText()));
						studentGrade.setGrade(6, 0, Float.parseFloat(textField_21.getText()));
						studentGrade.setGrade(7, 0, Float.parseFloat(textField_24.getText()));
						studentGrade.setGrade(8, 0, Float.parseFloat(textField_28.getText()));
						studentGrade.setGrade(9, 0, Float.parseFloat(textField_31.getText()));
						studentGrade.setGrade(10, 0, Float.parseFloat(textField_34.getText()));
						studentGrade.setGrade(11, 0, Float.parseFloat(textField_37.getText()));
						studentGrade.setGrade(12, 0, Float.parseFloat(textField_63.getText()));
						studentGrade.setGrade(13, 0, Float.parseFloat(textField_66.getText()));
						studentGrade.setGrade(14, 0, Float.parseFloat(textField_69.getText()));
						studentGrade.setGrade(15, 0, Float.parseFloat(textField_72.getText()));
						studentGrade.setGrade(16, 0, Float.parseFloat(textField_84.getText()));
						studentGrade.setGrade(17, 0, Float.parseFloat(textField_87.getText()));
						studentGrade.setGrade(18, 0, Float.parseFloat(textField_90.getText()));

						studentGrade.setGrade(0, 1, Float.parseFloat(textField_3.getText()));
						studentGrade.setGrade(1, 1, Float.parseFloat(textField_6.getText()));
						studentGrade.setGrade(2, 1, Float.parseFloat(textField_9.getText()));
						studentGrade.setGrade(3, 1, Float.parseFloat(textField_12.getText()));
						studentGrade.setGrade(4, 1, Float.parseFloat(textField_16.getText()));
						studentGrade.setGrade(5, 1, Float.parseFloat(textField_19.getText()));
						studentGrade.setGrade(6, 1, Float.parseFloat(textField_22.getText()));
						studentGrade.setGrade(7, 1, Float.parseFloat(textField_25.getText()));
						studentGrade.setGrade(8, 1, Float.parseFloat(textField_29.getText()));
						studentGrade.setGrade(9, 1, Float.parseFloat(textField_32.getText()));
						studentGrade.setGrade(10, 1, Float.parseFloat(textField_35.getText()));
						studentGrade.setGrade(11, 1, Float.parseFloat(textField_38.getText()));
						studentGrade.setGrade(12, 1, Float.parseFloat(textField_64.getText()));
						studentGrade.setGrade(13, 1, Float.parseFloat(textField_67.getText()));
						studentGrade.setGrade(14, 1, Float.parseFloat(textField_70.getText()));
						studentGrade.setGrade(15, 1, Float.parseFloat(textField_73.getText()));
						studentGrade.setGrade(16, 1, Float.parseFloat(textField_85.getText()));
						studentGrade.setGrade(17, 1, Float.parseFloat(textField_88.getText()));
						studentGrade.setGrade(18, 1, Float.parseFloat(textField_91.getText()));

						studentGrade.setGrade(0, 2, Float.parseFloat(textField_4.getText()));
						studentGrade.setGrade(1, 2, Float.parseFloat(textField_7.getText()));
						studentGrade.setGrade(2, 2, Float.parseFloat(textField_10.getText()));
						studentGrade.setGrade(3, 2, Float.parseFloat(textField_13.getText()));
						studentGrade.setGrade(4, 2, Float.parseFloat(textField_17.getText()));
						studentGrade.setGrade(5, 2, Float.parseFloat(textField_20.getText()));
						studentGrade.setGrade(6, 2, Float.parseFloat(textField_23.getText()));
						studentGrade.setGrade(7, 2, Float.parseFloat(textField_26.getText()));
						studentGrade.setGrade(8, 2, Float.parseFloat(textField_30.getText()));
						studentGrade.setGrade(9, 2, Float.parseFloat(textField_33.getText()));
						studentGrade.setGrade(10, 2, Float.parseFloat(textField_36.getText()));
						studentGrade.setGrade(11, 2, Float.parseFloat(textField_39.getText()));
						studentGrade.setGrade(12, 2, Float.parseFloat(textField_65.getText()));
						studentGrade.setGrade(13, 2, Float.parseFloat(textField_68.getText()));
						studentGrade.setGrade(14, 2, Float.parseFloat(textField_71.getText()));
						studentGrade.setGrade(15, 2, Float.parseFloat(textField_74.getText()));
						studentGrade.setGrade(16, 2, Float.parseFloat(textField_86.getText()));
						studentGrade.setGrade(17, 2, Float.parseFloat(textField_89.getText()));
						studentGrade.setGrade(18, 2, Float.parseFloat(textField_92.getText()));

						studentGrade.setGrade(0, 3, Float.parseFloat(textField.getText()));
						studentGrade.setGrade(1, 3, Float.parseFloat(textField_4.getText()));
						studentGrade.setGrade(2, 3, Float.parseFloat(textField_41.getText()));
						studentGrade.setGrade(3, 3, Float.parseFloat(textField_42.getText()));
						studentGrade.setGrade(4, 3, Float.parseFloat(textField_43.getText()));
						studentGrade.setGrade(5, 3, Float.parseFloat(textField_44.getText()));
						studentGrade.setGrade(6, 3, Float.parseFloat(textField_45.getText()));
						studentGrade.setGrade(7, 3, Float.parseFloat(textField_46.getText()));
						studentGrade.setGrade(8, 3, Float.parseFloat(textField_47.getText()));
						studentGrade.setGrade(9, 3, Float.parseFloat(textField_48.getText()));
						studentGrade.setGrade(10, 3, Float.parseFloat(textField_49.getText()));
						studentGrade.setGrade(11, 3, Float.parseFloat(textField_50.getText()));
						studentGrade.setGrade(12, 3, Float.parseFloat(textField_76.getText()));
						studentGrade.setGrade(13, 3, Float.parseFloat(textField_77.getText()));
						studentGrade.setGrade(14, 3, Float.parseFloat(textField_78.getText()));
						studentGrade.setGrade(15, 3, Float.parseFloat(textField_79.getText()));
						studentGrade.setGrade(16, 3, Float.parseFloat(textField_94.getText()));
						studentGrade.setGrade(17, 3, Float.parseFloat(textField_95.getText()));
						studentGrade.setGrade(18, 3, Float.parseFloat(textField_96.getText()));

						studentGrade.setGrade(0, 4, Float.parseFloat(textField_51.getText()));
						studentGrade.setGrade(1, 4, Float.parseFloat(textField_52.getText()));
						studentGrade.setGrade(2, 4, Float.parseFloat(textField_53.getText()));
						studentGrade.setGrade(3, 4, Float.parseFloat(textField_54.getText()));
						studentGrade.setGrade(4, 4, Float.parseFloat(textField_55.getText()));
						studentGrade.setGrade(5, 4, Float.parseFloat(textField_56.getText()));
						studentGrade.setGrade(6, 4, Float.parseFloat(textField_57.getText()));
						studentGrade.setGrade(7, 4, Float.parseFloat(textField_58.getText()));
						studentGrade.setGrade(8, 4, Float.parseFloat(textField_59.getText()));
						studentGrade.setGrade(9, 4, Float.parseFloat(textField_60.getText()));
						studentGrade.setGrade(10, 4, Float.parseFloat(textField_61.getText()));
						studentGrade.setGrade(11, 4, Float.parseFloat(textField_62.getText()));
						studentGrade.setGrade(12, 4, Float.parseFloat(textField_80.getText()));
						studentGrade.setGrade(13, 4, Float.parseFloat(textField_81.getText()));
						studentGrade.setGrade(14, 4, Float.parseFloat(textField_82.getText()));
						studentGrade.setGrade(15, 4, Float.parseFloat(textField_83.getText()));
						studentGrade.setGrade(16, 4, Float.parseFloat(textField_97.getText()));
						studentGrade.setGrade(17, 4, Float.parseFloat(textField_98.getText()));
						studentGrade.setGrade(18, 4, Float.parseFloat(textField_99.getText()));

						studentGrade.setGrade(0, 5, (Float.parseFloat(textField_2.getText())
								+ Float.parseFloat(textField_3.getText()) + Float.parseFloat(textField_4.getText())
								+ Float.parseFloat(textField.getText()) + Float.parseFloat(textField_51.getText()))/5.0f);
						studentGrade.setGrade(1, 5, (Float.parseFloat(textField_5.getText())
								+ Float.parseFloat(textField_6.getText()) + Float.parseFloat(textField_7.getText())
								+ Float.parseFloat(textField_4.getText()) + Float.parseFloat(textField_52.getText()))/5.0f);
						studentGrade.setGrade(2, 5, (Float.parseFloat(textField_8.getText())
								+ Float.parseFloat(textField_9.getText()) + Float.parseFloat(textField_10.getText())
								+ Float.parseFloat(textField_41.getText()) + Float.parseFloat(textField_53.getText()))/5.0f);
						studentGrade.setGrade(3, 5, (Float.parseFloat(textField_11.getText())
								+ Float.parseFloat(textField_12.getText()) + Float.parseFloat(textField_13.getText())
								+ Float.parseFloat(textField_42.getText()) + Float.parseFloat(textField_54.getText()))/5.0f);
						studentGrade.setGrade(4, 5, (Float.parseFloat(textField_15.getText())
								+ Float.parseFloat(textField_16.getText()) + Float.parseFloat(textField_17.getText())
								+ Float.parseFloat(textField_43.getText()) + Float.parseFloat(textField_55.getText()))/5.0f);
						studentGrade.setGrade(5, 5,(Float.parseFloat(textField_18.getText())
								+ Float.parseFloat(textField_19.getText()) + Float.parseFloat(textField_20.getText())
								+ Float.parseFloat(textField_44.getText()) + Float.parseFloat(textField_56.getText()))/5.0f);
						studentGrade.setGrade(6, 5, (Float.parseFloat(textField_21.getText())
								+ Float.parseFloat(textField_22.getText()) + Float.parseFloat(textField_23.getText())
								+ Float.parseFloat(textField_45.getText()) + Float.parseFloat(textField_57.getText()))/5.0f);
						studentGrade.setGrade(7, 5, (Float.parseFloat(textField_24.getText())
								+ Float.parseFloat(textField_25.getText()) + Float.parseFloat(textField_26.getText())
								+ Float.parseFloat(textField_46.getText()) + Float.parseFloat(textField_58.getText()))/5.0f);
						studentGrade.setGrade(8, 5, (Float.parseFloat(textField_28.getText())
								+ Float.parseFloat(textField_29.getText()) + Float.parseFloat(textField_30.getText())
								+ Float.parseFloat(textField_47.getText()) + Float.parseFloat(textField_59.getText()))/5.0f);
						studentGrade.setGrade(9, 5, (Float.parseFloat(textField_31.getText())
								+ Float.parseFloat(textField_32.getText()) + Float.parseFloat(textField_33.getText())
								+ Float.parseFloat(textField_48.getText()) + Float.parseFloat(textField_60.getText()))/5.0f);
						studentGrade.setGrade(10, 5, (Float.parseFloat(textField_34.getText())
								+ Float.parseFloat(textField_35.getText()) + Float.parseFloat(textField_36.getText())
								+ Float.parseFloat(textField_49.getText()) + Float.parseFloat(textField_61.getText()))/5.0f);
						studentGrade.setGrade(11, 5, (Float.parseFloat(textField_37.getText())
								+ Float.parseFloat(textField_38.getText()) + Float.parseFloat(textField_39.getText())
								+ Float.parseFloat(textField_50.getText()) + Float.parseFloat(textField_62.getText()))/5.0f);
						studentGrade.setGrade(12, 5, (Float.parseFloat(textField_63.getText())
								+ Float.parseFloat(textField_64.getText()) + Float.parseFloat(textField_65.getText())
								+ Float.parseFloat(textField_76.getText()) + Float.parseFloat(textField_80.getText()))/5.0f);
						studentGrade.setGrade(13, 5, (Float.parseFloat(textField_66.getText())
								+ Float.parseFloat(textField_67.getText()) + Float.parseFloat(textField_68.getText())
								+ Float.parseFloat(textField_77.getText()) + Float.parseFloat(textField_81.getText()))/5.0f);
						studentGrade.setGrade(14, 5, (Float.parseFloat(textField_69.getText())
								+ Float.parseFloat(textField_70.getText()) + Float.parseFloat(textField_71.getText())
								+ Float.parseFloat(textField_78.getText()) + Float.parseFloat(textField_82.getText()))/5.0f);
						studentGrade.setGrade(15, 5, (Float.parseFloat(textField_72.getText())
								+ Float.parseFloat(textField_73.getText()) + Float.parseFloat(textField_74.getText())
								+ Float.parseFloat(textField_79.getText()) + Float.parseFloat(textField_83.getText()))/5.0f);
						studentGrade.setGrade(16, 5, (Float.parseFloat(textField_84.getText())
								+ Float.parseFloat(textField_85.getText()) + Float.parseFloat(textField_86.getText())
								+ Float.parseFloat(textField_94.getText()) + Float.parseFloat(textField_97.getText()))/5.0f);
						studentGrade.setGrade(17, 5, (Float.parseFloat(textField_87.getText())
								+ Float.parseFloat(textField_88.getText()) + Float.parseFloat(textField_89.getText())
								+ Float.parseFloat(textField_95.getText()) + Float.parseFloat(textField_98.getText()))/5.0f);
						studentGrade.setGrade(18, 5, (Float.parseFloat(textField_90.getText())
								+ Float.parseFloat(textField_91.getText()) + Float.parseFloat(textField_92.getText())
								+ Float.parseFloat(textField_96.getText()) + Float.parseFloat(textField_99.getText()))/5.0f);

						float moduleGrade0 = studentGrade.getGrade()[0][5] + studentGrade.getGrade()[1][5]
								+ studentGrade.getGrade()[2][5] + studentGrade.getGrade()[3][5]
								+ studentGrade.getGrade()[4][5];

						// (Float.parseFloat(textField_14.getText())
						// + Float.parseFloat(textField_27.getText()) +
						// Float.parseFloat(textField_40.getText())
						// + Float.parseFloat(textField_75.getText()) +
						// Float.parseFloat(textField_93.getText()))
						// / 5;
						studentGrade.setModuleGrade(0, moduleGrade0 / 5);
						float moduleGrade1 = studentGrade.getGrade()[5][5] + studentGrade.getGrade()[6][5]
								+ studentGrade.getGrade()[7][5] + studentGrade.getGrade()[8][5]
								+ studentGrade.getGrade()[9][5] + studentGrade.getGrade()[10][5]
								+ studentGrade.getGrade()[11][5] + studentGrade.getGrade()[12][5];

						// (Float.parseFloat(textField_100.getText())
						// + Float.parseFloat(textField_101.getText()) +
						// Float.parseFloat(textField_102.getText())
						// + Float.parseFloat(textField_103.getText()) +
						// Float.parseFloat(textField_104.getText())
						// + Float.parseFloat(textField_105.getText()) +
						// Float.parseFloat(textField_106.getText())
						// + Float.parseFloat(textField_107.getText())) / 8;
						studentGrade.setModuleGrade(1, moduleGrade1 / 8);
						float moduleGrade2 = studentGrade.getGrade()[13][5] + studentGrade.getGrade()[14][5]
								+ studentGrade.getGrade()[15][5];

						// (Float.parseFloat(textField_108.getText())
						// + Float.parseFloat(textField_109.getText()) +
						// Float.parseFloat(textField_110.getText()))
						// / 3;
						studentGrade.setModuleGrade(2, moduleGrade2 / 3);
						float moduleGrade3 = studentGrade.getGrade()[16][5] + studentGrade.getGrade()[17][5]
								+ studentGrade.getGrade()[18][5];

						// (Float.parseFloat(textField_111.getText())
						// + Float.parseFloat(textField_112.getText()) +
						// Float.parseFloat(textField_113.getText()))
						// / 3;
						studentGrade.setModuleGrade(3, moduleGrade3 / 3);
						studentGrade.setTotalGrade(
								moduleGrade0 / 5 * 0.2f + moduleGrade1 / 8 * 0.3f + moduleGrade2 / 3 * 0.2f + moduleGrade3 / 3 * 0.3f);
						Main.databaseConnection.addStudentGradeInfo(studentGrade);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "录入个人成绩失败！", "错误", JOptionPane.ERROR_MESSAGE);
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
