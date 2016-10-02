

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VolunteerInsertServlet
 */
@WebServlet("/VolunteerInsertServlet")
public class VolunteerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Submitted Sucessfully: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Applicant_Name = request.getParameter("Applicant_Name");
		String Home_Phone = request.getParameter("Home_Phone");
		String Cell_Phone = request.getParameter("Cell_Phone");
		String Address = request.getParameter("Address");
		String Zip = request.getParameter("Zip");
		String Position = request.getParameter("Position");
		String Temp_Part = request.getParameter("T1");
		String Reg_part = request.getParameter("R1");
		
		String day1= request.getParameter("days1");
		String day2= request.getParameter("days2");
		String day3= request.getParameter("days3");
		String day4= request.getParameter("days4");
		String day5= request.getParameter("days5");
		String day6= request.getParameter("days6");
		String Available_day =day1+" "+day2+" "+day3+" "+day4+" " +day5+" "+day6 ;
		Volunteer d=new Volunteer();
		d.setApplicant_Name(Applicant_Name);
		d.setHome_Phone(Integer.parseInt(Home_Phone));
		d.setCell_Phone(Integer.parseInt(Cell_Phone));
		d.setAddress(Address);
		d.setZip(Integer.parseInt(Zip));
		d.setPosition(Position);
		d.setTemp_Part(Temp_Part);
		d.setReg_part(Reg_part);
		d.setAvailable_day(Available_day);
		//d.setAmount(5000);
		VolunteerInsert di;
		try {
			di = new VolunteerInsert();
			di.main(d);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
