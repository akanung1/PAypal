
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import com.mysql.jdbc.Connection;
public class VolunteerInsert {

	
	//import com.mysql.jdbc.PreparedStatement;


		private static Connection conn;
		VolunteerInsert() throws ClassNotFoundException{
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
		
		public static void main(Volunteer d)
		  {
		    try
		    {
		    	
		      // create a mysql database connection
		      
		      //Statement st = (Statement) conn.createStatement();

		      // note that i'm leaving "date_created" out of this insert statement
		      //st.executeUpdate("INSERT INTO Donor (name, email, Amount) "
		        //  +"VALUES ('ankush', 'akanung1@asu.edu',10000)");
		      
		      String query = "INSERT INTO VOLUNTEER "
		      		+ "(Applicant_Name,Home_Phone,Cell_Phone,Address,Zip,Position,Temp_Part,Reg_part,Available_day) VALUES (?,?,?,?,?,?,?,?,?)";
		      try{
		    	  PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
		    	  st.setString(1,d.getApplicant_Name());
		    	  st.setInt(2, d.getHome_Phone());
		    	  st.setInt(3, d.getCell_Phone());
		    	  st.setString(4,d.getAddress());
		    	  st.setInt(5,d.getZip());
		    	  st.setString(6,d.getPosition());
		    	  st.setString(7,d.getTemp_Part());
		    	  st.setString(8,d.getReg_part());
		    	  st.setString(9,d.getAvailable_day());
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
