package designpatterns.structural.facade;

import java.sql.Connection;

public interface DataHelper {

	Connection getConnection();

	void generateHtmlReport(Connection connection, String tablename);

	void generatePdfReport(Connection connection, String tablename);

}