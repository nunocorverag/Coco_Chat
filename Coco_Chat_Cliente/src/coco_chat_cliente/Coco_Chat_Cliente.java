package coco_chat_cliente;

import interfaces.Registro;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Coco_Chat_Cliente {
    
public static void main(String[] args) throws IOException {
        // TODO code application logic here
        /*Socket s = new Socket("10.147.17.231", 1234);

        PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);
        String mensaje = "¡Hola, mundo! ¿Cómo estás?";
        writer.println(mensaje);

        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));

        String mensajeRecibido = reader.readLine();
        System.out.println("El mensaje del servidor es: " + mensajeRecibido);
        writer.close();
        s.close();*/
        
        
        Registro frame = new Registro();        
        frame.setVisible(true);
}

    
}
