package designpatterns.structural.facade;

import java.sql.Connection;

public class OracleDataHelper implements DataHelper{
	
	public Connection getConnection() {
		return null;
	}
	
	public void generateHtmlReport(Connection connection, String tablename) {
		System.out.println("Oracle HTML report for " + tablename + " table" );
	}
	
	public void generatePdfReport(Connection connection, String tablename) {
		System.out.println("Oracle PDF report for " + tablename + " table" );
	}

}
