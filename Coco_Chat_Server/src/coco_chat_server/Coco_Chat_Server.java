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
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import returned_models.*;

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
                System.out.println("Salida Funcion: " + salidaFuncion);

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
                          //Exito al iniciar sesion
                          System.out.println("Credenciales validas");
                          intentosInicioSesion.put(clienteConectado, 0);
                          DataOutputStream respuestaCredencialesValidas = new DataOutputStream(clientSocket.getOutputStream());
                          respuestaCredencialesValidas.writeUTF("credenciales_validas");
                          usuarioDAO.ConectarUsuario(loginDetails.username);
                      }
                      else
                      {
                          //Hubo un fallo en las credenciales
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
               if(funcion.equals("recuperar_cuenta_validar"))
               {
                    ObjectInputStream infoReceived = new ObjectInputStream(clientSocket.getInputStream());
                    try {
                      Object objectReceived = infoReceived.readObject();
                      Usuario recoverAccountValidate  = (Usuario)objectReceived;
                      System.out.println(recoverAccountValidate.username);
                      System.out.println(recoverAccountValidate.pregunta_respaldo);
                      UsuarioDAO usuarioDAO = new UsuarioDAO();
                      if(usuarioDAO.RecuperarCuentaValidar(recoverAccountValidate.username, recoverAccountValidate.pregunta_respaldo))
                      {
                          System.out.println("redirigir_recuperar_contrasena");  
                          String username = recoverAccountValidate.username;
                          System.out.println(username);
                          RespuestaRecuperarCuenta respuesta = new RespuestaRecuperarCuenta("redirigir_recuperar_contrasena", username);
                          ObjectOutputStream respuestaCredencialesCorrectas = new ObjectOutputStream(clientSocket.getOutputStream());
                          respuestaCredencialesCorrectas.writeObject(respuesta);
                      }
                      else
                      {
                          System.out.println("error_fallo_pregunta_o_usuario");
                          DataOutputStream respuestaCredencialesValidas = new DataOutputStream(clientSocket.getOutputStream());
                          respuestaCredencialesValidas.writeUTF("error_fallo_pregunta_o_usuario");
                      }   
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Coco_Chat_Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
               if(funcion.equals("recuperar_contrasena"))
               {
                    ObjectInputStream infoReceived = new ObjectInputStream(clientSocket.getInputStream());
                    try {
                      Object objectReceived = infoReceived.readObject();
                      Usuario recoverAccountValidate  = (Usuario)objectReceived;
                      System.out.println(recoverAccountValidate.username);
                      System.out.println(recoverAccountValidate.password);
                      UsuarioDAO usuarioDAO = new UsuarioDAO();
                      if(usuarioDAO.CambiarContrasena(recoverAccountValidate.username, recoverAccountValidate.password))
                      {
                          //chido
                          System.out.println("exito_cambiar_contrasena");
                          DataOutputStream respuestaCredencialesValidas = new DataOutputStream(clientSocket.getOutputStream());
                          respuestaCredencialesValidas.writeUTF("exito_cambiar_contrasena");
                      }
                      else
                      {
                          System.out.println("error_cambiar_contrasena");
                          DataOutputStream respuestaCredencialesValidas = new DataOutputStream(clientSocket.getOutputStream());
                          respuestaCredencialesValidas.writeUTF("error_cambiar_contrasena");
                      }   
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Coco_Chat_Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }

               if(funcion.equals("mostrar_usuarios"))
               {
                   UsuarioDAO usuarioDAO = new UsuarioDAO();
                   ArrayList<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();
                   ObjectOutputStream respuestaCredencialesCorrectas = new ObjectOutputStream(clientSocket.getOutputStream());
                   respuestaCredencialesCorrectas.writeObject(listaUsuarios);
               }

               if(funcion.equals("cerrar_sesion"))
               {
                      DataInputStream informacionUsuarioCliente = new DataInputStream(clientSocket.getInputStream());
                      String nombre_usuario = informacionUsuarioCliente.readUTF();
                      System.out.println("Desconectar usuario:");
                      System.out.println(nombre_usuario);
                      UsuarioDAO usuarioDAO = new UsuarioDAO();
                      usuarioDAO.DesconectarUsuario(nombre_usuario);
               }



            } //Fin del while

        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}