package com.view.foreground;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class CompetencyAnalysisPieChartWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -87751610859867182L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			int[] aaa= {20,15,30,60,3};
			CompetencyAnalysisPieChartWindow dialog = new CompetencyAnalysisPieChartWindow(aaa,"飞行八班");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CompetencyAnalysisPieChartWindow(int[] number,String className) {
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示
		
		DefaultPieDataset DataSet = new DefaultPieDataset();
		DataSet.setValue("优秀", number[0]);
		DataSet.setValue("良好", number[1]);
		DataSet.setValue("中等", number[2]);
		DataSet.setValue("及格", number[3]);
		DataSet.setValue("不及格", number[4]);

		// 创建饼图
		JFreeChart chart = ChartFactory.createPieChart3D("教学期班--"+className+"--能力素质分析", DataSet, true, true, false);
		//处理主标题的乱码
		chart.getTitle().setFont(new Font("宋体",Font.BOLD,18));
        //处理子标题乱码
		chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
        //获取图表区域对象
        PiePlot3D categoryPlot = (PiePlot3D)chart.getPlot();
        //处理图像上的乱码
        categoryPlot.setLabelFont(new Font("宋体",Font.BOLD,15));
        //设置图形的生成格式为（上海 2 （10%））
        String format = "{0} {1} ({2})";
        categoryPlot.setLabelGenerator(new StandardPieSectionLabelGenerator(format));
		// 用来放置图表
		ChartPanel panel = new ChartPanel(chart);
		getContentPane().add(panel);
	}

}
