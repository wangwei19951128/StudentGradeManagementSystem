package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.main.Main;
import com.model.StudentGrade;
import com.view.foreground.test.CombineColumnRender;
import com.view.foreground.test.CombineData;
import com.view.foreground.test.CombineTable;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PersonalScoreInfoWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalScoreInfoWindow frame = new PersonalScoreInfoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PersonalScoreInfoWindow() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                                      个人成绩");
		lblNewLabel.setBounds(60, 10, 323, 42);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 414, 201);
		contentPane.add(scrollPane);
		
		table = getPersonalScoreInfoTable();
		scrollPane.setViewportView(table);
	}
	private CombineTable getPersonalScoreInfoTable() throws SQLException {
        String[][] datas = new String[20][9];
        Object[][] modeldata = new Object[20][9];
       for(int i = 0;i<datas.length;i++) {
    	   for(int j = 0;j<datas[0].length;j++) {
    		  datas[i][j]=""; 
    	   }
    	   
       }
       for(int i=0;i<5;i++) {
    	   datas[i][0]="机务素养";
       }
       for(int i=5;i<13;i++) {
    	   datas[i][0]="基本技能";
       } 
       for(int i=13;i<16;i++) {
    	   datas[i][0]="部队实习";
       }
       for(int i=16;i<19;i++) {
    	   datas[i][0]="综合演练";
       }
       datas[19][0]="课程评分";
       datas[0][1]="实战化开训";
       datas[1][1]="航空兵机务部队组织架构和机务工作流程";
       datas[2][1]="航空机务法规专项教育";
       datas[3][1]="飞行保障和典型定检工作";
       datas[4][1]="基本维护技能";
       datas[5][1]="机件的拆装和及保险";
       datas[6][1]="歼-七飞机机轮安装";
       datas[7][1]="机身后端的拆装";
       datas[8][1]="附油箱减速伞的安装与 投放";
       datas[9][1]="起落架";
       datas[10][1]="刹车压力油门操纵系统的检查与调整";
       datas[11][1]="平尾操纵系统的检查和调整";
       datas[12][1]="飞行检查";
       datas[13][1]="机务部队实习";
       datas[14][1]="部队见习收获内容交流";
       datas[15][1]="机务部队飞行保障及定检工作";
       datas[16][1]="发行机实装试车强化训练";
       datas[17][1]="空军联考";
       datas[18][1]="综合展示";
       datas[19][1]="课程评分";
       StudentGrade model=Main.databaseConnection.queryPersonalScoreInfo("ceshi003");
       for (int j = 0;j<19;j++) {
    	   for (int i = 0;i<6;i++) {
    		   modeldata[j][i+2] = model.getGrade()[j][i];
    	   }
       }
     float sum1 = (model.getGrade()[0][5]+model.getGrade()[1][5]+model.getGrade()[2][5]+model.getGrade()[3][5]+model.getGrade()[4][5])/(5.0f);
     float sum2 = (model.getGrade()[5][5]+model.getGrade()[6][5]+model.getGrade()[7][5]+model.getGrade()[8][5]+model.getGrade()[9][5]+model.getGrade()[10][5]+model.getGrade()[11][5]+model.getGrade()[12][5])/(8.0f);
     float sum3 = (model.getGrade()[13][5]+model.getGrade()[14][5]+model.getGrade()[16][5])/(3.0f);
     float sum4 = (model.getGrade()[16][5]+model.getGrade()[17][5]+model.getGrade()[18][5])/(3.0f);
        ArrayList<Integer> combineColumns = new ArrayList<Integer>();
        combineColumns.add(0);
        combineColumns.add(8);
        
       // ArrayList<Integer> combineColumns1 = new ArrayList<Integer>();
       // combineColumns1.add(0);
        //String[][] datas1 = new String[20][1];
        for(int i = 0;i<2;i++) {
        	for(int j =0;j<20;j++) {
        		modeldata[j][i] = datas[j][i];
        	}
        }
        for(int i=0;i<5;i++) {
        	datas[i][8]=String.valueOf(sum1);
        	modeldata[i][8]=sum1;
        }
        for(int i=5;i<13;i++) {
        	datas[i][8]=String.valueOf(sum2);
        	modeldata[i][8]=sum2;
        }
        for(int i=13;i<16;i++) {
        	datas[i][8]=String.valueOf(sum3);
        	modeldata[i][8]=sum3;
        }
        for(int  i=16;i<19;i++) {
        	datas[i][8]=String.valueOf(sum4);
        	modeldata[i][8] = sum4;
        }
        CombineData m = new CombineData(datas, combineColumns);
       // CombineData m1 = new CombineData(datas1, combineColumns1);
        DefaultTableModel tm = new DefaultTableModel(modeldata, new String[]{"张三","", "课前课后表现", "集中授课表现", "练习中表现", "比武竞赛表现","模拟骨干表现","分数","总分"});
        CombineTable cTable = new CombineTable(m, tm);
 
        TableColumn column = cTable.getColumnModel().getColumn(0);
        column.setCellRenderer(new CombineColumnRender());
        column.setWidth(200);
        column.setMaxWidth(200);
        column.setMinWidth(50);
        cTable.setCellSelectionEnabled(true);
        return cTable;
    }
	
}
