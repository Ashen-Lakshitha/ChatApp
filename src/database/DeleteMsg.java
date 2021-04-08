package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteMsg {
    
    public static void main(String[] args) {
        
    }
    
    public void deleteMsg(String user){
        String sql1 = "delete from " + user + " where id > 0;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/chat","root","");
            Statement stm = (Statement) connection.createStatement();
            stm.executeUpdate(sql1);
        }catch (SQLException ex){
            Logger.getLogger(ReadMsg.class.getName()).log(Level.SEVERE,null,ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteMsg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
