import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public class ExportData {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/release_the_fear","root","*#*#ganesh*#*#123");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("file.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("Name");
            row1.createCell(1).setCellValue("email");
            row1.createCell(2).setCellValue("amount");
            Row row2 ;
            ResultSet rs = statement.executeQuery("SELECT name,email,amount FROM Donor");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            //statement.close();
            //con.close();
            fileOut = new FileOutputStream("file_Volunteer.xls");
            HSSFWorkbook workbook1 = new HSSFWorkbook();
            HSSFSheet worksheet1 = workbook1.createSheet("Sheet 0");
            Row row_1 = worksheet1.createRow((short)0);
            row_1.createCell(0).setCellValue("Applicant_Name");
            row_1.createCell(1).setCellValue("Home_Phone");
            row_1.createCell(2).setCellValue("Cell_Phone");
            row_1.createCell(3).setCellValue("Address");
            row_1.createCell(4).setCellValue("Zip");
            row_1.createCell(5).setCellValue("Position");
            row_1.createCell(6).setCellValue("Temp_Part");
            row_1.createCell(7).setCellValue("Reg_part");
            row_1.createCell(8).setCellValue("Availability_day");
            Row row_2 ;
            ResultSet rs_1 = statement.executeQuery("SELECT Applicant_Name,Home_Phone,Cell_Phone, Address, Zip, Position, Temp_Part,Reg_part, Available_day FROM VOLUNTEER");
            while(rs_1.next()){
                int a_1 = rs_1.getRow();
                row_2 = worksheet1.createRow((short)a_1);
                row_2.createCell(0).setCellValue(rs_1.getString(1));
                row_2.createCell(1).setCellValue(rs_1.getString(2));
                row_2.createCell(2).setCellValue(rs_1.getString(3));
                row_2.createCell(3).setCellValue(rs_1.getString(4));
                row_2.createCell(4).setCellValue(rs_1.getString(5));
                row_2.createCell(5).setCellValue(rs_1.getString(6));
                row_2.createCell(6).setCellValue(rs_1.getString(7));
                row_2.createCell(7).setCellValue(rs_1.getString(8));
                row_2.createCell(8).setCellValue(rs_1.getString(9));
            }
            workbook1.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs_1.close();
            statement.close();
            con.close();
            System.out.println("Export Success");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(IOException ioe){
            System.out.println(ioe);
        }

    }

}
