package designpatterns.structural.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Proxy implementation 
 * of interface
 * 
 * The implementation uses real implementation
 * private Internet internet = new RealInternet();
 * but adds some limiting factors(Access Controls)
 * 
 */
public class ProxyInternet implements Internet {
	
	private Internet internet = new RealInternet();
	private static List<String> bannedSites;
	
	public void connectTo(String URL) throws Exception {
		//filter criteria, this can also be access control
		if(bannedSites.contains(URL)) {
			throw new Exception("Access Denied");
		}
		internet.connectTo(URL);
	}
	
	static {
		bannedSites = new ArrayList<String>();
		bannedSites.add("abc.com");
		bannedSites.add("def.com");
		bannedSites.add("ghi.com");
		bannedSites.add("jkl.com");
	}
}
