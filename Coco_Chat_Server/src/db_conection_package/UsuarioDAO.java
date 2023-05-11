package db_conection_package;

import static java.lang.String.valueOf;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnuno
 */
public class UsuarioDAO extends Db_Conection{
    public UsuarioDAO()
    {
        super();
    }
    
    public boolean RegistrarUsuario(Usuario usuario) 
    {
        try
        {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO usuario (nombre, username, password, correo, pregunta_respaldo, estado) values (?,?,?,?,?,?)");
        
        ps.setString(1, usuario.nombre);
        ps.setString(2, usuario.username);
        ps.setString(3, usuario.password);
        ps.setString(4, usuario.correo);
        ps.setString(5, usuario.pregunta_respaldo);
        ps.setInt(6, usuario.estado);
        
        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean IniciarSesion(String username, String password)
    {
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM usuario WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery(); 
            
            //Si las credenciales son correctas
            if(rs.next())
            {
                //Aqui necesitamos poner esta variable global o en algun cache para guardarla
                int id_usuario = rs.getInt("id_usuario");
                return true;
            }
            //Si las credenciales son incorrectas
            else
            {
                return false;
            }          
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return false;
    }
    
    public boolean RecuperarCuentaValidar(String username, String respuesta)
    {
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM usuario WHERE username=? AND pregunta_respaldo=?");
            ps.setString(1, username);
            ps.setString(2, respuesta);
            ResultSet rs = ps.executeQuery(); 
            
            //Si las credenciales son correctas
            if(rs.next())
            {
                return true;
            }
            //Si las credenciales son incorrectas
            else
            {
                return false;
            }          
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return false;
    }
    public boolean CambiarContrasena(String username, String password)
    {
        int res = 0;
        try 
        {
            PreparedStatement ps = getConnection()
                                .prepareStatement
                                ("UPDATE usuario SET password = ? WHERE username = ?");
            
            ps.setString(1, password);
            ps.setString(2, username);
            
            res = ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return res>0;
    }
    
    public String obtenerUsernameUsuario(int id)
    {
        try {
            PreparedStatement ps = getConnection().prepareStatement("SELECT username FROM usuario WHERE id_usuario=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                String username = rs.getString("username");
                return username;
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        return null;
        
    }
    
    public int ObtenerIDUsuario(String username)
    {
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT id_usuario FROM usuario WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery(); 
            
            //Si las credenciales son correctas
            if(rs.next())
            {
                //Aqui necesitamos poner esta variable global o en algun cache para guardarla
                int id_usuario = rs.getInt("id_usuario");
                return id_usuario;
            }  
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return -1;
    }
    
    public ArrayList<Usuario> obtenerUsuarios()
    {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM usuario");
            ResultSet rs;
            Usuario usuario;
            rs = ps.executeQuery(); 
                        
            while (rs.next())
            {
                usuario = new Usuario();
                usuario.nombre = rs.getString("nombre");
                usuario.username = rs.getString("username");
                usuario.estado = rs.getInt("estado");
                listaUsuarios.add(usuario);
            }            
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return listaUsuarios;
    }
    
    public ArrayList<Usuario> obtenerAmigos(int usuario)
    {
        ArrayList<Usuario> listaAmigos = new ArrayList();
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM amistad where (amigo1 = ? OR amigo2 = ?)");
            ps.setInt(1, usuario);
            ps.setInt(2, usuario);

            ResultSet rs;
            Usuario infoAmigo;
            rs = ps.executeQuery(); 
                        
            while (rs.next())
            {
                infoAmigo = new Usuario();
                infoAmigo.nombre = rs.getString("nombre");
                infoAmigo.username = rs.getString("username");
                infoAmigo.estado = rs.getInt("estado");
                listaAmigos.add(infoAmigo);
            }            
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return listaAmigos;
    }
    
    public ArrayList<Usuario> obtenerNoAmigos(int usuario)
    {
        ArrayList<Usuario> listaNoAmigos = new ArrayList();
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM usuario WHERE id_usuario <> ? AND id_usuario NOT IN (SELECT amigo2 FROM amistad WHERE amigo1 = ? UNION SELECT amigo1 FROM amistad WHERE amigo2 = ?)");
            ps.setInt(1, usuario);
            ps.setInt(2, usuario);
            ps.setInt(3, usuario);

            ResultSet rs;
            Usuario infoNoAmigo;
            rs = ps.executeQuery(); 

            while (rs.next())
            {
                infoNoAmigo = new Usuario();
                infoNoAmigo.nombre = rs.getString("nombre");
                infoNoAmigo.username = rs.getString("username");
                infoNoAmigo.estado = rs.getInt("estado");
                listaNoAmigos.add(infoNoAmigo);
            }            
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return listaNoAmigos;
    }
    
    public ArrayList<Grupo> obtenerGrupos(int usuario)
    {
        ArrayList<Grupo> listaGrupos = new ArrayList();
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM pertenencias_grupo where usuario_perteneciente = ?");
            ps.setInt(1, usuario);

            ResultSet rs;
            Grupo infoGrupo;
            rs = ps.executeQuery(); 
                        
            while (rs.next())
            {
                infoGrupo = new Grupo();
                infoGrupo.nombre_grupo = rs.getString("nombre_grupo");
                listaGrupos.add(infoGrupo);
            }            
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return listaGrupos;
    }
    
    public boolean ConectarUsuario(String username)
    {
        int res = 0;
        try 
        {
            PreparedStatement ps = getConnection()
                                .prepareStatement
                                ("UPDATE usuario SET estado = 1 WHERE username = ?");
            
            ps.setString(1, username);
            
            res = ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return res>0;
    }
   
    public boolean DesconectarUsuario(String username)
    {
        int res = 0;
        try 
        {
            PreparedStatement ps = getConnection()
                                .prepareStatement
                                ("UPDATE usuario SET estado = 0 WHERE username = ?");
            
            ps.setString(1, username);
            
            res = ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return res>0;
    }
   
}

