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

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

import com.model.SpiderWebPlotExpand;

public class AbilityRatingChartWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1808965751625289071L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			float[][] grade = { { 5, 6, 4 }, { 3, 3, 4 }, { 4, 5, 2 } };
			String[] group = { "群组1", "群组2" };
			String[] dimensionName = { "技术能力指数", "指挥能力指数", "管理能力指数" };
			AbilityRatingChartWindow dialog = new AbilityRatingChartWindow("张三", dimensionName, group, grade);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AbilityRatingChartWindow(String name, String[] dimensionName, String[] group, float[][] grade) {
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
				okButton.addActionListener(e -> {
					this.dispose();
				});
				buttonPane.add(okButton);
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
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < group.length; i++) {
			for (int j = 0; j < dimensionName.length; j++) {
				dataset.addValue(grade[i][j], group[i], dimensionName[j]);
			}
		}

		SpiderWebPlotExpand plot = new SpiderWebPlotExpand(dataset);
		JFreeChart chart = new JFreeChart(name + "--个人能力素质评分", TextTitle.DEFAULT_FONT, plot, false);
		// 处理主标题的乱码
		chart.getTitle().setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		//获取图表区域对象
		SpiderWebPlot categoryPlot = (SpiderWebPlot)chart.getPlot();
        //处理图像上的乱码
        categoryPlot.setLabelFont(new Font("微软雅黑",Font.PLAIN,15));
		 
		LegendTitle legendtitle = new LegendTitle(plot);
		legendtitle.setPosition(RectangleEdge.BOTTOM);
		legendtitle.setItemFont(new Font("微软雅黑",Font.PLAIN,15));
		chart.addSubtitle(legendtitle);
		ChartPanel chartpanel = new ChartPanel(chart);
		getContentPane().add(chartpanel);
	}

}
