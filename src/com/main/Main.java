package com.main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.controller.DatabaseConnect;
import com.model.Person;
import com.view.MainWindow;

public class Main {

	public static DatabaseConnect databaseConnection = new DatabaseConnect();
	public static Person person=new Person();

	public static void main(String[] args) {
		if(UIManager.getLookAndFeel().isSupportedLookAndFeel()){
            final String platform = UIManager.getSystemLookAndFeelClassName();
            if (!UIManager.getLookAndFeel().getName().equals(platform)) {
                try {
                    UIManager.setLookAndFeel(platform);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
