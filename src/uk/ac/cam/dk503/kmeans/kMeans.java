package uk.ac.cam.dk503.kmeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class kMeans {

	private int[][] data;
	private int k;
	Random rand = new Random();
	List<List<Coordinate<Integer, Integer>>> clusterList = new ArrayList<List<Coordinate<Integer, Integer>>>();
	
	public kMeans (int[][] data, int k) {
		this.data = data;
		this.k = k;
	}
	
	public int[][] computerCenters () {
		int[][] centers = new int[k][2];
		
		for (int i = 0; i < k; i++) {
			centers[i][0] = rand.nextInt((500 - 20) + 1) + 0;
			centers[i][1] = rand.nextInt((500 - 20) + 1) + 0;
			clusterList.add(new ArrayList<Coordinate<Integer, Integer>>());
		}
		
		for (int counter = 0; counter < 100; counter++) {
			
			for (int i = 0; i < data.length; i++) {
				double min = Math.sqrt(Math.pow(centers[0][0] - data[i][0], 2)
						+ Math.pow(centers[0][1] - data[i][1], 2));
				int indexOfMin = 0;
				
				for (int j = 1; j < k; j++) {
					double temp = Math.sqrt(Math.pow(centers[j][0] - data[i][0], 2)
							+ Math.pow(centers[j][1] - data[i][1], 2));
					if (temp < min) {
						indexOfMin = j;
						min = temp;
					}
				}
				clusterList.get(indexOfMin).add(new Coordinate<Integer, Integer>(data[i][0], data[i][1]));
			}
			
			
			Coordinate<Integer, Integer> tempSumC = new Coordinate<Integer, Integer>(centers[0][0], centers[0][1]);
			for (int i = 0; i < k; i++) {
				if (clusterList.get(i).size() != 0) {
					tempSumC.setX(0);
					tempSumC.setY(0);
					
					//MEAN
//					for (Coordinate<Integer, Integer> c : clusterList.get(i)) {
//						tempSumC.setX(tempSumC.getX() + c.getX());
//						tempSumC.setY(tempSumC.getY() + c.getY());
//					}
//					int tempX = (int) (tempSumC.getX() / clusterList.get(i).size());
//					int tempY = (int) (tempSumC.getY() / clusterList.get(i).size());
					
					//MEDIAN
					List<Integer> tempXList = new ArrayList<Integer>();
					List<Integer> tempYList = new ArrayList<Integer>();
					
					for (Coordinate<Integer, Integer> c : clusterList.get(i)) {
						tempXList.add(c.getX());
						tempYList.add(c.getY());
					}
					Collections.sort(tempXList);
					Collections.sort(tempYList);
					
					centers[i][0] = tempXList.get(tempXList.size() / 2);
					centers[i][1] = tempYList.get(tempYList.size() / 2);
				}
			}
		}
		
		return centers;
	}
}
