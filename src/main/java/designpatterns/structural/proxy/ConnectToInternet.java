package designpatterns.structural.proxy;

/**
 * Connects to implementation
 * RealInternet using Proxy
 * Internet internet = new ProxyInternet();
 */
public class ConnectToInternet {
	
	public static void main(String[] args){
		Internet internet = new ProxyInternet();
		try {
			internet.connectTo("TicketMaster.com");
			internet.connectTo("abc.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
