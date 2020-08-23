package designpatterns.behavioral.observer;

public class CurrentScoreDisplay implements Observer {
	
	private int runs, wickets;
	private float overs;
	
	public void update(int runs, int wickets, float overs) {
		this.runs = runs;
		this.wickets = wickets;
		this.overs = overs;
		display();
	}
	
	public void display() {
		System.out.println("\nRuns = " + runs + "\nWickets = " + wickets + "\nOvers = " + overs);
	}
	

}
