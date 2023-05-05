package four.collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	
	public static void main(String[] args) {
		
		List<String> textList = new ArrayList<String>();
		textList.add("a");textList.add("b");
		textList.add("c");textList.add("d");
		textList.add("e");textList.add("f");
		textList.add("g");textList.add("h");
		textList.add("i");textList.add("j");
		textList.add("k");textList.add("l");
		textList.replaceAll((e) -> e.toUpperCase());
		System.out.println(textList);
		System.out.println(textList.contains("a"));
		System.out.println(textList.contains("A"));
		System.out.println(textList.lastIndexOf("B"));
		
		textList.remove("G");System.out.println(textList);
		textList.remove(4);System.out.println(textList);
		
		ArrayList<String> newList = new ArrayList<String>();
		newList.addAll(textList);System.out.println(newList);
		newList.clear();System.out.println(newList);
		
	}

}
