package coco_chat_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class Coco_Chat_Cliente {


public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Socket s = new Socket("10.147.17.231", 1234);

        PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);
        String mensaje = "¡Hola, mundo! ¿Cómo estás?";
        writer.println(mensaje);

        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));

        String mensajeRecibido = reader.readLine();
        System.out.println("El mensaje del servidor es: " + mensajeRecibido);
        writer.close();
        s.close();
    }

    
}
