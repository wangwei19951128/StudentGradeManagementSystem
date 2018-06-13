package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.main.Main;
import com.model.StudentGrade;
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

public class PersonalScoreInfoWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private String tname="ceshi";
	private String name = "ceshi";

	public boolean searchP() throws SQLException {
		
		return Main.databaseConnection.searchDC(tname,name);
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalScoreInfoWindow frame = new PersonalScoreInfoWindow("ceshi0123","456");
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
	
	public boolean exeTFrame() throws SQLException {
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
			
			JLabel lblNewLabel = new JLabel("个人成绩");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 21));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(509, 10, 865, 54);
			contentPane.add(lblNewLabel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 74, 1874, 844);
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
			btnNewButton.setBounds(1669, 928, 215, 23);
			contentPane.add(btnNewButton);
			return true;
		}else {
			return false;
		}		
	}
	public PersonalScoreInfoWindow() throws HeadlessException, SQLException {
		super();
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
		
		JLabel lblNewLabel = new JLabel("个人成绩");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(509, 10, 865, 54);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 1874, 844);
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
		btnNewButton.setBounds(1669, 928, 215, 23);
		contentPane.add(btnNewButton);
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
       datas[19][1]="";
       StudentGrade model=Main.databaseConnection.queryPersonalScoreInfo(tname);
       for (int j = 0;j<19;j++) {
    	   for (int i = 0;i<6;i++) {
    		   modeldata[j][i+2] = (int)model.getGrade()[j][i];
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
        	modeldata[i][8]=(int)sum1;
        }
        for(int i=5;i<13;i++) {
        	datas[i][8]=String.valueOf(sum2);
        	modeldata[i][8]=(int)sum2;
        }
        for(int i=13;i<16;i++) {
        	datas[i][8]=String.valueOf(sum3);
        	modeldata[i][8]=(int)sum3;
        }
        for(int  i=16;i<19;i++) {
        	datas[i][8]=String.valueOf(sum4);
        	modeldata[i][8] = (int)sum4;
        }
        modeldata[19][8]= (int)((sum1+sum2+sum3+sum4)/4.0f);
        CombineData m = new CombineData(datas, combineColumns);
       // CombineData m1 = new CombineData(datas1, combineColumns1);
        DefaultTableModel tm = new DefaultTableModel(modeldata, new String[]{tname,"", "课前课后表现", "集中授课表现", "练习中表现", "比武竞赛表现","模拟骨干表现","分数","总分"});
        CombineTable cTable = new CombineTable(m, tm);
        cTable.setFont(new Font("宋体", Font.PLAIN, 20));
 
        TableColumn column = cTable.getColumnModel().getColumn(0);
        cTable.getColumnModel().getColumn(1).setMinWidth(200);
        cTable.getColumnModel().getColumn(2).setPreferredWidth(93);
        cTable.getColumnModel().getColumn(2).setMaxWidth(93);
        cTable.getColumnModel().getColumn(3).setPreferredWidth(85);
        cTable.getColumnModel().getColumn(3).setMaxWidth(85);
        cTable.getColumnModel().getColumn(5).setPreferredWidth(88);
        cTable.getColumnModel().getColumn(6).setPreferredWidth(91);
        column.setCellRenderer(new CombineColumnRender());
        column.setWidth(200);
        column.setMaxWidth(200);
        column.setMinWidth(50);
        cTable.setCellSelectionEnabled(true);
        return cTable;
		
	}
	public PersonalScoreInfoWindow(String tname1,String name1) throws SQLException {
		this.tname = tname1;
		this.name = name1;
    }
	
}
