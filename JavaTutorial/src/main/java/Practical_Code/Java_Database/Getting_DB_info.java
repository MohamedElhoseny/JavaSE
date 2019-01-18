package Practical_Code.Java_Database;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class Getting_DB_info 
{
    //using DatabaseMetaData  interface
    public static void main(String[] args) throws SQLException 
    {
        new com.mysql.jdbc.Driver();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trace?user=root&password=12121212");
        Statement s = conn.createStatement();
        
        
        DatabaseMetaData  DB_Info = conn.getMetaData();
        
        //keywords in mysql
        String keywords = DB_Info.getSQLKeywords();
        System.out.println(keywords);
        
        
        //bgeb kol el methods 2le mwgoda fe DatabaseMetaData
        Method[] m = DB_Info.getClass().getMethods();
       
        /*for(Method x : m)
        {
            System.err.println(x.getName());
        }*/
        
        
        //some info in mysql
        
        System.out.println(DB_Info.getDriverName());
        System.out.println(DB_Info.getDriverVersion());
        System.out.println(DB_Info.getDatabaseProductName());
;    }
}
