package designpatterns.structural.adapter;

public class Application {
	public static void main(String[] args) {
		
		Bird sparrow = new Sparrow();
		System.out.println(sparrow.makeSound());
		
		BirdObjectAdapter objectAdapter = new BirdObjectAdapter(sparrow);
		System.out.println(objectAdapter.squeak());
		
		BirdClassAdapter classAdapter = new BirdClassAdapter();
		System.out.println(classAdapter.squeak());
		
	}
}
