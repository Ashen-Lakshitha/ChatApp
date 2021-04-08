package database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadMsg {

    String user;
    
    public ReadMsg(String user){
        this.user = user;
    }
    
    public static void main(String[] args) {
        
    }
    
    public ResultSet readMsg(){
        String sql1 = "select * from " + this.user + ";";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/chat","root","");
            Statement stm = (Statement) connection.createStatement();
            ResultSet rst = stm.executeQuery(sql1);
            return rst;
        }catch (SQLException | ClassNotFoundException ex){
            Logger.getLogger(ReadMsg.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    
}
