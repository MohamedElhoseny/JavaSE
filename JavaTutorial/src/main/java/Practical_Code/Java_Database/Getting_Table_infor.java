
package Practical_Code.Java_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Getting_Table_infor
{
    public static void main(String[] args) throws SQLException
    {
        new com.mysql.jdbc.Driver();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trace?user=root&password=12121212");
        Statement s = conn.createStatement();
        ResultSet result = s.executeQuery("Select * from accounts");
        
        ResultSetMetaData info = result.getMetaData();   //what different between DatabaseMetaData and ResultSetMetaData ??
        
        System.out.println("N.of Rows = "+info.getColumnCount());
        System.out.println("Columns Names in this table = "+info.getColumnName(1) +","+info.getColumnName(2)+","+info.getColumnName(3));
        System.out.println("Column Name = "+info.getColumnName(2) +" DataType = "+info.getColumnTypeName(2));
    
    }
}