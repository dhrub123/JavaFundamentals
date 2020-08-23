package designpatterns.behavioral.strategy;

public class Ryu extends Fighter {

	public Ryu(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
		super(kickBehaviour, jumpBehaviour);
	}
	
	public void display() {
		System.out.println("==========\nThis is Ryu");
	}

}
