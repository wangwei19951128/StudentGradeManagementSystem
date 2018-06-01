package com.main;

import java.awt.EventQueue;

import com.controller.DatabaseConnect;
import com.model.Person;
import com.view.MainWindow;

public class Main {

	public static DatabaseConnect databaseConnection = new DatabaseConnect();
	public static Person person=new Person();

	public static void main(String[] args) {
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
