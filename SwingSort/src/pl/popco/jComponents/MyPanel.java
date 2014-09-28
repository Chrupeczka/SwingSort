package pl.popco.jComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.popco.sort.EasySort;

public class MyPanel extends JPanel implements ActionListener{

	ArrayList<Integer> guziki = new ArrayList<Integer>();
	private BufferedImage btnImg;
	Dimension dimension = new Dimension(700, 400);
	Dimension minSize = new Dimension(100,30);
	ActionListener listener;
	JButton zatwierdzenie = new JButton("Sortuj!");
	JButton dodawanie = new JButton("Dodaj liczbê");
	JTextField podawanie = new JTextField("podaj liczby");
	int btnHeight = 100;
	int btnWidth = 100;
	
	
	public MyPanel(){
		super();
		
		try{
		File btnFile = new File("C:/Users/MAX/Desktop/html/obrazki/btn.png");
		btnImg = ImageIO.read(btnFile);
		
		} catch (IOException e) {
			System.err.println("B³¹d odczytu guziczka");
		}
		podawanie.setPreferredSize(minSize);
		podawanie.repaint();
		podawanie.addActionListener(this);
		dodawanie.addActionListener(this);
		zatwierdzenie.addActionListener(this);
		this.setLayout(new FlowLayout());
		this.add(podawanie);
		this.add(dodawanie);
		this.add(zatwierdzenie);
		setPreferredSize(dimension);
		setBackground(Color.WHITE);
		
		System.out.println("zmiana na probe");
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int x=0;
		for (int i : guziki){
			if (i<10) btnWidth=100;
			else if (i>10) btnWidth=125;
			else if (i>10) btnWidth=150;
			
			g2d.drawImage(btnImg, x, 150, btnWidth, btnHeight, this);
			g2d.setFont(new Font("Arial", Font.BOLD, 50));
			g2d.drawString(i+"", x+30, 220);
			x=x+btnWidth+20;
		}
		
	}
	
	public void drawPanel(Graphics2D gg){
		this.setLayout(new GridBagLayout());
		for (int i : guziki){
			
			gg.drawImage(btnImg, 0, 0, 100, 100, this);
			gg.drawString(i+"", 50, 50);
		}
	}
	
	
	
	
	private void createBtn(int nowy){
		guziki.add(nowy);
		
		repaint();
	}
	
	private void sortuj(){
		EasySort sort = new EasySort(guziki);
		guziki=sort.getList();
		repaint();
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==zatwierdzenie){
			sortuj();
		} else if ((e.getSource()==podawanie)||(e.getSource()==dodawanie)){				
				String str = podawanie.getText();
				try {
					int x=Integer.parseInt(str);
					createBtn(x);
				} catch (NumberFormatException exc) {
					System.out.println("Podaj liczbê!");
				}
			}
	}
	
}
