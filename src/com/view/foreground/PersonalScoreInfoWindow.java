package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
	 */
	public PersonalScoreInfoWindow() {
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
	private CombineTable getPersonalScoreInfoTable() {
        String[][] datas = new String[20][9];
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
        System.out.print(datas[4][0]);
        ArrayList<Integer> combineColumns = new ArrayList<Integer>();
        combineColumns.add(0);
        CombineData m = new CombineData(datas, combineColumns);
        DefaultTableModel tm = new DefaultTableModel(datas, new String[]{"张三","", "课前课后表现", "集中授课表现", "练习中表现", "比武竞赛表现","模拟骨干表现","分数","总分"});
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
