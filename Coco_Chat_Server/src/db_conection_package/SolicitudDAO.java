package db_conection_package;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author gnuno
 */
public class SolicitudDAO extends Db_Conection{
    public SolicitudDAO()
    {
        super();
    }
    
    public boolean EnviarSolicitudAmistad(int solicitud_de, int solicitud_para) 
    {
        try
        {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO solicitudes_de_amistad (usuario_solicitado, usuario_que_solicito) values (?,?)");
        
        ps.setInt(1, solicitud_de);
        ps.setInt(2, solicitud_para);
        
        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
      public boolean AceptarSolicitudAmistad(int solicitud_de, int solicitud_para) 
    {
        try
        {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO amistad (amigo1, amigo2) values (?,?)");
        
        ps.setInt(1, solicitud_de);
        ps.setInt(2, solicitud_para);
        
        ps = getConnection().prepareStatement("DELETE FROM solicitud_amistad where remitente_solicitud_amistad = ? AND destinatario_solicitud_amistad = ?");
        ps.setInt(1, solicitud_de);
        ps.setInt(2, solicitud_para);

        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean RechazarSolicitudAmistad(int solicitud_de, int solicitud_para) 
    {
        try
        {
        PreparedStatement ps = getConnection().prepareStatement("DELETE FROM solicitud_amistad where remitente_solicitud_amistad = ? AND destinatario_solicitud_amistad = ?");
        ps.setInt(1, solicitud_de);
        ps.setInt(2, solicitud_para);

        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean EliminarAmigo(int id_usuario, int id_amigo) 
    {
        try
        {
        //Eliminar los mensajes
        PreparedStatement ps1 = getConnection().prepareStatement("DELETE FROM mensaje_amigo where (remitente_amigo = ? AND destinatario_amigo = ?) OR (remitente_amigo = ? AND destinatario_amigo = ?)");
        ps1.setInt(1, id_usuario);
        ps1.setInt(2, id_amigo);
        ps1.setInt(3, id_amigo);
        ps1.setInt(4, id_usuario);
        ps1.executeUpdate();
                
        //Eliminar al amigo
        PreparedStatement ps2 = getConnection().prepareStatement("DELETE FROM amistad where (amigo1 = ? AND amigo2 = ?) OR (amigo1 = ? AND amigo2 = ?)");
        ps2.setInt(1, id_usuario);
        ps2.setInt(2, id_amigo);
        ps2.setInt(3, id_amigo);
        ps2.setInt(4, id_usuario);

        return ps2.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}

