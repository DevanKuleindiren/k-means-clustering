package uk.ac.cam.dk503.kmeans;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class Visualise extends JFrame {
	
	private static int[][] data = new int[150][2];
	
	static Random rand = new Random();
	
	public Visualise (int width, int height) {
		
		for (int i = 0; i < data.length / 3; i++) {
			double prob = Math.random();
			if (prob > 0.5) {
				data[i][0] = (int) (rand.nextInt((400 - 300) + 1) + 300);
				data[i][1] = (int) (rand.nextInt((150 - 100) + 1) + 100);
			} else {
				data[i][0] = (int) (rand.nextInt((500 - 10) + 1) + 10);
				data[i][1] = (int) (rand.nextInt((500 - 10) + 1) + 10);
			}
		}
		
		for (int i = (data.length / 3) + 1; i < (data.length / 3) * 2; i++) {
			double prob = Math.random();
			if (prob > 0.5) {
				data[i][0] = (int) (rand.nextInt((250 - 200) + 1) + 200);
				data[i][1] = (int) (rand.nextInt((350 - 300) + 1) + 300);
			} else {
				data[i][0] = (int) (rand.nextInt((500 - 10) + 1) + 10);
				data[i][1] = (int) (rand.nextInt((500 - 10) + 1) + 10);
			}
		}
		
		for (int i = ((data.length / 3) * 2) + 1; i < data.length; i++) {
			double prob = Math.random();
			if (prob > 0.5) {
				data[i][0] = (int) (rand.nextInt((150 - 100) + 1) + 100);
				data[i][1] = (int) (rand.nextInt((200 - 150) + 1) + 150);
			} else {
				data[i][0] = (int) (rand.nextInt((500 - 10) + 1) + 10);
				data[i][1] = (int) (rand.nextInt((500 - 10) + 1) + 10);
			}
		}
		
		setTitle("kMeans Demo");
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint (Graphics g) {
		
		for (int i = 0; i < data.length; i++) {
			g.setColor(Color.decode("#4DB870"));
			g.fillOval(data[i][0], data[i][1], 10, 10);
		}		
		
		
		kMeans mkMeans = new kMeans(data, 3);
		int[][] centers = mkMeans.computerCenters();
		for (int i = 0; i < centers.length; i++) {
			g.setColor(Color.BLACK);
			g.fillOval(centers[i][0], centers[i][1], 10, 10);
		}
	}
}