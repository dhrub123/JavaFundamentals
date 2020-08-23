package designpatterns.copy;

public class CopyTest {

	public static void main(String[] args) {
		int[] values = {23,49,87}; 
		ShallowCopyObject shallowCopy = new ShallowCopyObject(values);
		System.out.println("Shallow Copy Test");
		System.out.println(shallowCopy);
		values[1] = 53;
		System.out.println(shallowCopy);
		System.out.println("Deep Copy Test");
		DeepCopyObject deepCopy = new DeepCopyObject(values);
		System.out.println(deepCopy);
		values[1] = 98;
		System.out.println(deepCopy);
	}

}
