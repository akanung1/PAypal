import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DonorInsert {
	
	public static void main(String[] args)
	  {
	    try
	    {
	      // create a mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/release_the_fear";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "*#*#ganesh*#*#123");
	      
	      Statement st = (Statement) conn.createStatement();

	      // note that i'm leaving "date_created" out of this insert statement
	      st.executeUpdate("INSERT INTO Donor (name, email, Amount) "
	          +"VALUES ('ankush', 'akanung1@asu.edu',10000)");

	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  }

}
