package designpatterns.structural.facade;

public class DatabaseFacadeClient {

	public static void main(String[] args) {
		DatabaseHelperFacade.generateReports(DatabaseHelperFacade.DBTYPES.ORACLE, DatabaseHelperFacade.REPORTTYPES.HTML,
				"Employees");
		DatabaseHelperFacade.generateReports(DatabaseHelperFacade.DBTYPES.ORACLE, DatabaseHelperFacade.REPORTTYPES.PDF,
				"Employees");

		DatabaseHelperFacade.generateReports(DatabaseHelperFacade.DBTYPES.MYSQL, DatabaseHelperFacade.REPORTTYPES.HTML,
				"Employees");
		DatabaseHelperFacade.generateReports(DatabaseHelperFacade.DBTYPES.MYSQL, DatabaseHelperFacade.REPORTTYPES.PDF,
				"Employees");
	}

}
