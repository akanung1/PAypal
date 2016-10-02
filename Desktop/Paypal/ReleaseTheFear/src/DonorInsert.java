import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

public class DonorInsert {
	private static Connection conn;
	DonorInsert() throws ClassNotFoundException{
		String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/release_the_fear";
	      Class.forName(myDriver);
	      try {
			conn = (Connection) DriverManager.getConnection(myUrl, "root", "*#*#ganesh*#*#123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		
	}
	
	public static void main(Donor d)
	  {
	    try
	    {
	    	
	      // create a mysql database connection
	      
	      //Statement st = (Statement) conn.createStatement();

	      // note that i'm leaving "date_created" out of this insert statement
	      //st.executeUpdate("INSERT INTO Donor (name, email, Amount) "
	        //  +"VALUES ('ankush', 'akanung1@asu.edu',10000)");
	      String query = "INSERT INTO Donor("
	    		  + "name,"
	    		  + "email,"
	    		  + "amount) VALUES("
	    		  + "?, ?, ?)";
	      try{
	    	  PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
	    	  st.setString(1,d.getName());
	    	  st.setString(2, d.getEmail());
	    	  st.setInt(3, d.getAmount());
	    	  st.executeUpdate();
	      }
	      catch(SQLException se){
	    	  System.out.println(se);
	      }
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  }

}
