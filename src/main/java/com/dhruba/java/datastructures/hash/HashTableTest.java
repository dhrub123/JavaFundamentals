package com.dhruba.java.datastructures.hash;

/**
 * 
 *TODO: increasing capacity will reduce hash collision
 *TODO: implementing tool with a separate class may reduce collision
 *
 */
public class HashTableTest {
	
	private BasicHashTable<String, String> toolSet = new BasicHashTable<>(12);
	
	public static void main(String[] args) {
		HashTableTest app = new HashTableTest();
		app.changeMotorOil();
	}
	
	public void changeMotorOil() {
		buildToolSet();
		
		removeSkidPlate();
		
		drainAndReplaceOil();
		
		replaceSkidPlate();
		
		emptyToolSet();
		
	}

	private void emptyToolSet() {
		toolSet.delete("8mm");
		toolSet.delete("10mm");
		toolSet.delete("12mm");
		toolSet.delete("14mm");
		toolSet.delete("17mm");
		toolSet.delete("1/4sae");
		toolSet.delete("3/8sae");
		toolSet.delete("1/2sae");
		toolSet.delete("5/8sae");
		toolSet.delete("3/4sae");
		toolSet.delete("1/4d");
		toolSet.delete("2de");
		System.out.println("Toolset size " + toolSet.size());
		
	}

	private void replaceSkidPlate() {
		String socket = toolSet.get("10mm");
		String wrench = toolSet.get("1/4d");
		System.out.println("Replaced 4 skid plate nuts with the " + socket + " and " + wrench);
		
	}

	private void drainAndReplaceOil() {
		System.out.println("Toolset has 17mm ? - " + toolSet.hasValue("17mm socket"));
		String socket = toolSet.get("17mm");
		String wrench = toolSet.get("1/4d");
		System.out.println("Work done with the " + socket + " and " + wrench);
		
	}

	private void removeSkidPlate() {
		String socket = toolSet.get("10mm");
		String wrench = toolSet.get("1/4d");
		System.out.println("Removed 4 skid plate nuts with the " + socket + " and " + wrench);
		
	}

	private void buildToolSet() {
		toolSet.put("8mm","8mm socket");
		toolSet.put("10mm","10mm socket");
		toolSet.put("12mm","12mm socket");
		toolSet.put("14mm","14mm socket");
		toolSet.put("17mm","17mm socket");
		toolSet.put("1/4sae","1/4sae socket");
		toolSet.put("3/8sae","3/8sae socket");
		toolSet.put("1/2sae","1/2sae socket");
		toolSet.put("5/8sae","5/8sae socket");
		toolSet.put("3/4sae","3/4sae socket");
		toolSet.put("1/4d","1/4 socket wrench");
		toolSet.put("2de","2 inch Drive extension");
		System.out.println("Toolset size " + toolSet.size());
		
	}
	
	
	
	
}
