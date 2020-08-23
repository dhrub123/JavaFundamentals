package designpatterns.structural.adapter;

public class Sparrow implements Bird {

	public String fly() {
		return "I am flying";
	}

	public String makeSound() {
		return "chirp chirp !!";
	}

}
