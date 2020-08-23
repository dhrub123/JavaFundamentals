package designpatterns.copy;

import java.util.Arrays;

public class ShallowCopyObject {
	
	private int[] values;

	public ShallowCopyObject(int[] values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "ShallowCopyObject [values=" + Arrays.toString(values) + "]";
	}
	
	
	
}
