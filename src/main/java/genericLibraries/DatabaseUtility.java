package genericLibraries;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.mysql.cj.jdbc.Driver;

//database utility is used to fetch the data

public class DatabaseUtility {

	/*
	 * This class contains reusable methods to perform operations on database
	 * 
	 */
	
		private Connection connection;
		private Statement statement;
		
		/*this class contains reusable methods related to java +operations
		 * 
		 */
		public void databaseInitialization(String url, String user, String pwd)
		{
			Driver dbDriver=null;
			try {
				dbDriver = new Driver();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				DriverManager.registerDriver(dbDriver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection=DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				statement=connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*
		 * this method is used to read data from database
		 * @param query
		 * @param columnName
		 * @return
		 * @throws SQLException
		 */
		public List<String> readFromDatabase(String query,String columnName) throws SQLException
		{
		  ResultSet result=statement.executeQuery(query);
		  List<String> list=new ArrayList<String>();
		  while(result.next())
		  {
			  list.add(result.getString(columnName));
		  }
		  return list;
		}
		
		/*
		 * this method is used to modify database
		 * @param query
		 * @return
		 */
		public int modifyDatabase(String query)
		{
			int result=0;
			try {
				result = statement.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		/*
		 * this method is used to close database connection
		 */
		
		public void closeDatabase()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
}
