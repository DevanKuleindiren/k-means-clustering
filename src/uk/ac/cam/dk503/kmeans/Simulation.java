package uk.ac.cam.dk503.kmeans;

public class Simulation {
	
	public void run() {
		Visualise visual = new Visualise(500, 500);
		visual.paint(visual.getGraphics());
	}
	
	
	public static void main(String[] args) {
		Simulation sim = new Simulation();
		sim.run();
	}

}
