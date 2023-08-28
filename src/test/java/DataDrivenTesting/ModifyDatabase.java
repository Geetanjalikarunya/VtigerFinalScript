package DataDrivenTesting;

    import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mysql.cj.jdbc.Driver;

	public class ModifyDatabase {

		public static void main(String[] args) throws SQLException {
			Driver dbDriver=new Driver();//JDBC Driver
			DriverManager.registerDriver(dbDriver);//Register driver
			//Connecting to database
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
	        Statement statement=connection.createStatement();//Statement Creation
	        
	        //Step: Execute query to update database
	         int result=statement.executeUpdate("insert into employee(id, name, salary, mobile)values(104,'tgh',45900,'6543278965');");
	        if (result==1)
	        	System.out.println(" Database updated Successfully");
	        else
	        	System.out.println("Failed to update the database");
	        
	        //Step: close the connection
	        connection.close();
		}

	}

