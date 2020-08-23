package designpatterns.structural.facade;

import java.sql.Connection;

public class DatabaseHelperFacade {
	
	public static void generateReports(DBTYPES dbType, REPORTTYPES reportType, String tableName) {
		
		Connection connection = null;
		switch (dbType) {
			case ORACLE:
				DataHelper oracle = new OracleDataHelper();
				switch(reportType) {
					case HTML:
						oracle.generateHtmlReport(connection, tableName);
					break;
					case PDF:
						oracle.generatePdfReport(connection, tableName);
					break;
				}
			break;
			case MYSQL:
				DataHelper mysql = new MySQLDataHelper();
				switch(reportType) {
				case HTML:
					mysql.generateHtmlReport(connection, tableName);
				break;
				case PDF:
					mysql.generatePdfReport(connection, tableName);
				break;
				}
			break;
		}
	}
	
	public static enum DBTYPES{
		ORACLE,MYSQL;
	}
	
	public static enum REPORTTYPES{
		HTML,PDF;
	}
	
}
