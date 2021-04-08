package server_client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    
    private static ServerSocket server;
    private static Socket socket;
    private static ArrayList<ServerThread> client = new ArrayList<>();
   
    public static void main(String[] args) throws IOException {
        server = new ServerSocket(1111);
        System.out.println("Server");

        while (true) {            
            socket = server.accept();
            ServerThread serverThread = new ServerThread(socket,client);
            serverThread.start();
            client.add(serverThread);
            System.out.println("Clients : " + client);
        }
    }
    
}