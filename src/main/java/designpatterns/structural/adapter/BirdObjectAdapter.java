package designpatterns.structural.adapter;

/**
 * This interface helps toyDuck make sound like a bird, in other words adapt to
 * a bird. Toy duck is client and bird is adaptee. So the adapter interface
 * should do the following things. 
 * 1)Implement client in this case toyduck
 * 2)Pass an object of adaptee, bird in constructor. 
 * 3)Then change the behaviour
 * in adapting method of client --> squeak now makes sound
 */

public class BirdObjectAdapter implements ToyDuck {

	Bird bird;

	public BirdObjectAdapter(Bird bird) {
		this.bird = bird;
	}

	public String squeak() {
		return bird.makeSound();
	}

}
