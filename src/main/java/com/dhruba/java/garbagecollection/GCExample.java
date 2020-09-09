package com.dhruba.java.garbagecollection;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 
 * The output of this program gives us memory locations. 
 * If we plot them a s a line graph in excel, we will get a sawtooth.
 * which shows that memory gets allocated and once full, it starts 
 * getting allocated from a lower level again.
 *  
 *   
 *         -	    -		 -
 *       - |	  - |	   - |
 *     -   |    -   |    -	 |	  -
 *   -     |  -		|  -	 |	-
 * -       |-		|-		 |-
 *
 */
public class GCExample {
	
	private static Unsafe unsafe;
	static {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe)field.get(null);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	public static void main(String[] args) throws Exception{
		for(int i = 0; i<32000 ;i++) {
			Object mine = new GCMe();
			long address = addressOf(mine);
			System.out.println(address);
		}
	}
	
	public static long addressOf(Object o) throws Exception{
		Object[] array = new Object[] {o};
		
		long baseOffset = unsafe.arrayBaseOffset(Object[].class);
		int addressSize = unsafe.addressSize();
		long objectAddress;
		switch(addressSize) {
			case 4:
				objectAddress = unsafe.getInt(array,baseOffset);
				break;
			case 8:
				objectAddress = unsafe.getLong(array,baseOffset);
				break;
			default:
				throw new Error("unsupported address size:" + addressSize);
		}
		return (objectAddress);
	}

}
