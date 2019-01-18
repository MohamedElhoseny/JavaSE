package Practical_Code.Java_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class rollback_Data 
{
    public static void main(String[] args) throws SQLException
    {
        new com.mysql.jdbc.Driver();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trace?user=root&password=12121212");

        if(conn != null)
            System.out.println("Connected");
        
        Statement s = conn.createStatement();

        String query = "CREATE TABLE bank( id integer , money integer )";
        s.executeUpdate(query);
        
        query = "INSERT INTO bank VALUES (1001,1200)";
        s.executeUpdate(query);
        
        
        
        
 /************* 3wzen n3ml dlw2te 7aga s8yra w hwa 2ne 2n2l 500 mn flos bto3 customer id=1001 w awdehm (transfer) le acount tane ***************/
        
       /* el moshkla 3ltol 2ne mmken w ana bd5l 2wl query t5osh w tmam w 2ge 2bl lma a3ml query el tanya yege error w bel tale el error dh 3ml moseba  */
       /* n2st mn flos ragel w mwdetsh el flos y3ne el System Baz _|_ la ana 3wz a3ml 7aga b7es w hwa sh8al 3la el goz el m3yn dh lw 7sl error hna    */
       /* y3ml 7aga asmha rollback  y3ne yrg3  kol 2le 3mlo 2bl error  y3ne hwa 2bl error n2s el money bta3o hyrg3 y3mlo zy Ctrl-Z le 2le 3mlo */
        
        
        
        query = "UPDATE bank SET money = 1200-200 Where id = 1001";
        s.executeQuery(query);   //n2st 200LE mn el 2wl
        System.err.println("Person whose id = 1001 , his money decrease by 200 and it will translate to another");
        query = "UPDATE bank SET money = 1200+200 Where id = 1002";
    /* -------------------------------------------------------------------------
        -------------------------------------------------------------------------
         What Happen if an error Occur before executing the next Query ?
        -----------------------------------------------------------------------
        --------------------------------------------------------------------
    */
    //    s.executeQuery(query);
        System.err.println("Money translated to person whose id = 1002");
        
        
        //The Solution is Atomic_Transaction  or Called => rollback
        try 
        {
            conn.setAutoCommit(false);     
            //dh k2no by2olo mt3mlsh execute le methods Execute l8ayt lma y7sl commit() w ht3mlhm m3 b3d bel trteb typ lw 7sl b2a error 
            //fe catch htal2e el rollback y3ne kol el 7aga 2le 3mlha mn sa3t lma 3mlna autocommit be false l8ay lma 3mlna commit hyrg3 kol 2le 3mlo 3shan fe error 7sl
              query = "UPDATE bank SET money = 1000 Where id = 1001";
              s.executeQuery(query);   //n2st 200LE mn el 2wl
              System.err.println("Person whose id = 1001 , his money decrease by 200 and it will translate to another");
              query = "UPDATE bank SET money = 1400 Where id = 1008";
              s.executeQuery(query);
              System.err.println("Money translated to person whose id = 1002");
              
            conn.commit();
        } 
        catch (SQLException e)
        {
            conn.rollback();
            System.err.println("rollback occured due to and error happen");
        }
    }
}
