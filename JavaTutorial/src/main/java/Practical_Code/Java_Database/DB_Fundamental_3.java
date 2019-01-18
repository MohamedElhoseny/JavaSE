package Practical_Code.Java_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Fundamental_3 
{
    public static void main(String[] args) throws SQLException
    {
      //How to update or scroll data returned by ResultSet (Database affect with editable Data) ??

        new com.mysql.jdbc.Driver();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trace?user=root&password=12121212");
        //Statement s = conn.createStatement();
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );

        //to make resultset to be scrollable and updatable w edited the Statement decleration
        ResultSet result = s.executeQuery("Select * from accounts");


        while (result.next()) {
            System.out.println("id = "+result.getInt("id") +" user = "+result.getString("user"));
        }

        result.first();  //set crusor in resultset to first one
        result.updateString("user", "Boba");   //columnname , data updated
        //mmken amshe 3la resultset klhm w ageb 2le 3wz update 3leh w a3dl be el function updatexx()    xx =>datatype
        result.updateRow();  //confirm update
    }
}
