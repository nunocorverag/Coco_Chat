/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coco_chat_server;

import java.net.Socket;

/**
 *
 * @author PABLOPC
 */
public class HilosCliente implements Runnable{
    
    private final Socket clientSocket;
    
    public HilosCliente(Socket socket)
    {
        this.clientSocket = socket;
    }
    
    @Override
    public void run() {
        System.out.println("Cliente conectado desde " + clientSocket.getInetAddress().getHostAddress());
    }
    
}
