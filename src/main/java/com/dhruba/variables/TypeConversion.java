package com.dhruba.variables;

public class TypeConversion {
	public static void main(String[] args) {
		
		float floatVal = 1.0f;
		double doubleVal = 4.0d;
		byte byteVal = 7;
		short shortVal = 7;
		long longVal = 5;
		
		short result = byteVal;//valid since widening
		//result = longVal;//invalid - cast to narrow
		result = (short)longVal;//valid since casting done
		
		// short result2 = byteVal - longVal; // subtracting a long from a byte results
		// in a long but that cannot be stored in a short without casting
		short result2 = (short)(byteVal - longVal);// now it will work since result is cast
		
		//long result3 = longVal - floatVal;// not possible since fraction will be lost
		float result3 = longVal - floatVal;
		
		// float result4 = longVal - doubleVal;// not possible since double cannot be
		// stored in float without casting
		double result4 = longVal - doubleVal;
		
		long result5 = (long) (shortVal - longVal + floatVal + doubleVal); // here we are casting a double to a long
		double result6 = shortVal - longVal + floatVal + doubleVal;
		
		System.out.println(result + " " + result2 + " " + result3 + " " + result4 + " " + result5 + " " + result6);
	}
}
