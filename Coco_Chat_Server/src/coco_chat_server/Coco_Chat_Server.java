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
import java.io.InputStream;
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
               
               InputStream inputStream = clientSocket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String funcion = new String(buffer, 0, bytesRead);
               System.out.println(funcion);
               
               if(funcion.equals("register"))
               {
                    ObjectInputStream infoReceived = new ObjectInputStream(clientSocket.getInputStream());
                    try {
                      Object objectReceived = infoReceived.readObject();
                      Usuario registerDetails  = (Usuario)objectReceived;
                      System.out.println(registerDetails.nombre);
                      UsuarioDAO usuarioDAO = new UsuarioDAO();
                      usuarioDAO.RegistrarUsuario(registerDetails);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Coco_Chat_Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
               if(funcion.equals("login"))
               {
                    ObjectInputStream infoReceived = new ObjectInputStream(clientSocket.getInputStream());
                    try {
                      Object objectReceived = infoReceived.readObject();
                      Usuario loginDetails  = (Usuario)objectReceived;
                      System.out.println(loginDetails.username);
                      System.out.println(loginDetails.password);
                      UsuarioDAO usuarioDAO = new UsuarioDAO();
                      if(usuarioDAO.IniciarSesion(loginDetails.username, loginDetails.password))
                      {
                          //chido
                          System.out.println("Se logro");

                      }
                      else
                      {
                          //chafa
                          System.out.println("No se logro");
                      }   
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Coco_Chat_Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
//               if(recibe == "login")
//               {
//                   
//               }
//               if(recibe == "abrir chat")
//               {
//                   thread
//               }

            }

        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}