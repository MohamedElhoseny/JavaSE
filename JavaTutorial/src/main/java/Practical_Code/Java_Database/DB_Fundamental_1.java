package Practical_Code.Java_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB_Fundamental_1 
{
       public static void main(String[] args) throws ClassNotFoundException, SQLException
       {
           //Registering Database Driver  (1)
           new com.mysql.jdbc.Driver();

           //Request a Connection to specific Database (2)
           String mysql_driver = "jdbc:mysql://localhost:3306/trace";
           String user = "root";
           String pass = "12121212";
           Connection conn = DriverManager.getConnection(mysql_driver, user, pass);

           if(conn != null)
               System.out.println("Database Connected");

           
           //Executing SQL Query using Statments Interface Methods (3)
           Statement s = conn.createStatement();
           
           String query = "CREATE TABLE accounts("
                         +" id integer primary key,"
                         +" user varchar(20),"
                         +" pass integer)";
           

    
           //s.executeUpdate(query);  return number of row affected  "I make it comment to prevent already exist table Exceotion"
           String d1 = "INSERT INTO accounts Values(1003,'Omda','123456')";   
          // s.executeUpdate(d1);   
           
           
           
           String r1 = "Select * From accounts";
           ResultSet result =  s.executeQuery(r1);  //have a table of data     ResultSet interface provide Methods to set cursor in table to select data
           //using cursor to check data user Next() Method
           while (result.next()) 
           {
               System.err.println("id = "+result.getInt("id") +", User = "+result.getString("user") +", Pass = "+result.getInt("pass"));
           }
           
           
           //execute() Method  => Used when we get the Sql query from Source and We cannot identify that if this query select or insert data in DB
           
           if (s.execute(r1) == true)  //if this query is as Select  => retrieving Data as ResultSet (Table)
           {
               ResultSet r = s.getResultSet();
               while (r.next()) 
               {              
                   System.out.println(r.getInt("id"));
               }
           }
           else    // False => if this query is as Insert  =>  return n. of effected rows  can get = getupdatecount()
           {
               System.out.println("Number of rows affected = "+s.getUpdateCount());   
           }
           
           conn.close();
 
       }        
       
}
