package db_conection_package;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author gnuno
 */
public class MensajesDAO extends Db_Conection{
    public MensajesDAO()
    {
        super();
    }
    
    public boolean EnviarMensajeUsuario(int mensaje_de, int mensaje_para, String mensaje) 
    {
        try
        {
            
        Timestamp fecha_actual = new Timestamp(System.currentTimeMillis());

        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO mensaje_usuario (remitente_usuario, destinatario_usuario, fecha_mensaje_usuario, mensaje_usuario) values (?,?,?,?)");
        
        ps.setInt(1, mensaje_de);
        ps.setInt(2, mensaje_para);
        ps.setTimestamp(3, fecha_actual);
        ps.setString(4, mensaje);
        
        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean EnviarMensajeAmigo(int mensaje_de, int mensaje_para, String mensaje) 
    {
        try
        {
            
        Timestamp fecha_actual = new Timestamp(System.currentTimeMillis());

        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO mensaje_amigo (remitente_amigo, destinatario_amigo, fecha_mensaje_amigo, mensaje_amigo) values (?,?,?,?)");
        
        ps.setInt(1, mensaje_de);
        ps.setInt(2, mensaje_para);
        ps.setTimestamp(3, fecha_actual);
        ps.setString(4, mensaje);
        
        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean EnviarMensajeGrupo(int mensaje_de, int mensaje_para, String mensaje) 
    {
        try
        {
            
        Timestamp fecha_actual = new Timestamp(System.currentTimeMillis());

        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO mensaje_grupo (remitente_usuario, destinatario_grupo, fecha_mensaje_grupo, mensaje_grupo) values (?,?,?,?)");
        
        ps.setInt(1, mensaje_de);
        ps.setInt(2, mensaje_para);
        ps.setTimestamp(3, fecha_actual);
        ps.setString(4, mensaje);
        
        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}

