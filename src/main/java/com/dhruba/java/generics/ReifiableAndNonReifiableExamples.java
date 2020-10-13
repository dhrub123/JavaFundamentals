package com.dhruba.java.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReifiableAndNonReifiableExamples {

	public static class StringList extends ArrayList<String> {

	}

	public static void main(String[] args) {

		// Non-Reifiable

		List<String> strings = new ArrayList<>();
		List<Integer> integers = new ArrayList<>();

		System.out.println(strings.getClass()); // class java.util.ArrayList
		System.out.println(integers.getClass()); // class java.util.ArrayList
		System.out.println(strings.getClass() == integers.getClass()); // true

		List<? extends Number> numbers = new ArrayList<>();
		System.out.println(numbers.getClass()); // class java.util.ArrayList
		System.out.println(numbers.getClass() == integers.getClass()); // true

		// Reifiable
		System.out.println(int.class); // int
		System.out.println(String.class); // class java.lang.String

		List<?> wildcards = new ArrayList<>();
		System.out.println(wildcards.getClass()); // class java.util.ArrayList

		List raw = new ArrayList<>();
		System.out.println(raw.getClass()); // class java.util.ArrayList
		System.out.println(wildcards.getClass() == raw.getClass()); // true
		System.out.println(int[].class); // class [I
		System.out.println(List[].class); // class [Ljava.util.List;

		List<String> listOfStrings = new ArrayList<>();
		Class<?> arrayList = strings.getClass();
		System.out.println(arrayList); // class java.util.ArrayList
		final TypeVariable<? extends Class<?>>[] typeParameters = arrayList.getTypeParameters();
		System.out.println(Arrays.toString(typeParameters)); // [E]
		System.out.println(arrayList.toGenericString()); // public class java.util.ArrayList<E>
		System.out.println(arrayList.toString()); // class java.util.ArrayList

		final ParameterizedType arrayListOfString = (ParameterizedType) StringList.class.getGenericSuperclass();
		System.out.println(Arrays.toString(arrayListOfString.getActualTypeArguments()));// [class java.lang.String]

	}
}
