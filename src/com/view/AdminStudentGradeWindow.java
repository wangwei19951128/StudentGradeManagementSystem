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
	private JLabel label_4;
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
	private JTextField textField_75;
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
	private JTextField textField_93;
	private JTextField textField_94;
	private JTextField textField_95;
	private JTextField textField_96;
	private JTextField textField_97;
	private JTextField textField_98;
	private JTextField textField_99;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;


	/**
	 * Create the dialog.
	 */
	public AdminStudentGradeWindow() {
		setBounds(100, 100, 1037, 794);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1021, 723);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("录入个人成绩");
			label.setFont(new Font("微软雅黑", Font.BOLD, 50));
			label.setBounds(353, 58, 314, 78);
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
		
		JLabel label_1 = new JLabel("课程");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(146, 169, 215, 15);
		contentPanel.add(label_1);
		{
			JLabel label_2 = new JLabel("课前课后表现");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(366, 169, 116, 15);
			contentPanel.add(label_2);
		}
		{
			JLabel label_2 = new JLabel("集中授课表现");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(472, 169, 124, 15);
			contentPanel.add(label_2);
		}
		{
			JLabel label_2 = new JLabel("联系中表现");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setBounds(575, 169, 136, 15);
			contentPanel.add(label_2);
		}
		
		JLabel label_2 = new JLabel("分数");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(900, 169, 109, 15);
		contentPanel.add(label_2);
		{
			JLabel label_3 = new JLabel("机务素养");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(31, 245, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("实战化开训");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 200, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("航空兵机务部队组织架构和机务工作流程");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(126, 225, 255, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("航空机务法规专项教育");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 250, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel lblNewLabel = new JLabel("飞行保障和典型定检工作");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(146, 275, 215, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel label_3 = new JLabel("基本维护技能");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 300, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("机件的拆装及保险");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 341, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("歼7飞机机轮安装");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 366, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("机身后段的拆装");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 391, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("副油箱减速伞的安装与投放");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 416, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("联合收放检查");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 441, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("刹车压力油门操纵系统检查与调整");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 466, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("平尾操纵系统检查与调整");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(146, 491, 215, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("基本技能");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(31, 441, 54, 15);
			contentPanel.add(label_3);
		}
		{
			JLabel label_3 = new JLabel("部队实习");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(31, 579, 54, 15);
			contentPanel.add(label_3);
		}
		
		textField_2 = new JTextField();
		textField_2.setBounds(391, 200, 66, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(501, 200, 66, 21);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(610, 200, 66, 21);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(391, 225, 66, 21);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(501, 225, 66, 21);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(610, 225, 66, 21);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(391, 250, 66, 21);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(501, 250, 66, 21);
		contentPanel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(610, 250, 66, 21);
		contentPanel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(391, 275, 66, 21);
		contentPanel.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(501, 275, 66, 21);
		contentPanel.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(610, 275, 66, 21);
		contentPanel.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(921, 200, 66, 125);
		contentPanel.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(391, 300, 66, 21);
		contentPanel.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(501, 300, 66, 21);
		contentPanel.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(610, 300, 66, 21);
		contentPanel.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(391, 338, 66, 21);
		contentPanel.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(501, 338, 66, 21);
		contentPanel.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBounds(610, 338, 66, 21);
		contentPanel.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setBounds(391, 363, 66, 21);
		contentPanel.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(501, 363, 66, 21);
		contentPanel.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(610, 363, 66, 21);
		contentPanel.add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setBounds(391, 388, 66, 21);
		contentPanel.add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setBounds(501, 388, 66, 21);
		contentPanel.add(textField_25);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setBounds(610, 388, 66, 21);
		contentPanel.add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setBounds(921, 337, 66, 200);
		contentPanel.add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setBounds(391, 413, 66, 21);
		contentPanel.add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setBounds(501, 413, 66, 21);
		contentPanel.add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setBounds(610, 413, 66, 21);
		contentPanel.add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setBounds(391, 438, 66, 21);
		contentPanel.add(textField_31);
		textField_31.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.setBounds(501, 438, 66, 21);
		contentPanel.add(textField_32);
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setBounds(610, 438, 66, 21);
		contentPanel.add(textField_33);
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setBounds(391, 463, 66, 21);
		contentPanel.add(textField_34);
		textField_34.setColumns(10);
		
		textField_35 = new JTextField();
		textField_35.setBounds(501, 463, 66, 21);
		contentPanel.add(textField_35);
		textField_35.setColumns(10);
		
		textField_36 = new JTextField();
		textField_36.setBounds(610, 463, 66, 21);
		contentPanel.add(textField_36);
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setBounds(391, 488, 66, 21);
		contentPanel.add(textField_37);
		textField_37.setColumns(10);
		
		textField_38 = new JTextField();
		textField_38.setBounds(501, 488, 66, 21);
		contentPanel.add(textField_38);
		textField_38.setColumns(10);
		
		textField_39 = new JTextField();
		textField_39.setBounds(610, 488, 66, 21);
		contentPanel.add(textField_39);
		textField_39.setColumns(10);
		
		label_4 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label_4.setBounds(0, 185, 1021, 15);
		contentPanel.add(label_4);
		
		label_7 = new JLabel("比武竞赛表现");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(675, 169, 136, 15);
		contentPanel.add(label_7);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(710, 200, 66, 21);
		contentPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(710, 225, 66, 21);
		contentPanel.add(textField_1);
		
		textField_41 = new JTextField();
		textField_41.setColumns(10);
		textField_41.setBounds(710, 250, 66, 21);
		contentPanel.add(textField_41);
		
		textField_42 = new JTextField();
		textField_42.setColumns(10);
		textField_42.setBounds(710, 275, 66, 21);
		contentPanel.add(textField_42);
		
		textField_43 = new JTextField();
		textField_43.setColumns(10);
		textField_43.setBounds(710, 300, 66, 21);
		contentPanel.add(textField_43);
		
		textField_44 = new JTextField();
		textField_44.setColumns(10);
		textField_44.setBounds(710, 338, 66, 21);
		contentPanel.add(textField_44);
		
		textField_45 = new JTextField();
		textField_45.setColumns(10);
		textField_45.setBounds(710, 363, 66, 21);
		contentPanel.add(textField_45);
		
		textField_46 = new JTextField();
		textField_46.setColumns(10);
		textField_46.setBounds(710, 388, 66, 21);
		contentPanel.add(textField_46);
		
		textField_47 = new JTextField();
		textField_47.setColumns(10);
		textField_47.setBounds(710, 413, 66, 21);
		contentPanel.add(textField_47);
		
		textField_48 = new JTextField();
		textField_48.setColumns(10);
		textField_48.setBounds(710, 438, 66, 21);
		contentPanel.add(textField_48);
		
		textField_49 = new JTextField();
		textField_49.setColumns(10);
		textField_49.setBounds(710, 463, 66, 21);
		contentPanel.add(textField_49);
		
		textField_50 = new JTextField();
		textField_50.setColumns(10);
		textField_50.setBounds(710, 488, 66, 21);
		contentPanel.add(textField_50);
		
		textField_51 = new JTextField();
		textField_51.setColumns(10);
		textField_51.setBounds(805, 200, 66, 21);
		contentPanel.add(textField_51);
		
		textField_52 = new JTextField();
		textField_52.setColumns(10);
		textField_52.setBounds(805, 225, 66, 21);
		contentPanel.add(textField_52);
		
		textField_53 = new JTextField();
		textField_53.setColumns(10);
		textField_53.setBounds(805, 250, 66, 21);
		contentPanel.add(textField_53);
		
		textField_54 = new JTextField();
		textField_54.setColumns(10);
		textField_54.setBounds(805, 275, 66, 21);
		contentPanel.add(textField_54);
		
		textField_55 = new JTextField();
		textField_55.setColumns(10);
		textField_55.setBounds(805, 300, 66, 21);
		contentPanel.add(textField_55);
		
		textField_56 = new JTextField();
		textField_56.setColumns(10);
		textField_56.setBounds(805, 338, 66, 21);
		contentPanel.add(textField_56);
		
		textField_57 = new JTextField();
		textField_57.setColumns(10);
		textField_57.setBounds(805, 363, 66, 21);
		contentPanel.add(textField_57);
		
		textField_58 = new JTextField();
		textField_58.setColumns(10);
		textField_58.setBounds(805, 388, 66, 21);
		contentPanel.add(textField_58);
		
		textField_59 = new JTextField();
		textField_59.setColumns(10);
		textField_59.setBounds(805, 413, 66, 21);
		contentPanel.add(textField_59);
		
		textField_60 = new JTextField();
		textField_60.setColumns(10);
		textField_60.setBounds(805, 438, 66, 21);
		contentPanel.add(textField_60);
		
		textField_61 = new JTextField();
		textField_61.setColumns(10);
		textField_61.setBounds(805, 463, 66, 21);
		contentPanel.add(textField_61);
		
		textField_62 = new JTextField();
		textField_62.setColumns(10);
		textField_62.setBounds(805, 488, 66, 21);
		contentPanel.add(textField_62);
		
		label_8 = new JLabel("模拟骨干表现");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(770, 169, 136, 15);
		contentPanel.add(label_8);
		
		label_9 = new JLabel("飞行检查");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(146, 516, 215, 15);
		contentPanel.add(label_9);
		
		label_10 = new JLabel("机务部队实习");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(146, 554, 215, 15);
		contentPanel.add(label_10);
		
		label_11 = new JLabel("部队见习收获内部交流");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(146, 579, 215, 15);
		contentPanel.add(label_11);
		
		label_12 = new JLabel("机务部队飞行保障及定检工作");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(146, 604, 215, 15);
		contentPanel.add(label_12);
		
		label_13 = new JLabel("综合演练");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(31, 670, 54, 15);
		contentPanel.add(label_13);
		
		textField_63 = new JTextField();
		textField_63.setColumns(10);
		textField_63.setBounds(391, 513, 66, 21);
		contentPanel.add(textField_63);
		
		textField_64 = new JTextField();
		textField_64.setColumns(10);
		textField_64.setBounds(501, 513, 66, 21);
		contentPanel.add(textField_64);
		
		textField_65 = new JTextField();
		textField_65.setColumns(10);
		textField_65.setBounds(610, 513, 66, 21);
		contentPanel.add(textField_65);
		
		textField_66 = new JTextField();
		textField_66.setColumns(10);
		textField_66.setBounds(391, 551, 66, 21);
		contentPanel.add(textField_66);
		
		textField_67 = new JTextField();
		textField_67.setColumns(10);
		textField_67.setBounds(501, 551, 66, 21);
		contentPanel.add(textField_67);
		
		textField_68 = new JTextField();
		textField_68.setColumns(10);
		textField_68.setBounds(610, 551, 66, 21);
		contentPanel.add(textField_68);
		
		textField_69 = new JTextField();
		textField_69.setColumns(10);
		textField_69.setBounds(391, 576, 66, 21);
		contentPanel.add(textField_69);
		
		textField_70 = new JTextField();
		textField_70.setColumns(10);
		textField_70.setBounds(501, 576, 66, 21);
		contentPanel.add(textField_70);
		
		textField_71 = new JTextField();
		textField_71.setColumns(10);
		textField_71.setBounds(610, 576, 66, 21);
		contentPanel.add(textField_71);
		
		textField_72 = new JTextField();
		textField_72.setColumns(10);
		textField_72.setBounds(391, 601, 66, 21);
		contentPanel.add(textField_72);
		
		textField_73 = new JTextField();
		textField_73.setColumns(10);
		textField_73.setBounds(501, 601, 66, 21);
		contentPanel.add(textField_73);
		
		textField_74 = new JTextField();
		textField_74.setColumns(10);
		textField_74.setBounds(610, 601, 66, 21);
		contentPanel.add(textField_74);
		
		textField_75 = new JTextField();
		textField_75.setColumns(10);
		textField_75.setBounds(921, 550, 66, 75);
		contentPanel.add(textField_75);
		
		textField_76 = new JTextField();
		textField_76.setColumns(10);
		textField_76.setBounds(710, 513, 66, 21);
		contentPanel.add(textField_76);
		
		textField_77 = new JTextField();
		textField_77.setColumns(10);
		textField_77.setBounds(710, 551, 66, 21);
		contentPanel.add(textField_77);
		
		textField_78 = new JTextField();
		textField_78.setColumns(10);
		textField_78.setBounds(710, 576, 66, 21);
		contentPanel.add(textField_78);
		
		textField_79 = new JTextField();
		textField_79.setColumns(10);
		textField_79.setBounds(710, 601, 66, 21);
		contentPanel.add(textField_79);
		
		textField_80 = new JTextField();
		textField_80.setColumns(10);
		textField_80.setBounds(805, 513, 66, 21);
		contentPanel.add(textField_80);
		
		textField_81 = new JTextField();
		textField_81.setColumns(10);
		textField_81.setBounds(805, 551, 66, 21);
		contentPanel.add(textField_81);
		
		textField_82 = new JTextField();
		textField_82.setColumns(10);
		textField_82.setBounds(805, 576, 66, 21);
		contentPanel.add(textField_82);
		
		textField_83 = new JTextField();
		textField_83.setColumns(10);
		textField_83.setBounds(805, 601, 66, 21);
		contentPanel.add(textField_83);
		
		label_5 = new JLabel("机务部队实习");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(146, 645, 215, 15);
		contentPanel.add(label_5);
		
		label_6 = new JLabel("部队见习收获内部交流");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(146, 670, 215, 15);
		contentPanel.add(label_6);
		
		label_14 = new JLabel("机务部队飞行保障及定检工作");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(146, 695, 215, 15);
		contentPanel.add(label_14);
		
		textField_84 = new JTextField();
		textField_84.setColumns(10);
		textField_84.setBounds(391, 642, 66, 21);
		contentPanel.add(textField_84);
		
		textField_85 = new JTextField();
		textField_85.setColumns(10);
		textField_85.setBounds(501, 642, 66, 21);
		contentPanel.add(textField_85);
		
		textField_86 = new JTextField();
		textField_86.setColumns(10);
		textField_86.setBounds(610, 642, 66, 21);
		contentPanel.add(textField_86);
		
		textField_87 = new JTextField();
		textField_87.setColumns(10);
		textField_87.setBounds(391, 667, 66, 21);
		contentPanel.add(textField_87);
		
		textField_88 = new JTextField();
		textField_88.setColumns(10);
		textField_88.setBounds(501, 667, 66, 21);
		contentPanel.add(textField_88);
		
		textField_89 = new JTextField();
		textField_89.setColumns(10);
		textField_89.setBounds(610, 667, 66, 21);
		contentPanel.add(textField_89);
		
		textField_90 = new JTextField();
		textField_90.setColumns(10);
		textField_90.setBounds(391, 692, 66, 21);
		contentPanel.add(textField_90);
		
		textField_91 = new JTextField();
		textField_91.setColumns(10);
		textField_91.setBounds(501, 692, 66, 21);
		contentPanel.add(textField_91);
		
		textField_92 = new JTextField();
		textField_92.setColumns(10);
		textField_92.setBounds(610, 692, 66, 21);
		contentPanel.add(textField_92);
		
		textField_93 = new JTextField();
		textField_93.setColumns(10);
		textField_93.setBounds(921, 640, 66, 75);
		contentPanel.add(textField_93);
		
		textField_94 = new JTextField();
		textField_94.setColumns(10);
		textField_94.setBounds(710, 642, 66, 21);
		contentPanel.add(textField_94);
		
		textField_95 = new JTextField();
		textField_95.setColumns(10);
		textField_95.setBounds(710, 667, 66, 21);
		contentPanel.add(textField_95);
		
		textField_96 = new JTextField();
		textField_96.setColumns(10);
		textField_96.setBounds(710, 692, 66, 21);
		contentPanel.add(textField_96);
		
		textField_97 = new JTextField();
		textField_97.setColumns(10);
		textField_97.setBounds(805, 642, 66, 21);
		contentPanel.add(textField_97);
		
		textField_98 = new JTextField();
		textField_98.setColumns(10);
		textField_98.setBounds(805, 667, 66, 21);
		contentPanel.add(textField_98);
		
		textField_99 = new JTextField();
		textField_99.setColumns(10);
		textField_99.setBounds(805, 692, 66, 21);
		contentPanel.add(textField_99);
		
		label_15 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label_15.setBounds(0, 325, 1021, 15);
		contentPanel.add(label_15);
		
		label_16 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label_16.setBounds(0, 535, 1021, 15);
		contentPanel.add(label_16);
		
		label_17 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label_17.setBounds(0, 625, 1021, 15);
		contentPanel.add(label_17);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 722, 1021, 33);
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
