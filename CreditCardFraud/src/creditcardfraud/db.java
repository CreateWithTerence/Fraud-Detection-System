
package creditcardfraud;

import java.sql.*;

/**
 *
 * @author terence
 * Data base Connection
 */
public class db {
    
    public static Connection mycon(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardfraud","root","Y12hardewyk38!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
} 