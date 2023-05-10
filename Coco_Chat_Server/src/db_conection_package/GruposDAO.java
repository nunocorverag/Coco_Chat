package db_conection_package;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author gnuno
 */
public class GruposDAO extends Db_Conection{
    public GruposDAO()
    {
        super();
    }
    
    public boolean CrearGrupo(String nombre_grupo, int creador_grupo) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("INSERT INTO grupo (nombre_grupo, creador_grupo) values (?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, nombre_grupo);
            ps.setInt(2, creador_grupo);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int id_grupo = -1;
            if (rs.next()) {
                id_grupo = rs.getInt(1);
            }

            PreparedStatement ps2 = getConnection().prepareStatement("INSERT INTO pertenencias_grupo (grupo, usuario_perteneciente) values (?,?)");
            ps2.setInt(1, id_grupo);
            ps2.setInt(2, creador_grupo);
            ps2.executeUpdate();

            return true;
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean EnviarInvitacionGrupo(int id_grupo_invitado, int invitacion_de, int invitacion_para) 
    {
        try
        {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO invitacion_grupo (id_grupo_invitado, remitente_invitacion_grupo, destinatario_invitacion_grupo) values (?,?,?)");
        
        ps.setInt(1, id_grupo_invitado);
        ps.setInt(2, invitacion_de);
        ps.setInt(2, invitacion_para);

        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
      public boolean AceptarInvitacionGrupo(int id_grupo, int usuario_invitado) 
    {
        try
        {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO pertenencias_grupo (grupo, usuario_perteneciente) values (?,?)");
        
        ps.setInt(1, id_grupo);
        ps.setInt(2, usuario_invitado);
        
        PreparedStatement ps2 = getConnection().prepareStatement("DELETE FROM invitacion_grupo where id_grupo_invitado = ? AND destinatario_invitacion_grupo = ?");
        ps2.setInt(1, id_grupo);
        ps2.setInt(2, usuario_invitado);
        ps2.executeUpdate();

        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean RechazarInvitacionGrupo(int id_grupo, int usuario_invitado) 
    {
        try
        {
        PreparedStatement ps = getConnection().prepareStatement("DELETE FROM invitacion_grupo where id_grupo_invitado = ? AND destinatario_invitacion_grupo = ?");
        ps.setInt(1, id_grupo);
        ps.setInt(2, usuario_invitado);
       
        // Verificar cuantos usuarios en el grupo quedan y si quedan menos de 3, eliminarlo
        int numUsuarios = 0;
        PreparedStatement psCountPertenencias = getConnection().prepareStatement("SELECT COUNT(*) FROM pertenencias_grupo WHERE grupo = ?");
        psCountPertenencias.setInt(1, id_grupo);
        ResultSet rsCountPertenencias = psCountPertenencias.executeQuery();

        if (rsCountPertenencias.next()) {
            numUsuarios = rsCountPertenencias.getInt(1);
        }

        PreparedStatement psCountInvitaciones = getConnection().prepareStatement("SELECT COUNT(*) FROM invitacion_grupo  WHERE id_grupo_invitado = ?");
        psCountInvitaciones.setInt(1, id_grupo);
        ResultSet rsCountInvitaciones = psCountInvitaciones.executeQuery();

        if (rsCountInvitaciones.next()) {
            numUsuarios = numUsuarios + rsCountInvitaciones.getInt(1);
        }

        // Si hay menos de 3 usuarios, eliminar el grupo
        if (numUsuarios < 3) {
            EliminarGrupo(id_grupo);
        }

        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean SalirGrupo(int id_grupo, int usuario_invitado) {
        try {
            //Eliminar el usuario de pertenencias grupo
            PreparedStatement ps = getConnection().prepareStatement("DELETE FROM pertenencias_grupo where grupo = ? AND usuario_perteneciente = ?");
            ps.setInt(1, id_grupo);
            ps.setInt(2, usuario_invitado);

            // Verificar cuantos usuarios en el grupo quedan y si quedan menos de 3, eliminarlo
            int numUsuarios = 0;
            PreparedStatement psCountPertenencias = getConnection().prepareStatement("SELECT COUNT(*) FROM pertenencias_grupo WHERE grupo = ?");
            psCountPertenencias.setInt(1, id_grupo);
            ResultSet rsCountPertenencias = psCountPertenencias.executeQuery();

            if (rsCountPertenencias.next()) {
                numUsuarios = rsCountPertenencias.getInt(1);
            }

            PreparedStatement psCountInvitaciones = getConnection().prepareStatement("SELECT COUNT(*) FROM invitacion_grupo  WHERE id_grupo_invitado = ?");
            psCountInvitaciones.setInt(1, id_grupo);
            ResultSet rsCountInvitaciones = psCountInvitaciones.executeQuery();

            if (rsCountInvitaciones.next()) {
                numUsuarios = numUsuarios + rsCountInvitaciones.getInt(1);
            }

            // Si hay menos de 3 usuarios, eliminar el grupo
            if (numUsuarios < 3) {
                EliminarGrupo(id_grupo);
            }

            return ps.executeUpdate() > 0;
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
      
      public boolean EliminarGrupo(int id_grupo) 
    {
        try
        {
        //Eliminar los usuarios pertenecientes
        PreparedStatement ps = getConnection().prepareStatement("DELETE FROM pertenencias_grupo where grupo = ?");
        
        ps.setInt(1, id_grupo);
        ps.executeUpdate();
        
        //Eliminar las invitaciones
        PreparedStatement ps2 = getConnection().prepareStatement("DELETE FROM invitacion_grupo where id_grupo_invitado = ?");
        ps2.setInt(1, id_grupo);
        ps2.executeUpdate();

        //Eliminar los mensajes del grupo
        PreparedStatement ps3 = getConnection().prepareStatement("DELETE FROM mensaje_grupo where destinatario_grupo = ?");
        ps3.setInt(1, id_grupo);
        ps3.executeUpdate();

        //Eliminar el grupo
        PreparedStatement ps4 = getConnection().prepareStatement("DELETE FROM grupo where id_grupo = ?");
        ps4.setInt(1, id_grupo);

        return ps4.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    

}

