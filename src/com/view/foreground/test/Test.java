package com.view.foreground.test;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
 
public class Test {
 
    public static void main(String args[]) {
    	float a = 13.3f;
    	String b = String.valueOf(a);
    	System.out.println(b);
        JFrame jf = new JFrame("Cell Combine Table");
        JTable cTable = getTable1();
 
        jf.getContentPane().add(new JScrollPane(cTable));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 500);
        jf.setVisible(true);
    }
 
    private static CombineTable getTable1() {
        String[][] datas = new String[6][10];
        System.out.print(datas[4][0]);
        for (int i = 0; i < datas.length; i++) {
            String[] data = datas[i];
            for (int j = 0; j < data.length; j++) {
                data[j] = "";
            }
            data[0] = String.valueOf((int) (i / 2));
            
        }
        datas[4][0]="名字与天分";
        datas[5][0]="名字与天分";
        System.out.print(datas[4][0]);
        ArrayList<Integer> combineColumns = new ArrayList<Integer>();
        combineColumns.add(0);
        CombineData m = new CombineData(datas, combineColumns);
        DefaultTableModel tm = new DefaultTableModel(datas, new String[]{"1", "2", "3", "4", "5"});
        CombineTable cTable = new CombineTable(m, tm);
 
        TableColumn column = cTable.getColumnModel().getColumn(0);
        column.setCellRenderer(new CombineColumnRender());
        column.setWidth(50);
        column.setMaxWidth(50);
        column.setMinWidth(50);
        cTable.setCellSelectionEnabled(true);
        return cTable;
    }
 
    private static CombineTable getTable2() {
        String[][] datas = new String[10][6];
        for (int i = 0; i < datas.length; i++) {
            String[] data = datas[i];
            for (int j = 0; j < data.length; j++) {
                data[j] = "";
            }
            data[0] = String.valueOf((int) (i / 4));
            data[1] = String.valueOf((int) (i / 2));
        }
 
        CombineData m = new CombineData(datas, 0, 1);
        DefaultTableModel tm = new DefaultTableModel(datas, new String[]{"1", "2", "3", "4", "5"});
        CombineTable cTable = new CombineTable(m, tm);
 
        TableColumnModel columnModel = cTable.getColumnModel();
        for (Integer integer : m.combineColumns) {
            TableColumn column = columnModel.getColumn(integer);
            column.setCellRenderer(new CombineColumnRender());
            column.setWidth(50);
            column.setMaxWidth(50);
            column.setMinWidth(50);
        }
 
        cTable.setCellSelectionEnabled(true);
        return cTable;
    }
}