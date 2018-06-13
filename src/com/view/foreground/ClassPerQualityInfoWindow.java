package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.main.Main;
import com.model.ClassPerScore;
import com.model.General;
import com.view.LoginWindow;
import com.view.foreground.test.CombineColumnRender;
import com.view.foreground.test.CombineData;
import com.view.foreground.test.CombineTable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ClassPerQualityInfoWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector<ClassPerScore> model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassPerQualityInfoWindow frame = new ClassPerQualityInfoWindow();
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
	public ClassPerQualityInfoWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "确定退出系统? ", "提示 ", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					try {
						Main.databaseConnection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "断开数据库连接失败！", "错误", JOptionPane.ERROR_MESSAGE);
					}
					System.exit(0);
				}
			}
		});
		setBounds(100, 100, 1900, 1000);
		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("期班课程成绩分析");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(723, 10, 437, 28);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 1864, 845);
		contentPane.add(scrollPane);
		
		table = getPersonalScoreInfoTable();
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(e->{
			this.dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ClassGeneralInfoWindow frame = new ClassGeneralInfoWindow();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		});
		btnNewButton.setBounds(1781, 928, 93, 23);
		contentPane.add(btnNewButton);
	}
	private CombineTable getPersonalScoreInfoTable() {
        String[][] datas = new String[20][8];
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
        try {
			model=Main.databaseConnection.queryClassPerInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object a[][] = new Object[19][model.size()+2];
		for(int i=2;i<model.size()+2;i++) {
				ClassPerScore te =model.get(i-2);
				for(int j=0;j<19;j++) {
					a[j][i] = (int)te.getGrade()[j];
				}
				/*a[i][0]=te.get;
				a[i][1] = te.getName();
				a[i][2] = te.getClass();
				a[i][3] = te.getClassscore();
				a[i][4] = te.getQuascore();*/
		}
		for(int i=0;i<2;i++) {
			for(int j =0;j<19;j++) {
				a[j][i] = datas[j][i];
			}
		}
        CombineData m = new CombineData(datas, combineColumns);
        String b[] = new String[model.size()+2];
        for(int  i=2;i<=model.size()+1;i++) {
        	b[i]= model.get(i-2).getClname();
        }
        b[0] = "";
        b[1] = "科目";
        DefaultTableModel tm = new DefaultTableModel(a, b);
        CombineTable cTable = new CombineTable(m, tm);
        cTable.setFont(new Font("宋体", Font.PLAIN, 20));
 
        TableColumn column = cTable.getColumnModel().getColumn(0);
        column.setCellRenderer(new CombineColumnRender());
        column.setWidth(200);
        column.setMaxWidth(200);
        column.setMinWidth(50);
        cTable.setCellSelectionEnabled(true);
        return cTable;
    }
}
