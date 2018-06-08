package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.main.Main;
import com.model.KeyValue;
import com.model.StudentGrade;
import com.model.StudentQualityGrade;
import com.view.LoginWindow;
import com.view.foreground.test.CombineColumnRender;
import com.view.foreground.test.CombineData;
import com.view.foreground.test.CombineTable;

public class PersonalQualityScoreInfoSearchWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String tname="c";
	private String uname="张";
	private Object[][] modeldata;
	/**
	 * Launch the application.
	 */
	public boolean searchP() throws SQLException {
		System.out.println("asdasdasda");
		System.out.println(tname);
		return Main.databaseConnection.searchDC(tname,uname);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalQualityScoreInfoSearchWindow frame = new PersonalQualityScoreInfoSearchWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PersonalQualityScoreInfoSearchWindow(String tname, String uname) throws HeadlessException {
		super();
		this.tname = tname;
		this.uname = uname;
		System.out.println(tname);
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PersonalQualityScoreInfoSearchWindow() throws SQLException {
		/**/
		
	}
	public boolean exePersonalQualityScore() throws SQLException {
		if(this.searchP()) {
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
			setBounds(100, 100, 600, 400);
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
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 29, 564, 290);
			contentPane.add(scrollPane);
			
			table = getCombineTable();
			scrollPane.setViewportView(table);
			
			JLabel lblNewLabel = new JLabel("个人能力素质评分");
			lblNewLabel.setBounds(174, 10, 104, 15);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("个人素质图表");
			btnNewButton.addActionListener(e->{
				float[][] gd = new float[3][3];
				gd[0][0] = gd[0][1]=gd[0][2]=10.0f;
				gd[2][0] = gd[2][1]=gd[2][2]=6.0f;
				gd[1][0]=Float.valueOf(String.valueOf(modeldata[0][6]))/10.0f;
				gd[1][1]=Float.valueOf(String.valueOf(modeldata[4][6]))/10.0f;
				gd[1][2]=Float.valueOf(String.valueOf(modeldata[8][6]))/10.0f;
				Dialog ch1 = new AbilityRatingChartWindow(uname,new String[] { "技术能力指数", "指挥能力指数", "管理能力指数" }, new String[] {"满分","成绩","及格线"}, gd);
				ch1.setVisible(true);
			});
			btnNewButton.setBounds(10, 329, 159, 23);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("返回");
			btnNewButton_1.addActionListener(e->{
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
			btnNewButton_1.setBounds(481, 329, 93, 23);
			contentPane.add(btnNewButton_1);
			return true;
		}else{
			return false;
		}
	}
	private  CombineTable getCombineTable() throws SQLException {
        String[][] datas = new String[12][8];
        for(int i = 0;i<datas.length;i++) {
     	   for(int j = 0;j<datas[0].length;j++) {
     		  datas[i][j]="1"; 
     	   }
     	   
        }
        for(int i=0;i<4;i++) {
     	   datas[i][0]="知识技能";
        }
        for(int i=4;i<8;i++) {
      	   datas[i][0]="指挥管理";
         }
        for(int i=8;i<12;i++) {
      	   datas[i][0]="机务素养";
         }
        datas[0][1]="实习成绩";
        datas[1][1]="专业基础";
        datas[2][1]="代教能力";
        datas[3][1]="竞赛比武";
        datas[4][1]="组织能力";
        datas[5][1]="应变能力";
        datas[6][1]="管理能力";
        datas[7][1]="协调能力";
        datas[8][1]="机务精神";
        datas[9][1]="维护作风";
        datas[10][1]="实习纪律";
        datas[11][1]="实战感知";
        modeldata = new Object[12][8];
        StudentQualityGrade model=Main.databaseConnection.queryPersonalQualityInfo("ceshi003");
        for (int j = 0;j<12;j++) {
     	   for (int i = 0;i<4;i++) {
     		   modeldata[j][i+2] = model.getGrade()[j][i];
     	   }
        }
        for(int i = 0;i<2;i++) {
        	for(int j =0;j<12;j++) {
        		modeldata[j][i] = datas[j][i];
        	}
        }
        
        for(int i=0;i<4;i++) {
        	datas[i][6]=String.valueOf(model.getModuleGrade()[0]);
        	modeldata[i][6]=model.getModuleGrade()[0];
        }
        System.out.println(model.getModuleGrade()[0]);
        System.out.println(model.getModuleGrade()[1]);
        System.out.println(model.getModuleGrade()[2]);
        for(int i=4;i<8;i++) {
        	datas[i][6]=String.valueOf(model.getModuleGrade()[1]);
        	modeldata[i][6]=model.getModuleGrade()[1];
        }
        for(int i=8;i<12;i++) {
        	datas[i][6]=String.valueOf(model.getModuleGrade()[2]);
        	modeldata[i][6]=model.getModuleGrade()[2];
        }
        for(int  i=0;i<12;i++) {
        	datas[i][7]=String.valueOf(model.getTotalGrade());
        	modeldata[i][7] = model.getTotalGrade();
        }
        
        //System.out.print(datas[4][0]);
        ArrayList<Integer> combineColumns = new ArrayList<Integer>();
        combineColumns.add(0);
        combineColumns.add(6);
        combineColumns.add(7);
        CombineData m = new CombineData(datas, combineColumns);
        DefaultTableModel tm = new DefaultTableModel(modeldata, new String[]{uname, "指标", "第一课时", "第二课时", "第三课时","分数","总分","能力素质评分"});
        CombineTable cTable = new CombineTable(m, tm);
 
        TableColumn column = cTable.getColumnModel().getColumn(0);
        column.setCellRenderer(new CombineColumnRender());
        column.setWidth(50);
        column.setMaxWidth(50);
        column.setMinWidth(50);
        cTable.setCellSelectionEnabled(true);
        return cTable;
    }
}
