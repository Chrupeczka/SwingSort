package pl.popco.jComponents;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	
	public MyFrame(){
		super("Sort");
		
		JPanel panel = new MyPanel();
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocation(500,500);	
	}
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				new MyFrame();
			}
		});
	}	
	
}
