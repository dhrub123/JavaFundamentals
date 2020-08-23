package designpatterns.copy;

import java.util.Arrays;

public class DeepCopyObject {
	
	private int[] values;

	public DeepCopyObject(int[] data) {
		values = new int[data.length];
		for(int i=0 ; i<data.length; i++)
		this.values[i] = data[i];
	}

	@Override
	public String toString() {
		return "DeepCopyObject [values=" + Arrays.toString(values) + "]";
	}
	
}