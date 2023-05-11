package db_conection_package;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import returned_models.RespuestaMensajesUsuario;

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
    
    public ArrayList<RespuestaMensajesUsuario> obtenerMensajesUsuario(int usuario, int usuario_mensaje)
    {
        ArrayList<RespuestaMensajesUsuario> listaMensajesUsuario = new ArrayList();
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM mensaje_usuario where (remitente_usuario = ? AND destinatario_usuario = ?) OR (remitente_usuario = ? AND destinatario_usuario = ?))");
            ps.setInt(1, usuario);
            ps.setInt(2, usuario_mensaje);
            ps.setInt(3, usuario_mensaje);
            ps.setInt(4, usuario);
            ResultSet rs;
            RespuestaMensajesUsuario mensajeUsuario;
            rs = ps.executeQuery(); 

            while (rs.next())
            {
                mensajeUsuario = new RespuestaMensajesUsuario();
                mensajeUsuario.fecha_mensaje_usuario = rs.getTimestamp("fecha_mensaje_usuario");
                mensajeUsuario.mensaje_usuario = rs.getString("mensaje_usuario");
                mensajeUsuario.username_destinatario = rs.getString("username_destinatario");
                mensajeUsuario.username_remitente = rs.getString("username_remitente");
                listaMensajesUsuario.add(mensajeUsuario);
            }            
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return listaMensajesUsuario;
    }
    
    public ArrayList<Mensaje_Amigo> obtenerMensajesAmigo(int usuario, int amigo_mensaje)
    {
        ArrayList<Mensaje_Amigo> listaMensajesAmigo = new ArrayList();
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM mensaje_amigo where (remitente_amigo = ? AND destinatario_amigo = ?) OR (remitente_amigo = ? AND destinatario_amigo = ?))");
            ps.setInt(1, usuario);
            ps.setInt(2, amigo_mensaje);
            ps.setInt(3, amigo_mensaje);
            ps.setInt(4, usuario);
            ResultSet rs;  
            Mensaje_Amigo mensajeAmigo;
            rs = ps.executeQuery(); 

            while (rs.next())
            {
                mensajeAmigo = new Mensaje_Amigo();
                mensajeAmigo.remitente_amigo = rs.getInt("remitente_amigo");
                mensajeAmigo.destinatario_amigo = rs.getInt("destinatario_amigo");
                mensajeAmigo.fecha_mensaje_amigo = rs.getTimestamp("fecha_mensaje_amigo");
                mensajeAmigo.mensaje_amigo = rs.getString("mensaje_amigo");
                listaMensajesAmigo.add(mensajeAmigo);
            }            
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return listaMensajesAmigo;
    }
    
    public ArrayList<Mensaje_Grupo> obtenerMensajesGrupo(int grupo_mensaje)
    {
        ArrayList<Mensaje_Grupo> listaMensajesGrupo = new ArrayList();
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM mensaje_grupo where destinatario_grupo = ?)");
            ps.setInt(1, grupo_mensaje);
            ResultSet rs;  
            Mensaje_Grupo mensajeGrupo;
            rs = ps.executeQuery(); 

            while (rs.next())
            {
                mensajeGrupo = new Mensaje_Grupo();
                mensajeGrupo.remitente_grupo = rs.getInt("remitente_grupo");
                mensajeGrupo.destinatario_grupo = rs.getInt("destinatario_grupo");
                mensajeGrupo.fecha_mensaje_grupo = rs.getTimestamp("fecha_mensaje_grupo");
                mensajeGrupo.mensaje_grupo = rs.getString("mensaje_grupo");
                listaMensajesGrupo.add(mensajeGrupo);
            }            
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return listaMensajesGrupo;
    }

}

