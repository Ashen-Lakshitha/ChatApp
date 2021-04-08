package server_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {
    
    Socket socket;
    DataInputStream din;
    DataOutputStream dout;
    ArrayList<ServerThread> client;
    
    public ServerThread(Socket socket, ArrayList<ServerThread> client) throws IOException{
        this.socket = socket;
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());
        this.client = client;
    }
    
    @Override
    public void run(){
        try{
            while (true) {                  
                String str = din.readUTF();
                System.out.println("msg : " + str);
                toAll(str);
            } 
            
        }   catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally{
            try {
                dout.close();
                din.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void toAll(String li) throws IOException{
        for(ServerThread aClient:client){
            aClient.dout.writeUTF(li);
        }
    }
}
