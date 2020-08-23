package designpatterns.structural.facade;

import java.sql.Connection;

public class MySQLDataHelper implements DataHelper {
	
	public Connection getConnection() {
		return null;
	}
	
	public void generateHtmlReport(Connection connection, String tablename) {
		System.out.println("MySQL HTML report for " + tablename + " table" );
	}
	
	public void generatePdfReport(Connection connection, String tablename) {
		System.out.println("MySQL PDF report for " + tablename + " table" );
	}

}
