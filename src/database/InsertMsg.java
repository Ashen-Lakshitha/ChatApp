package database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertMsg {
    
    public static void main(String[] args) {
        
    }
    
    public void addMsg(String text, String client){
        String sql1 = "insert into client_1 (msg,user) values('" + text + "','" + client + "')";
        String sql2 = "insert into client_2 (msg,user) values('" + text + "','" + client + "')";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/chat","root","");
            Statement stm = (Statement) connection.createStatement();
            stm.executeUpdate(sql1);
            stm.executeUpdate(sql2);
        }catch (SQLException | ClassNotFoundException ex){
            Logger.getLogger(InsertMsg.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
