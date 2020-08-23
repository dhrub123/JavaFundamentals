package designpatterns.behavioral.strategy;

public class Chunli extends Fighter {

	public Chunli(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
		super(kickBehaviour, jumpBehaviour);
	}
	
	public void display() {
		System.out.println("==========\nThis is Chunli");
	}

}
