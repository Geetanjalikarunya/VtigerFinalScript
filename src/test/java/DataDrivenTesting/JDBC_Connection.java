package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Connection {

	public static void main(String[] args) throws SQLException {
		// Step 1: create an instance of JDBC driver
		Driver dbDriver = new Driver();

		// Step 2: Register Driver
		DriverManager.registerDriver(dbDriver);

		// Step 3: Establish database Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "	root", "root");

		// Step 4: Create Statement
		Statement statement = connection.createStatement();

		// Step 5: Execute query to fetch data
		ResultSet result = statement.executeQuery("select* from employee");

		while (result.next()) {
			System.out.println(result.getInt("id") + "\t" + result.getString("name") + "\t" + result.getInt("salary")
					+ "\t" + result.getString("Mobile"));
		}

		// Step 6: Close database connection
		connection.close();

	}

}
