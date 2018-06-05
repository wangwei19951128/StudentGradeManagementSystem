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
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

public class CompetencyAnalysisHistogramChartWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1740852223864359735L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			float[][] gradeArray = {
					{98,98,98,98},{68,68,68,68},{78,78,78,78},{88,88,88,88},{58,58,58,58}
			};
			String[] classArray = {
					"班级1",  "班级2", "班级3", "班级4", "班级5"
			};
			String[] courseArray = {
					"知识技能","指挥管理", "机务素养", "能力素质评分"
			};
			CompetencyAnalysisHistogramChartWindow dialog = new CompetencyAnalysisHistogramChartWindow(gradeArray, classArray,
					courseArray);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CompetencyAnalysisHistogramChartWindow(float[][] grade, String[] classArray, String[] courseArray) {
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		int windowWidth = this.getWidth(); // 获得窗口宽
		int windowHeight = this.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗口居中显示
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
			// 构造DataSet
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			// 添加数据
			for(int i=0;i<classArray.length;i++) {
				for(int j=0;j<courseArray.length;j++) {
					dataset.addValue(grade[i][j], classArray[i], courseArray[j]);
				}
			}
			
			JFreeChart chart = ChartFactory.createBarChart3D("教学期班能力素质分析", "模块课程", // X轴的标签
					"分数", // Y轴的标签
					dataset, // 图标显示的数据集合
					PlotOrientation.VERTICAL, // 图像的显示形式（水平或者垂直）
					true, // 是否显示子标题
					true, // 是否生成提示的标签
					true); // 是否生成URL链接
			//处理主标题的乱码
            chart.getTitle().setFont(new Font("宋体",Font.BOLD,18));
            //处理子标题乱码
            chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
            //获取图表区域对象
            CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();
            //获取X轴的对象
            CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();
            //获取Y轴的对象
            NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();
            //处理X轴上的乱码
            categoryAxis3D.setTickLabelFont(new Font("宋体",Font.BOLD,15));
            //处理X轴外的乱码
            categoryAxis3D.setLabelFont(new Font("宋体",Font.BOLD,15));
            //处理Y轴上的乱码
            numberAxis3D.setTickLabelFont(new Font("宋体",Font.BOLD,15));
            //处理Y轴外的乱码
            numberAxis3D.setLabelFont(new Font("宋体",Font.BOLD,15));
            //处理Y轴上显示的刻度，以10作为1格
            numberAxis3D.setAutoTickUnitSelection(false);
            NumberTickUnit unit = new NumberTickUnit(10);
            numberAxis3D.setTickUnit(unit);
            //获取绘图区域对象
            BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();
            //设置柱形图的宽度
            barRenderer3D.setMaximumBarWidth(0.07);
            //在图形上显示数字
            barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            barRenderer3D.setBaseItemLabelsVisible(true);
            barRenderer3D.setBaseItemLabelFont(new Font("宋体",Font.BOLD,15));
			// 用来放置图表
			ChartPanel panel = new ChartPanel(chart);
			getContentPane().add(panel);
			
		}
	}

}
