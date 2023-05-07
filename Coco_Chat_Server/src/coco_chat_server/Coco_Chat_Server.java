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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class Coco_Chat_Server {

    public static void main(String[] args){
        try {
            Socket clientSocket;
            ServerSocket serverSocket = new ServerSocket(1234);

            Map<String, Integer> intentosInicioSesion = new HashMap<>();
            
            while(true)
            {
               System.out.println("Esperando...");
               clientSocket = serverSocket.accept();
               System.out.println("Conexion recibida");
               
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                String clienteConectado =  clientSocket.getInetAddress().getHostAddress();
               
                if(!(intentosInicioSesion.containsKey(clienteConectado)))
                {
                    intentosInicioSesion.put(clienteConectado, 0);
                }
                DataInputStream salidaFuncion = new DataInputStream(clientSocket.getInputStream());
                String funcion = salidaFuncion.readUTF();
                System.out.println("Funcion: " + funcion);
               
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
                          System.out.println("Credenciales validas");
                          intentosInicioSesion.put(clienteConectado, 0);
                          DataOutputStream respuestaCredencialesValidas = new DataOutputStream(clientSocket.getOutputStream());
                          respuestaCredencialesValidas.writeUTF("credenciales_validas");
                      }
                      else
                      {
                          //chafa
                          System.out.println("Credenciales NO validas");
                          int cantidad_intentos = intentosInicioSesion.get(clienteConectado);
                          cantidad_intentos ++;
                          System.out.println("Cantidad intentos: " + cantidad_intentos);
                          intentosInicioSesion.put(clienteConectado, cantidad_intentos);
                          if(cantidad_intentos == 3)
                          {
                            intentosInicioSesion.put(clienteConectado, 0);
                            DataOutputStream respuestaRedirigir = new DataOutputStream(clientSocket.getOutputStream());
                            respuestaRedirigir.writeUTF("redirigir");
                          }
                          else
                          {
                            DataOutputStream respuestaCredencialesNoValidas = new DataOutputStream(clientSocket.getOutputStream());
                            respuestaCredencialesNoValidas.writeUTF("credenciales_invalidas");
                          }

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