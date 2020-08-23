package designpatterns.behavioral.strategy;

public class Ken extends Fighter {

	public Ken(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
		super(kickBehaviour, jumpBehaviour);
	}
	
	public void display() {
		System.out.println("==========\nThis is Ken");
	}

}
