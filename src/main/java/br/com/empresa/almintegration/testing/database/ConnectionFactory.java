package br.com.empresa.almintegration.testing.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.helper.Utils;

public class ConnectionFactory {

	private final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private String DB_CONNECTION;
	private String QUERY;

	public ConnectionFactory(String query) throws FileNotFoundException, IOException, URISyntaxException {
		this.QUERY = query;
		Properties p = Utils.carregaDBProperties();
		DB_CONNECTION = "jdbc:oracle:thin:@"
				+p.getProperty(ViewConstants.DB.ConfigTesteIntegrado.HOST)+":"
				+p.getProperty(ViewConstants.DB.ConfigTesteIntegrado.PORT)+":"
				+p.getProperty(ViewConstants.DB.ConfigTesteIntegrado.SID);
	}

	public ConnectionFactory(Object query2) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Map<String, String>> getResultSet() throws SQLException, FileNotFoundException, IOException, URISyntaxException {

		ResultSet rs = getDBConnection().createStatement().executeQuery(QUERY);
		ArrayList<String> dbFields = getDBFields(QUERY);

		ArrayList<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		while(rs.next()){
			Map<String, String> map = new HashMap<String, String>();
			for (String field : dbFields){
				map.put(field, rs.getString(field));
			}
			maps.add(map);
		}
		
		return maps;
	}

	private static ArrayList<String> getDBFields(String query) {

		ArrayList<String> list = new ArrayList<String>();

		String[] fields = query.split(" AS ");

		for (String string : fields) {

			if(string.contains(",")){
				list.add(string.split(",")[0]);
				continue;
			}

			if(string.contains(" FROM ")){
				list.add(string.split(" FROM ")[0]);
				break;
			}
		}

		return list;
	}

	private Connection getDBConnection() throws FileNotFoundException, IOException, URISyntaxException {

		Connection dbConnection = null;

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(
					DB_CONNECTION, 
					Utils.carregaDBProperties().getProperty(ViewConstants.DB.ConfigTesteIntegrado.USERNAME),
					Utils.carregaDBProperties().getProperty(ViewConstants.DB.ConfigTesteIntegrado.PASSWORD));
			return dbConnection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return dbConnection;
	}

}
