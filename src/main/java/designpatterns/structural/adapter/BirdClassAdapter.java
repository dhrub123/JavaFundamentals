package designpatterns.structural.adapter;

/**
 * This interface helps toyDuck make sound like a bird, in other words adapt to
 * a bird. Toy duck is client and bird is adaptee. So the adapter interface
 * should do the following things. 
 * 1)Implement client in this case toyduck
 * 2)Extend concrete of adaptee, bird in this case sparrow 
 * 3)Then change the behaviour by calling method of inherited adaptee
 * in adapting method of client --> squeak now makes sound
 */

public class BirdClassAdapter extends Sparrow implements ToyDuck{

	public String squeak() {
		return makeSound();
	}

}
