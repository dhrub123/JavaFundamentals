package designpatterns.behavioral.observer;

public class AverageScoreDisplay implements Observer {
	
	private float runRate;
	private int predictedScore;
	
	public void update(int runs, int wickets, float overs) {
		this.runRate = (float)runs/overs;
		this.predictedScore = (int)(this.runRate*50);
		display();
	}
	
	public void display() {
		System.out.println("\nRunrate = " + runRate + "\nPredicted Score = " + predictedScore);
	}
	

}
