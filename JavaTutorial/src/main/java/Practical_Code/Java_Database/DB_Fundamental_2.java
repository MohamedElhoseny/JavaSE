
package Practical_Code.Java_Database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DB_Fundamental_2
{
    public static void main(String[] args) throws SQLException
    {
        new com.mysql.jdbc.Driver();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trace?user=root&password=12121212");
        Statement s = conn.createStatement();      
        String query ;
        
        
     /* executBatch() method */
        
        s.clearBatch();
        query = "INSERT INTO bank VALUES(1003,5000)";        
        s.addBatch(query);
        query = "INSERT INTO bank VALUES(1004,4000)";
        s.addBatch(query);
        query = "INSERT INTO accounts VALUES(1004,omda,123)";
        s.addBatch(query);
        
        //ana b5zn kza query zy fe array kda bnsmeh Batch() w 2wl lma a3oz executeBatch() bynfz el queries bel trteb 2le add behm
        // tb3n mmken ykon fe query fehm m3tmda 3la query tanya w beltale 3wz a2mn el 7kaya dh be rollback
        // ha5od nfs el klam 2le fo2 w lakn be rollback
        
        try
        {       
            conn.setAutoCommit(false);
            s.clearBatch();
            query = "INSERT INTO bank VALUES(1003,5000)";        
            s.addBatch(query);
            query = "INSERT INTO bank VALUES(1004,4000)";
            s.addBatch(query);
            query = "INSERT INTO accounts VALUES(1004,'omda',123)";
            s.addBatch(query);
            
            s.executeBatch();
            conn.commit();
            
        }catch (SQLException e)
        {
            conn.rollback();
            System.err.println("rollback occurred");
        }
        
        //VIP lma 7sl rollback mynf3sh code b3deh ytnfz fa dymn btb2a fe method
        
        /* Pre-Compile Statement => preparedStatement   */
        
        PreparedStatement st = conn.prepareCall("INSERT INTO accounts VALUES (?,?,?)");


        st.setInt(1, 1006);   //id 
        st.setString(2, "Omar");   //user  
        st.setInt(3, 1213123);  //pass

        st.executeUpdate();
    }
    
    
}
