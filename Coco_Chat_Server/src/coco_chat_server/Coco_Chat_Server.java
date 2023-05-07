package coco_chat_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import coco_chat_server.HilosCliente;
import db_conection_package.*;
import java.io.ObjectInputStream;

public class Coco_Chat_Server {

    public static void main(String[] args){
        try {
            Socket clientSocket;
            ServerSocket serverSocket = new ServerSocket(1234);
            
            while(true)
            {
               System.out.println("Esperando...");
               clientSocket = serverSocket.accept();
               System.out.println("Conexion recibida");
//               HilosCliente cliente = new HilosCliente(clientSocket);
//               Thread clientThread = new Thread(cliente);
//               clientThread.start();
                ObjectInputStream infoReceived = new ObjectInputStream(clientSocket.getInputStream());
                try {
                  Object objectReceived = infoReceived.readObject();
                  Usuario registerDetails  = (Usuario)objectReceived;
                  UsuarioDAO usuarioDAO = new UsuarioDAO();
                  usuarioDAO.RegistrarUsuario(registerDetails);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Coco_Chat_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}