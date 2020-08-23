package designpatterns.structural.proxy;

/**
 * Actual implementation 
 * of interface
 */
public class RealInternet implements Internet {

	public void connectTo(String URL) {
		System.out.println("Connected to " + URL);
	}

}
